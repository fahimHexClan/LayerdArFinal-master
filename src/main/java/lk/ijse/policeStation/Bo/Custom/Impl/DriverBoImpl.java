package lk.ijse.policeStation.Bo.Custom.Impl;

import lk.ijse.policeStation.Bo.Custom.DriverBo;
import lk.ijse.policeStation.Dao.DriverDao;
import lk.ijse.policeStation.Dao.custom.Impl.DriverDaoImpl;
import lk.ijse.policeStation.Entity.Driver;
import lk.ijse.policeStation.dto.DriverDto;
import lk.ijse.policeStation.dto.FinesDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DriverBoImpl implements DriverBo {
    private final DriverDao driverDao = new DriverDaoImpl();

    public ArrayList<DriverDto> getAllDrivers() throws SQLException, ClassNotFoundException {
        List<Driver> drivers = driverDao.getAllDrivers();
        ArrayList<DriverDto> driverDtos = new ArrayList<>();

        for (Driver driver : drivers) {
            driverDtos.add(new DriverDto(
                    driver.getTxtDriverId(),driver.getTxtDriverName(),driver.getTxtAddress(),driver.getTxtContactNumber(),
                    driver.getTxtGender(),driver.getTxtDob(),driver.getTxtLicenseNumber(),driver.getCmbVehicleId()
            ,driver.getFinesStatus()));
        }
        return driverDtos;
    }

    public boolean deleteDriver(String id) throws SQLException, ClassNotFoundException {
        return driverDao.delete(id);
    }

    public boolean saveDriver(DriverDto driverDto) throws SQLException, ClassNotFoundException {
        return driverDao.save(new Driver(driverDto.getTxtDriverId(),driverDto.getTxtDriverName(),driverDto.getTxtAddress(),driverDto.getTxtContactNumber(),
                driverDto.getTxtGender(),driverDto.getTxtDob(),driverDto.getTxtLicenseNumber(),driverDto.getCmbVehicleId(),driverDto.getFinesStatus()));
    }

    public Optional<DriverDto> searchDriver(String code) throws SQLException, ClassNotFoundException {
        Optional<Driver> optionalDriver = driverDao.search(code);

        return optionalDriver.map(this::convertToDto);
    }

    private DriverDto convertToDto(Driver driver) {
        return new DriverDto(
                driver.getTxtDriverId(),driver.getTxtDriverName(),driver.getTxtAddress(),driver.getTxtContactNumber(),
                driver.getTxtGender(),driver.getTxtDob(),driver.getTxtLicenseNumber(),driver.getCmbVehicleId(),driver.getFinesStatus());
    }

    public boolean updateDriver(DriverDto updatedDriver) throws SQLException, ClassNotFoundException {
        return driverDao.update(new Driver(updatedDriver.getTxtDriverId(),updatedDriver.getTxtDriverName(),updatedDriver.getTxtAddress(),updatedDriver.getTxtContactNumber(),
                updatedDriver.getTxtGender(),updatedDriver.getTxtDob(),updatedDriver.getTxtLicenseNumber(),updatedDriver.getCmbVehicleId(),updatedDriver.getFinesStatus()));
    }
    public boolean updateStatus(FinesDto updatedFines, String value) throws SQLException, ClassNotFoundException {
        boolean isUpdated = driverDao.updateStatus(updatedFines, value);
        return isUpdated;
    }
    public ArrayList<String> getAllDriverIds() throws SQLException, ClassNotFoundException {
        return driverDao.getAllDriverIds();
    }
}


