package lk.ijse.policeStation.Bo.Custom;

import lk.ijse.policeStation.dto.PoliceReportDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public interface PoliceReportBo {
    Optional<PoliceReportDto> searchPoliceReport(String code) throws SQLException, ClassNotFoundException;

    boolean savePoliceReport(PoliceReportDto policeReportDto) throws SQLException, ClassNotFoundException;

    ArrayList<PoliceReportDto> getAllReports() throws SQLException, ClassNotFoundException;

    boolean updatePoliceReport(PoliceReportDto updatedPoliceReportDto) throws SQLException, ClassNotFoundException;

    boolean deletePoliceReport(String id) throws SQLException, ClassNotFoundException;
}
