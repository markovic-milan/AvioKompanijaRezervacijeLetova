package data.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.ZaposleniDataAccess;
import entity.Zaposleni;

public class ZaposleniDataAccessImp implements ZaposleniDataAccess{

	@Override
	public List<Zaposleni> sveOsobe() {
		List<Zaposleni> zaposleni = new ArrayList<>();
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
		//		zaposleni.add(new Zaposleni(rs.getInt(2), rs.getInt(4), rs.getInt(6), rs.getInt(5), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, connection);
		}
		return zaposleni;
	}

	@Override
	public boolean dodajOsobu(Zaposleni o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean obrisiOsobu(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean azurirajOsobu(Zaposleni o) {
		// TODO Auto-generated method stub
		return false;
	}

}
