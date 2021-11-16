package data.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.AerodromDataAccess;
import entity.Adresa;
import entity.Aerodrom;
import entity.Zaposleni;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AerodromDataAccessImp implements AerodromDataAccess {

	@Override
	public ObservableList<Aerodrom> sviAerodromi() {
		List<Aerodrom> aerodromi = new ArrayList<>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select a.AerodromID, a.Naziv, ad.Grad, ad.Drzava from aerodrom a inner join adresa ad on a.AdresaID=ad.AdresaID;";

		try {
			connection = ConnectionPool.getInstance().checkOut();
			StringBuilder sql;
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				aerodromi
						.add(new Aerodrom(rs.getInt(1), rs.getString(2), new Adresa(rs.getString(3), rs.getString(4))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, connection);
		}
		return FXCollections.observableArrayList(aerodromi);
	}

	@Override
	public boolean dodajOsobu(Aerodrom o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean obrisiOsobu(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean azurirajOsobu(Aerodrom o) {
		// TODO Auto-generated method stub
		return false;
	}

}
