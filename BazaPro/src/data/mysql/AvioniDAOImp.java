package data.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data.AvionDAO;
import entity.Avion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AvioniDAOImp implements AvionDAO{

	@Override
	public ObservableList<Avion> sviAvioni() {
		ArrayList<Avion> avioni = new ArrayList<>();
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "select * from avion";

		try {
			connection = ConnectionPool.getInstance().checkOut();
			StringBuilder sql;
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				avioni.add(new Avion(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, connection);
		}
		return FXCollections.observableArrayList(avioni);
	}

}
