package lk.ijse.policeStation.Dao.custom.Impl;

import lk.ijse.policeStation.Dao.DriverDao;
import lk.ijse.policeStation.Entity.Driver;
import lk.ijse.policeStation.dto.FinesDto;
import lk.ijse.policeStation.util.CrudUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class DriverDaoImpl implements DriverDao {
    @Override
    public  boolean save(Driver driver) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "INSERT INTO Driver(DriverId, DriverName, address, contactNumber, gender, Dob, licenseNum, VehicleId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, driverDto.getTxtDriverId());
            stm.setString(2, driverDto.getTxtDriverName());
            stm.setString(3, driverDto.getTxtAddress());
            stm.setString(4, driverDto.getTxtContactNumber());
            stm.setString(5, driverDto.getTxtGender());
            stm.setString(6, driverDto.getTxtDob());
            stm.setString(7, driverDto.getTxtLicenseNumber());
            stm.setString(8, driverDto.getCmbVehicleId());

            int affectedRows = stm.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        return CrudUtil.execute("INSERT INTO Driver(DriverId, DriverName, address, contactNumber, gender, Dob, licenseNum, VehicleId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                driver.getTxtDriverId(), driver.getTxtDriverName(), driver.getTxtAddress(),
                driver.getTxtContactNumber(), driver.getTxtGender(), driver.getTxtDob(),
                driver.getTxtLicenseNumber(), driver.getCmbVehicleId());
    }

    @Override
    public  ArrayList<Driver> getAllDrivers() throws SQLException, ClassNotFoundException {
      /*  Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Driver";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();*/
       /* ResultSet rs = CrudUtil.execute("SELECT * FROM Driver");
        ArrayList<Driver> List = new ArrayList<>();
        while (rs.next()) {
            String DriverId = rs.getString(1);
            String DriverName = rs.getString(2);
            String address = rs.getString(3);
            String contactNumber = rs.getString(4);
            String gender = rs.getString(5);
            String Dob = rs.getString(6);
            String licenseNum = rs.getString(7);
            String VehicleId = rs.getString(8);

            Driver driver = new Driver();

            driver.setTxtDriverId(DriverId);
            driver.setTxtDriverName(DriverName);
            driver.setTxtAddress(address);
            driver.setTxtContactNumber(contactNumber);
            driver.setTxtGender(gender);
            driver.setTxtDob(Dob);
            driver.setTxtLicenseNumber(licenseNum);
            driver.setCmbVehicleId(VehicleId);


            List.add(driver);
        }
        return List;
*/
        ArrayList<Driver> list = new ArrayList<>();
        ResultSet rs = CrudUtil.execute("SELECT * FROM Driver");
        while (rs.next()) {
            list.add(new Driver(rs.getString("DriverId"),rs.getString("DriverName"), rs.getString("address"),
                    rs.getString("contactNumber"), rs.getString("gender"),rs.getString("Dob"),
                    rs.getString("licenseNum"),rs.getString("VehicleId"),rs.getString("FinesStatus")));
        }
        return list;
    }
    @Override
    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
       /* Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "DELETE FROM Driver WHERE DriverId=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, id);
        int affectedRows = stm.executeUpdate();
        if (affectedRows > 0) {
            return true;
        } else {
            return false;
        }*/
        return CrudUtil.execute("DELETE FROM Driver WHERE DriverId=?", id);
    }
    @Override
    public  Optional<Driver> search(String code) throws SQLException, ClassNotFoundException {
       /* Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Driver WHERE DriverId=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, code);
        ResultSet rs = stm.executeQuery();*/
       /* ResultSet rs = CrudUtil.execute("SELECT * FROM Driver WHERE DriverId=?", code);


        if (rs.next()) {
            String DriverId = rs.getString(1);
            String DriverName = rs.getString(2);
            String address = rs.getString(3);
            String contactNumber = rs.getString(4);
            String gender = rs.getString(5);
            String Dob = rs.getString(6);
            String licenseNum = rs.getString(7);
            String VehicleId = rs.getString(8);

            Driver driver = new Driver();
            driver.setTxtDriverId(DriverId);
            driver.setTxtDriverName(DriverName);
            driver.setTxtAddress(address);
            driver.setTxtContactNumber(contactNumber);
            driver.setTxtGender(gender);
            driver.setTxtDob(Dob);
            driver.setTxtLicenseNumber(licenseNum);
            driver.setCmbVehicleId(VehicleId);

            return Optional.of(driver);

        } else {
            return Optional.empty();
        }*/
        ResultSet rst = CrudUtil.execute("SELECT * FROM Driver WHERE DriverId=?",code);
        if (rst.next()) {
            return Optional.of(new Driver(code,rst.getString("DriverName"), rst.getString("address"),
                    rst.getString("contactNumber"), rst.getString("gender"),rst.getString("Dob"),
                    rst.getString("licenseNum"),rst.getString("VehicleId"),rst.getString("FinesStatus")));
        } else {
            return Optional.empty();
        }
    }
    @Override
    public  boolean update(Driver updatedDriver) throws SQLException, ClassNotFoundException {
      /*  Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE Driver SET DriverName=?, address=?, contactNumber=?, gender=?, Dob=?, licenseNum=?, VehicleId=?  WHERE DriverId=?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1,  updatedDriver.getTxtDriverName());
            stm.setString(2, updatedDriver.getTxtAddress());
            stm.setString(3, updatedDriver.getTxtContactNumber());
            stm.setString(4, updatedDriver.getTxtGender());
            stm.setString(5, updatedDriver.getTxtDob());
            stm.setString(6, updatedDriver.getTxtLicenseNumber());
            stm.setString(7, updatedDriver.getCmbVehicleId());
            stm.setString(8, updatedDriver.getTxtDriverId());

            int affectedRows = stm.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        return CrudUtil.execute("UPDATE Driver SET DriverName=?, address=?, contactNumber=?, gender=?, Dob=?, licenseNum=?, VehicleId=?  WHERE DriverId=?",
                updatedDriver.getTxtDriverName(), updatedDriver.getTxtAddress(), updatedDriver.getTxtContactNumber(),
                updatedDriver.getTxtGender(), updatedDriver.getTxtDob(), updatedDriver.getTxtLicenseNumber(),
                updatedDriver.getCmbVehicleId(), updatedDriver.getTxtDriverId());
    }
    @Override
    public  ArrayList<String> getAllDriverIds() throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT DriverId FROM Driver";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
*/
        ResultSet rs = CrudUtil.execute("SELECT DriverId FROM Driver");
        ArrayList<String> driverIds = new ArrayList<>();
        while (rs.next()) {
            String driverId = rs.getString("DriverId");
            driverIds.add(driverId);
        }
        return driverIds;
    }
    @Override
    public  boolean updateStatus(FinesDto fines , String driver_id) throws SQLException, ClassNotFoundException {
        String sql="UPDATE Driver SET FinesStatus=? where DriverId=?";
        return CrudUtil.execute(sql,fines.getTxtFinesDescrip(),driver_id);
    }
}
