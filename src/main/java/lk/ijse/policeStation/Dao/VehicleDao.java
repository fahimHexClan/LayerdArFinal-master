package lk.ijse.policeStation.Dao;

import lk.ijse.policeStation.Entity.Vehicale;
import lk.ijse.policeStation.dto.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface VehicleDao extends CrudDao<Vehicale>{
    ArrayList<Vehicale> getAllVehicle() throws SQLException, ClassNotFoundException;
    ArrayList<String> getAllVehicleIds() throws SQLException, ClassNotFoundException;

}
