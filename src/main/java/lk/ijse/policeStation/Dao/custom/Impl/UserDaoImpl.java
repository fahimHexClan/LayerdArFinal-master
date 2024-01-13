package lk.ijse.policeStation.Dao.custom.Impl;

import lk.ijse.policeStation.Dao.UserDao;
import lk.ijse.policeStation.dto.UserDto;
import lk.ijse.policeStation.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {
    @Override
    public  boolean validateUser(UserDto userDto) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT COUNT(*) FROM User WHERE  UserName = ? AND Password = ? And UserId = ?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setObject(1, userDto.getUsrName());
            stm.setObject(2, userDto.getPassword());
            stm.setObject(3, userDto.getUsrId());

            ResultSet resultSet = stm.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }
        return false;*/
        ResultSet resultSet = CrudUtil.execute("SELECT COUNT(*) FROM User WHERE UserName = ? AND Password = ? And UserId = ?",
                userDto.getUsrName(), userDto.getPassword(), userDto.getUsrId());

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0;
        }

        return false;
    }


    public  ArrayList<String> loadUserIds() throws SQLException, ClassNotFoundException {
       /* Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT UserId FROM User";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            ResultSet resultSet = stm.executeQuery();

            ArrayList<String> userIds = new ArrayList<>();
            while (resultSet.next()) {
                userIds.add(resultSet.getString("UserId"));
            }

            return userIds;
        }*/
        ResultSet resultSet = CrudUtil.execute("SELECT UserId FROM User");

        ArrayList<String> userIds = new ArrayList<>();
        while (resultSet.next()) {
            userIds.add(resultSet.getString("UserId"));
        }

        return userIds;

    }

    public  boolean registerUser(UserDto userDto) throws SQLException, ClassNotFoundException {
       /* Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "INSERT INTO User (UserName, Password, UserId) VALUES (?, ?, ?)";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setObject(1, userDto.getUsrName());
            stm.setObject(2, userDto.getPassword());
            stm.setObject(3, userDto.getUsrId());

            int affectedRows = stm.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        return CrudUtil.execute("INSERT INTO User (UserName, Password, UserId) VALUES (?, ?, ?)",
                userDto.getUsrName(),userDto.getPassword(),userDto.getUsrId());
    }
}
