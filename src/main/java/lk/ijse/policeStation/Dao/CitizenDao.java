package lk.ijse.policeStation.Dao;

import lk.ijse.policeStation.Entity.Citizen;
import lk.ijse.policeStation.dto.CitizenDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public interface CitizenDao extends CrudDao<Citizen>{


    ArrayList<Citizen> getAllCitizens() throws SQLException, ClassNotFoundException;


    List<String> getCitizenIds() throws SQLException, ClassNotFoundException;

}
