package lk.ijse.policeStation.Bo.Custom.Impl;

import lk.ijse.policeStation.Bo.Custom.EmployeesBo;
import lk.ijse.policeStation.Dao.CrimeDao;
import lk.ijse.policeStation.Dao.EmployeesDao;
import lk.ijse.policeStation.Dao.custom.Impl.CrimeDaoImpl;
import lk.ijse.policeStation.Dao.custom.Impl.EmployeesDaoImpl;
import lk.ijse.policeStation.Entity.Citizen;
import lk.ijse.policeStation.Entity.Employees;
import lk.ijse.policeStation.dto.CitizenDto;
import lk.ijse.policeStation.dto.EmployeesDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeesBoImpl implements EmployeesBo {
    private final EmployeesDao employeesDao = new EmployeesDaoImpl();

    @Override
    public ArrayList<EmployeesDto> getAllEmployees() throws SQLException, ClassNotFoundException {
        List<Employees> employees = employeesDao.getAllEmployees();
        ArrayList<EmployeesDto> employeesDtos = new ArrayList<>();

        for (Employees employee : employees) {
            employeesDtos.add(new EmployeesDto(
                    employee.getTxtEmpId(), employee.getTxtEmpName(), employee.getTxtAddress(),
                    employee.getTxtContactNumber(), employee.getTxtGender(), employee.getTxtEmpType(),
                    employee.getTxtRank(), employee.getTxtDob(), employee.getTxtOfficerId(),
                    employee.getTxtUsrId(), employee.getImgEmployee()
            ));
        }
        return employeesDtos;
    }

    @Override
    public boolean saveEmployees(EmployeesDto employeesDto) throws SQLException, ClassNotFoundException {
        return employeesDao.save(new Employees(employeesDto.getTxtEmpId(), employeesDto.getTxtEmpName(), employeesDto.getTxtAddress(), employeesDto.getTxtContactNumber(),
                employeesDto.getTxtGender(), employeesDto.getTxtEmpType(), employeesDto.getTxtRank(), employeesDto.getTxtDob(),
                employeesDto.getTxtOfficerId(), employeesDto.getTxtUsrId(), employeesDto.getImgEmployee()));
    }

    @Override
    public boolean updateEmployees(EmployeesDto updatedEmployeeDto) throws SQLException, ClassNotFoundException {
        return employeesDao.update(new Employees(updatedEmployeeDto.getTxtEmpId(), updatedEmployeeDto.getTxtEmpName(), updatedEmployeeDto.getTxtAddress(), updatedEmployeeDto.getTxtContactNumber(),
                updatedEmployeeDto.getTxtGender(), updatedEmployeeDto.getTxtEmpType(), updatedEmployeeDto.getTxtRank(), updatedEmployeeDto.getTxtDob(),
                updatedEmployeeDto.getTxtOfficerId(), updatedEmployeeDto.getTxtUsrId(), updatedEmployeeDto.getImgEmployee()));
    }

    @Override
    public boolean deleteEmployees(String id) throws SQLException, ClassNotFoundException {
        return employeesDao.delete(id);

    }

    @Override
    public Optional<EmployeesDto> searchEmployees(String code) throws SQLException, ClassNotFoundException {
        Optional<Employees> optionalEmployees = employeesDao.search(code);

        return optionalEmployees.map(this::convertToDto);
    }
    @Override
    public EmployeesDto convertToDto(Employees employees) {
        return new EmployeesDto(
                employees.getTxtEmpId(), employees.getTxtEmpName(), employees.getTxtAddress(), employees.getTxtContactNumber(),
                employees.getTxtGender(), employees.getTxtEmpType(), employees.getTxtRank(), employees.getTxtDob(),
                employees.getTxtOfficerId(), employees.getTxtUsrId(), employees.getImgEmployee());
    }
}