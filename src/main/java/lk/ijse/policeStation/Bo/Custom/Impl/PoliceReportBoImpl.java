package lk.ijse.policeStation.Bo.Custom.Impl;

import lk.ijse.policeStation.Bo.Custom.PoliceReportBo;
import lk.ijse.policeStation.Dao.EmployeesDao;
import lk.ijse.policeStation.Dao.PoliceReportDao;
import lk.ijse.policeStation.Dao.custom.Impl.EmployeesDaoImpl;
import lk.ijse.policeStation.Dao.custom.Impl.PoliceReportDaoImpl;
import lk.ijse.policeStation.Entity.Employees;
import lk.ijse.policeStation.Entity.PoliceReport;
import lk.ijse.policeStation.dto.EmployeesDto;
import lk.ijse.policeStation.dto.PoliceReportDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PoliceReportBoImpl implements PoliceReportBo {
    private final PoliceReportDao policeReportDao = new PoliceReportDaoImpl();

    @Override
    public Optional<PoliceReportDto> searchPoliceReport(String code) throws SQLException, ClassNotFoundException {
        Optional<PoliceReport> policeReport = policeReportDao.search(code);

        return policeReport.map(this::convertToDto);
    }

    public PoliceReportDto convertToDto(PoliceReport policeReport) {
        return new PoliceReportDto(
                policeReport.getTxtReportId(), policeReport.getTxtDescription(), policeReport.getTxtDate(),
                policeReport.getCmdCitizenIds(), policeReport.getCmdUserIds());

    }

    @Override
    public boolean savePoliceReport(PoliceReportDto policeReportDto) throws SQLException, ClassNotFoundException {
    return policeReportDao.save(new PoliceReport(policeReportDto.getTxtReportId(),policeReportDto.getTxtDescription(),policeReportDto.getTxtDate(),
            policeReportDto.getCmdCitizenIds(),policeReportDto.getCmdUserIds()));
    }
    @Override
    public ArrayList<PoliceReportDto> getAllReports() throws SQLException, ClassNotFoundException {
        List<PoliceReport> allReports = policeReportDao.getAllReports();
        ArrayList<PoliceReportDto> policeReportDtos = new ArrayList<>();

        for (PoliceReport employee : allReports) {
            policeReportDtos.add(new PoliceReportDto(
                    employee.getTxtReportId(), employee.getTxtDescription(), employee.getTxtDate(),
                    employee.getCmdCitizenIds(), employee.getCmdUserIds()
            ));
        }
        return policeReportDtos;
    }
    @Override
    public boolean updatePoliceReport(PoliceReportDto updatedPoliceReportDto) throws SQLException, ClassNotFoundException {
    return policeReportDao.update(new PoliceReport(updatedPoliceReportDto.getTxtReportId(),updatedPoliceReportDto.getTxtDescription(),updatedPoliceReportDto.getTxtDate(),
            updatedPoliceReportDto.getCmdCitizenIds(),updatedPoliceReportDto.getCmdUserIds()));
    }
    @Override
    public boolean deletePoliceReport(String id) throws SQLException, ClassNotFoundException {
        return policeReportDao.delete(id);

    }
}
