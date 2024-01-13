package lk.ijse.policeStation.Dao;

import lk.ijse.policeStation.Entity.PoliceReport;
import lk.ijse.policeStation.dto.PoliceReportDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public interface PoliceReportDao extends CrudDao<PoliceReport>{
     ArrayList<PoliceReport> getAllReports() throws SQLException, ClassNotFoundException;

}
