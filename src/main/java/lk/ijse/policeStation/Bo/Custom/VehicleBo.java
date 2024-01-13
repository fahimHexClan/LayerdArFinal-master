package lk.ijse.policeStation.Bo.Custom;

import lk.ijse.policeStation.dto.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public interface VehicleBo {
    boolean deleteVehicle(String id) throws SQLException, ClassNotFoundException;

    boolean saveVehicle(VehicleDto vehicleDto) throws SQLException, ClassNotFoundException;

    ArrayList<VehicleDto> getAllVehicle() throws SQLException, ClassNotFoundException;

    Optional<VehicleDto> searchVehicle(String code) throws SQLException, ClassNotFoundException;

    boolean updateVehicle(VehicleDto updatedVehicleDto) throws SQLException, ClassNotFoundException;
}
