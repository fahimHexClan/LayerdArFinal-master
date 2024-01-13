package lk.ijse.policeStation.Dao;

import lk.ijse.policeStation.dto.UserDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDao {
      boolean validateUser(UserDto userDto) throws SQLException, ClassNotFoundException;
     ArrayList<String> loadUserIds() throws SQLException, ClassNotFoundException;
      boolean registerUser(UserDto userDto) throws SQLException, ClassNotFoundException;




    }
