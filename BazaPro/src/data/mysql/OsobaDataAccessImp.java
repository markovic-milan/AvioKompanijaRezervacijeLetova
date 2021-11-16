package data.mysql;

import java.sql.*;
import java.util.*;

import data.OsobaDataAccess;
import entity.Osoba;

public class OsobaDataAccessImp implements OsobaDataAccess {

	@Override
	public List<Osoba> sveOsobe() {
		List<Osoba> osobe = new ArrayList<>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select * from osoba";

		try {
			connection = ConnectionPool.getInstance().checkOut();
			StringBuilder sql;
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				osobe.add(new Osoba(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, connection);
		}
		return osobe;
	}

	@Override
	public boolean dodajOsobu(Osoba o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean obrisiOsobu(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean azurirajOsobu(Osoba o) {
		// TODO Auto-generated method stub
		return false;
	}

}
