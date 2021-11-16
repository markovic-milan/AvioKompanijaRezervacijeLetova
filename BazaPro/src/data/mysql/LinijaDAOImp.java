package data.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.LinijaDAO;
import entity.Aerodrom;
import entity.Linija;
import entity.LinijeView;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LinijaDAOImp implements LinijaDAO {

	@Override
	public ObservableList<LinijeView> sveLinije() {
		ArrayList<LinijeView> linije = new ArrayList<>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select * from prikaz_linija";

		try {
			connection = ConnectionPool.getInstance().checkOut();
			StringBuilder sql;
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				linije.add(new LinijeView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, connection);
		}
		return FXCollections.observableArrayList(linije);
	}

	@Override
	public int dodajLiniju(Linija linija) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "insert into linija (VrijemePolaska, VrijemeDolaska, OdAerodromID, DoAerodromID) values"
				+ " (?, ?, (SELECT AerodromID FROM aerodrom WHERE naziv = ?), (SELECT AerodromID FROM aerodrom WHERE naziv = ?))";
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setTime(1, linija.getVrijemePolaska());
			ps.setTime(2, linija.getVrijemeDolaska());
			ps.setString(3, linija.getOdAerodrom().getNaziv());
			ps.setString(4, linija.getDoAerodrom().getNaziv());
			retVal = ps.executeUpdate();
			if (retVal != 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next())
					linija.setLinijaID(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, c);
		}
		return retVal;
	}

	@Override
	public boolean obrisiLiniju(int id) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String query = "delete from linija where LinijaId=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			retVal = ps.executeUpdate() == 1;
		} catch (SQLException ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Nije moguce obrisati koristenu liniju");
			alert.setTitle("Greska");
			alert.showAndWait();
		} finally {
			DBUtil.close(ps, conn);
		}
		return retVal;

	}

	@Override
	public boolean azurirajLiniju(Linija linija) {
		boolean res = false;
		Connection conn = null;
		CallableStatement ps = null;

		String query = "{call azuriraj_liniju(?, ?, ?, ?, ?)}";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareCall(query);
			ps.setInt(1, linija.getLinijaID());
			ps.setInt(2, linija.getOdAerodrom().getAerodromID());
			ps.setInt(3, linija.getDoAerodrom().getAerodromID());
			ps.setTime(4, linija.getVrijemePolaska());
			ps.setTime(5, linija.getVrijemeDolaska());

			res = ps.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.close(ps, conn);
		}
		return res;
	}

}
