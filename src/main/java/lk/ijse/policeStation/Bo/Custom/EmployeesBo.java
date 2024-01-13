package lk.ijse.policeStation.Bo.Custom;

import lk.ijse.policeStation.Entity.Employees;
import lk.ijse.policeStation.dto.EmployeesDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public interface EmployeesBo {
    ArrayList<EmployeesDto> getAllEmployees() throws SQLException, ClassNotFoundException;

    boolean saveEmployees(EmployeesDto employeesDto) throws SQLException, ClassNotFoundException;

    boolean updateEmployees(EmployeesDto updatedEmployeeDto) throws SQLException, ClassNotFoundException;

    boolean deleteEmployees(String id) throws SQLException, ClassNotFoundException;

    Optional<EmployeesDto> searchEmployees(String code) throws SQLException, ClassNotFoundException;

    EmployeesDto convertToDto(Employees employees) ;

    }
