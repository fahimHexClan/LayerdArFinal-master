package lk.ijse.policeStation.Bo.Custom.Impl;

import lk.ijse.policeStation.Bo.Custom.VehicleBo;
import lk.ijse.policeStation.Dao.VehicleDao;
import lk.ijse.policeStation.Dao.custom.Impl.VehicleDaoImpl;
import lk.ijse.policeStation.Entity.PoliceReport;
import lk.ijse.policeStation.Entity.Vehicale;
import lk.ijse.policeStation.dto.PoliceReportDto;
import lk.ijse.policeStation.dto.VehicleDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleBoImpl implements VehicleBo {
    private final VehicleDao vehicleDao = new VehicleDaoImpl();

    public boolean deleteVehicle(String id) throws SQLException, ClassNotFoundException {
        return vehicleDao.delete(id);
    }

    public boolean saveVehicle(VehicleDto vehicleDto) throws SQLException, ClassNotFoundException {
        return vehicleDao.save(new Vehicale(vehicleDto.getTxtVehicleId(),vehicleDto.getTxtEngineNum(),vehicleDto.getTxtOwnerId(),
                vehicleDto.getTxtPlateNum(),vehicleDto.getTxtVehicleType(),vehicleDto.getTxtModelId()));
    }

    public ArrayList<VehicleDto> getAllVehicle() throws SQLException, ClassNotFoundException {
        List<Vehicale> allReports = vehicleDao.getAllVehicle();
        ArrayList<VehicleDto> vehicleDtos = new ArrayList<>();

        for (Vehicale vehicale : allReports) {
            vehicleDtos.add(new VehicleDto(
                    vehicale.getTxtVehicleId(),vehicale.getTxtEngineNum(),vehicale.getTxtOwnerId(),
                    vehicale.getTxtPlateNum(),vehicale.getTxtVehicleType(),vehicale.getTxtModelId()
            ));
        }return vehicleDtos;
    }

    public Optional<VehicleDto> searchVehicle(String code) throws SQLException, ClassNotFoundException {
        Optional<Vehicale> vehicale = vehicleDao.search(code);

        return vehicale.map(this::convertToDto);
    }

    private VehicleDto convertToDto(Vehicale vehicale) {
        return new VehicleDto(
                vehicale.getTxtVehicleId(),vehicale.getTxtEngineNum(),vehicale.getTxtOwnerId(),
                vehicale.getTxtPlateNum(),vehicale.getTxtVehicleType(),vehicale.getTxtModelId()
        );
    }


    public boolean updateVehicle(VehicleDto updatedVehicleDto) throws SQLException, ClassNotFoundException {
        return vehicleDao.update(new Vehicale(updatedVehicleDto.getTxtVehicleId(),updatedVehicleDto.getTxtEngineNum(),updatedVehicleDto.getTxtOwnerId(),
                updatedVehicleDto.getTxtPlateNum(),updatedVehicleDto.getTxtVehicleType(),updatedVehicleDto.getTxtModelId()));
    }
}
