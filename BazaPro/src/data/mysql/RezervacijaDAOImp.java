package data.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import data.RezervacijeDataAccess;
import entity.Rezervacija;
import entity.RezervacijeView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RezervacijaDAOImp implements RezervacijeDataAccess {

	@Override
	public ObservableList<RezervacijeView> sveRezeracije() {
		ArrayList<RezervacijeView> rezervacije = new ArrayList<>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select * from prikaz_rezervacija";

		try {
			connection = ConnectionPool.getInstance().checkOut();
			StringBuilder sql;
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				rezervacije.add(new RezervacijeView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, connection);
		}
		return FXCollections.observableArrayList(rezervacije);
	}

	@Override
	public boolean dodaj(Rezervacija rezervacija) {
		boolean res = false;
		Connection conn = null;
		CallableStatement ps = null;

		String query = "{call dodaj_rezervaciju(?, ?, ?, ?, ?, ?, ?, ?)}";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareCall(query);
			ps.setString(1, rezervacija.getPutnikID().getIme());
			ps.setString(2, rezervacija.getPutnikID().getPrezime());
			ps.setString(3, rezervacija.getPutnikID().getJmb());
			ps.setString(4, rezervacija.getPutnikID().getPasos());
			ps.setDate(5, rezervacija.getDate());
			ps.setInt(6, rezervacija.getSluzbenikID().getOsobaID());
			ps.setInt(7, rezervacija.getKlasaID().getKlasaID());
			ps.setInt(8, rezervacija.getLetID().getLetID());

			res = ps.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.close(ps, conn);
		}
		return res;
	}

	@Override
	public boolean obrisi(int id) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;
		String query = "delete from rezervacija where RezervacijaId=?";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			retVal = ps.executeUpdate() == 1;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.close(ps, conn);
		}
		return retVal;
	}

	@Override
	public boolean azuriraj(Rezervacija r) {
		boolean res = false;
		Connection conn = null;
		CallableStatement ps = null;

		String query = "{call azuriraj_rezervaciju(?, ?)}";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareCall(query);
			ps.setInt(1, r.getRezervacijaID());
			ps.setInt(2, r.getKlasaID().getKlasaID());

			res = ps.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.close(ps, conn);
		}
		return res;
	}

	@Override
	public ObservableList<RezervacijeView> sortiraj(String klasa) {
		ArrayList<RezervacijeView> rezervacije = new ArrayList<>();
		Connection conn = null;
		CallableStatement ps = null;
		ResultSet rs = null;
		String query = "{call pregled_po_klasi(?)}";

		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareCall(query);
			ps.setString(1, klasa);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				rezervacije.add(new RezervacijeView(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			DBUtil.close(ps, conn);
		}
		return FXCollections.observableArrayList(rezervacije);
	}
}
