package lk.ijse.policeStation.Dao.custom.Impl;

import lk.ijse.policeStation.DB.DatabaseConnection;
import lk.ijse.policeStation.Dao.EmployeesDao;
import lk.ijse.policeStation.Entity.Citizen;
import lk.ijse.policeStation.Entity.Employees;
import lk.ijse.policeStation.dto.CitizenDto;
import lk.ijse.policeStation.dto.EmployeesDto;
import lk.ijse.policeStation.util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class EmployeesDaoImpl implements EmployeesDao {
    @Override
    public  boolean save(Employees employees) throws SQLException, ClassNotFoundException {
/*        try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stm = connection.prepareStatement(
                     "INSERT INTO Employee (EmployeeId, EmpName, address, contactNumber, gender, " +
                             "EmployeeType, Ranking, dob, OfficerId, UserId, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

            stm.setString(1, employeesDto.getTxtEmpId());
            stm.setString(2, employeesDto.getTxtEmpName());
            stm.setString(3, employeesDto.getTxtAddress());
            stm.setString(4, employeesDto.getTxtContactNumber());
            stm.setString(5, employeesDto.getTxtGender());
            stm.setString(6, employeesDto.getTxtEmpType());
            stm.setString(7, employeesDto.getTxtRank());
            stm.setString(8, employeesDto.getTxtDob());
            stm.setString(9, employeesDto.getTxtOfficerId());
            stm.setString(10, employeesDto.getTxtUsrId());

            byte[] photoBytes = employeesDto.getImageData();
            if (photoBytes != null) {
                try (ByteArrayInputStream inputStream = new ByteArrayInputStream(photoBytes)) {
                    stm.setBlob(11, inputStream);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                stm.setNull(11, java.sql.Types.BLOB);
            }

            int affectedRows = stm.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException | ClassNotFoundException e) {
            // Handle exceptions appropriately (e.g., log or show an error message)
            e.printStackTrace();
            return false;
        }*/
        return CrudUtil.execute("INSERT INTO Employee (EmployeeId, EmpName, address, contactNumber, gender, EmployeeType, Ranking, dob, OfficerId, UserId, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                employees.getTxtEmpId(), employees.getTxtEmpName(), employees.getTxtAddress(), employees.getTxtContactNumber(),
                employees.getTxtGender(), employees.getTxtEmpType(), employees.getTxtRank(), employees.getTxtDob(),
                employees.getTxtOfficerId(), employees.getTxtUsrId(), employees.getImgEmployee());


    }
    @Override
    public  Optional<Employees> search(String code) throws SQLException, ClassNotFoundException {
       /* Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Employee WHERE EmployeeId=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, code);
        ResultSet rs = stm.executeQuery();*/
       /* ResultSet rs =CrudUtil.execute("SELECT * FROM Employee WHERE EmployeeId=?",code);


        if (rs.next()) {
            String empId = rs.getString(1);
            String empName = rs.getString(2);
            String address = rs.getString(3);
            String contactNumber = rs.getString(4);
            String gender = rs.getString(5);
            String EmployeeType = rs.getString(6);
            String ranking = rs.getString(7);
            String dob = rs.getString(8);
            String officerId = rs.getString(9);
            String userId = rs.getString(10);
            Blob empImgBlob = rs.getBlob(11);

            Employees employees = new Employees();
            employees.setTxtEmpId(empId);
            employees.setTxtEmpName(empName);
            employees.setTxtAddress(address);
            employees.setTxtContactNumber(contactNumber);
            employees.setTxtGender(gender);
            employees.setTxtEmpType(EmployeeType);
            employees.setTxtRank(ranking);
            employees.setTxtDob(dob);
            employees.setTxtOfficerId(officerId);
            employees.setTxtUsrId(userId);

            // Convert Blob to byte array
            if (empImgBlob != null) {
                byte[] empImgBytes = empImgBlob.getBytes(1, (int) empImgBlob.length());
                employees.setImgEmployee(empImgBytes);
            } else {
                employees.setImgEmployee(null);
            }

            return Optional.of(employees);

        } else {
            return Optional.empty();
        }
    }*/
        ResultSet rst = CrudUtil.execute("SELECT * FROM Employee WHERE EmployeeId=?", code);
        if (rst.next()) {
            return Optional.of(new Employees(code, rst.getString("EmpName"), rst.getString("address"),
                    rst.getString("contactNumber"), rst.getString("gender"), rst.getString("EmployeeType"),
                    rst.getString("Ranking"),rst.getString("dob"),rst.getString("OfficerId"),
                    rst.getString("UserId"),rst.getBytes("photo")));
        } else {
            return Optional.empty();
        }
    }
    @Override
    public  boolean update(Employees updatedEmployee) throws SQLException, ClassNotFoundException {
       /* Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE Employee SET EmpName=?, address=?, contactNumber=?, gender=?, EmployeeType=?, Ranking=?, dob=?, OfficerId=?, UserId=?, photo=? WHERE EmployeeId=?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, updatedEmployeeDto.getTxtEmpName());
            stm.setString(2, updatedEmployeeDto.getTxtAddress());
            stm.setString(3, updatedEmployeeDto.getTxtContactNumber());
            stm.setString(4, updatedEmployeeDto.getTxtGender());
            stm.setString(5, updatedEmployeeDto.getTxtEmpType());
            stm.setString(6, updatedEmployeeDto.getTxtRank());
            stm.setString(7, updatedEmployeeDto.getTxtDob());
            stm.setString(8, updatedEmployeeDto.getTxtOfficerId());
            stm.setString(9, updatedEmployeeDto.getTxtUsrId());

            byte[] photoBytes = updatedEmployeeDto.getImageData();
            if (photoBytes != null) {
                try (ByteArrayInputStream inputStream = new ByteArrayInputStream(photoBytes)) {
                    stm.setBlob(10, inputStream);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                stm.setNull(10, java.sql.Types.BLOB);
            }

            stm.setString(11, updatedEmployeeDto.getTxtEmpId());

            int affectedRows = stm.executeUpdate();
            return affectedRows > 0;
        }*/
        return CrudUtil.execute("UPDATE Employee SET EmpName=?, address=?, contactNumber=?, gender=?, EmployeeType=?, Ranking=?, dob=?, OfficerId=?, UserId=?, photo=? WHERE EmployeeId=?",
                updatedEmployee.getTxtEmpName(), updatedEmployee.getTxtAddress(), updatedEmployee.getTxtContactNumber(),
                updatedEmployee.getTxtGender(), updatedEmployee.getTxtEmpType(), updatedEmployee.getTxtRank(), updatedEmployee.getTxtDob(),
                updatedEmployee.getTxtOfficerId(), updatedEmployee.getTxtUsrId(), updatedEmployee.getImgEmployee(), updatedEmployee.getTxtEmpId());

    }
    @Override
    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
       /* Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "DELETE FROM Employee WHERE EmployeeId=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, id);
        int affectedRows = stm.executeUpdate();
        if (affectedRows > 0) {
            return true;
        } else {
            return false;
        }*/
        return CrudUtil.execute("DELETE FROM Employee WHERE EmployeeId=?",id);
    }
    @Override
    public  ArrayList<Employees> getAllEmployees() throws SQLException, ClassNotFoundException {
      /* Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Employee";
        PreparedStatement stm = connection.prepareStatement(sql);
        ArrayList<EmployeesDto> List =new ArrayList<>();
        ResultSet rs=stm.executeQuery();
        while (rs.next()){
            String EmployeeId=rs.getString(1);
            String EmpName=rs.getString(2);
            String address=rs.getString(3);
            String contactNumber=rs.getString(4);
            String gender=rs.getString(5);
            String EmployeeType=rs.getString(6);
            String Ranking=rs.getString(7);
            String dob=rs.getString(8);
            String OfficerId=rs.getString(9);
            String UserId=rs.getString(10);

            Employees employees= new Employees();

            employees.setTxtEmpId(EmployeeId);
            employees.setTxtEmpName(EmpName);
            employees.setTxtAddress(address);
            employees.setTxtContactNumber(contactNumber);
            employees.setTxtGender(gender);
            employees.setTxtEmpType(EmployeeType);
            employees.setTxtRank(Ranking);
            employees.setTxtDob(dob);
            employees.setTxtOfficerId(OfficerId);
            employees.setTxtUsrId(UserId);

            List.add(employees);
        }
        return List;
    }*/
        ArrayList<Employees> list = new ArrayList<>();
        ResultSet rs = CrudUtil.execute("SELECT * FROM Employee");
        while (rs.next()) {
            list.add(new Employees(
                    rs.getString("EmployeeId"), rs.getString("EmpName"), rs.getString("address"),
                    rs.getString("contactNumber"), rs.getString("gender"), rs.getString("EmployeeType"),
                    rs.getString("Ranking"),rs.getString("dob"),rs.getString("OfficerId"),
                    rs.getString("UserId"),rs.getBytes("photo"))
            );
        }
        return list;
    }
}