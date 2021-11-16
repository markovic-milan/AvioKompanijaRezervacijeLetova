package data.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.LetoviDAO;
import entity.Let;
import entity.LetView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LetDAOImp implements LetoviDAO {

	@Override
	public ObservableList<LetView> sviLetovi() {
		ArrayList<LetView> letovi = new ArrayList<>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select * from prikaz_letova";

		try {
			connection = ConnectionPool.getInstance().checkOut();
			StringBuilder sql;
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				letovi.add(new LetView(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getDate(6),rs.getInt(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, connection);
		}
		return FXCollections.observableArrayList(letovi);
	}

	@Override
	public int dodajLet(Let let) {
		int retVal = 0;
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "insert into let (Distanca, AvionID, LinijaID, PosadaID, DatumLeta) values"
				+ " (?, ?, ?, ?, ?)";
		try {
			c = DBUtil.getConnection();
			ps = c.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, let.getDistanca());
			ps.setInt(2, let.getAvionID().getAvioID());
			ps.setInt(3, let.getLinijaID().getLinijaID());
			ps.setInt(4, let.getPosadaID().getPosadaID());
			ps.setDate(5, let.getDatumLeta());

			retVal = ps.executeUpdate();
			if (retVal != 0) {
				rs = ps.getGeneratedKeys();
				if (rs.next())
					let.setLetID(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, c);
		}
		return retVal;

	}

	@Override
	public ObservableList<LetView> sviLetoviSortiraniPoDistanci() {
		ArrayList<LetView> letovi = new ArrayList<>();
		Connection connection = null;
		CallableStatement ps = null;
		ResultSet rs = null;
		String query = "{call sortiraj_po_distanci()}";


		try {
			connection = ConnectionPool.getInstance().checkOut();
			StringBuilder sql;
			ps = connection.prepareCall(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				letovi.add(new LetView(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getDate(6),rs.getInt(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, connection);
		}
		return FXCollections.observableArrayList(letovi);
	}

}
