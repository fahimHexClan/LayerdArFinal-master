package lk.ijse.policeStation.Dao;

import lk.ijse.policeStation.Entity.Driver;
import lk.ijse.policeStation.dto.FinesDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DriverDao extends CrudDao<Driver>{
     ArrayList<Driver> getAllDrivers() throws SQLException, ClassNotFoundException ;
     ArrayList<String> getAllDriverIds() throws SQLException, ClassNotFoundException ;
     boolean updateStatus(FinesDto fines , String driver_id) throws SQLException, ClassNotFoundException;
}
