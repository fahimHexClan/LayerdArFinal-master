package lk.ijse.policeStation.Dao.custom.Impl;

import lk.ijse.policeStation.DB.DatabaseConnection;
import lk.ijse.policeStation.Dao.OfficerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OfficerDaoImpl implements OfficerDao {
    @Override
    //ids tika txtfield eke load wenna hadapu eka
    public  ArrayList<String> getOfficerIds() throws SQLException, ClassNotFoundException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT OfficerId FROM officer";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            ResultSet resultSet = stm.executeQuery();

            ArrayList<String> officerIds = new ArrayList<>();
            while (resultSet.next()) {
                officerIds.add(resultSet.getString("OfficerId"));
            }

            return officerIds;
        }
    }

}
