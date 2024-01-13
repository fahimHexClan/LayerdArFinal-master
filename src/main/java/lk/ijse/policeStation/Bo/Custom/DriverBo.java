package lk.ijse.policeStation.Bo.Custom;

import lk.ijse.policeStation.dto.DriverDto;
import lk.ijse.policeStation.dto.FinesDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public interface DriverBo {

    ArrayList<DriverDto> getAllDrivers() throws SQLException, ClassNotFoundException;

    boolean deleteDriver(String id) throws SQLException, ClassNotFoundException;

    boolean saveDriver(DriverDto driverDto) throws SQLException, ClassNotFoundException;

    Optional<DriverDto> searchDriver(String code) throws SQLException, ClassNotFoundException;

    boolean updateDriver(DriverDto updatedDriver) throws SQLException, ClassNotFoundException;


    boolean updateStatus(FinesDto updatedFines, String value) throws SQLException, ClassNotFoundException;

    ArrayList<String> getAllDriverIds() throws SQLException, ClassNotFoundException;
}
