package lk.ijse.policeStation.Dao;

import lk.ijse.policeStation.Entity.Employees;
import lk.ijse.policeStation.dto.EmployeesDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeesDao extends CrudDao <Employees>{
    public ArrayList<Employees> getAllEmployees() throws SQLException, ClassNotFoundException;
    }
