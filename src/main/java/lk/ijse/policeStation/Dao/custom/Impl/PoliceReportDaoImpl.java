package lk.ijse.policeStation.Dao.custom.Impl;

import lk.ijse.policeStation.DB.DatabaseConnection;
import lk.ijse.policeStation.Dao.PoliceReportDao;
import lk.ijse.policeStation.Entity.PoliceReport;
import lk.ijse.policeStation.dto.CitizenDto;
import lk.ijse.policeStation.dto.PoliceReportDto;
import lk.ijse.policeStation.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class PoliceReportDaoImpl implements PoliceReportDao {
    @Override
    public  boolean save(PoliceReport policeReport) throws SQLException, ClassNotFoundException {
       /* Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "insert into PoliceReport(policeReportId,description,date,CitizenId,UserId) values(?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, policeReportDto.getTxtReportId());
        stm.setString(2, policeReportDto.getTxtDescription());
        stm.setString(3, policeReportDto.getTxtDate());
        stm.setString(4, policeReportDto.getCmdCitizenIds());
        stm.setString(5, policeReportDto.getCmdUserIds());


        int affectedRows = stm.executeUpdate();
        if (affectedRows > 0) {
            return true;
        } else {
            return false;
        }
*/      return CrudUtil.execute("INSERT INTO PoliceReport(policeReportId, description, date, CitizenId, UserId) VALUES (?, ?, ?, ?, ?)",
                policeReport.getTxtReportId(), policeReport.getTxtDescription(), policeReport.getTxtDate(),
                policeReport.getCmdCitizenIds(), policeReport.getCmdUserIds());

    }
    @Override
    public  ArrayList<PoliceReport> getAllReports() throws SQLException, ClassNotFoundException {

        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM PoliceReport";
        PreparedStatement stm = connection.prepareStatement(sql);
        ArrayList<PoliceReport> List =new ArrayList<>();
        ResultSet rs=stm.executeQuery();
        while (rs.next()){
            String policeReportId=rs.getString(1);
            String description=rs.getString(2);
            String date=rs.getString(3);
            String CitizenId=rs.getString(4);
            String UserId=rs.getString(5);

            PoliceReport policeReport= new PoliceReport();

            policeReport.setTxtReportId(policeReportId);
            policeReport.setTxtDescription(description);
            policeReport.setTxtDate(date);
            policeReport.setCmdCitizenIds(CitizenId);
            policeReport.setCmdUserIds(UserId);


            List.add(policeReport);
        }
        return List;
    }
    @Override
    public  Optional<PoliceReport> search(String code) throws SQLException, ClassNotFoundException {
      /*  Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM PoliceReport WHERE policeReportId=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, code);
        ResultSet rs = stm.executeQuery();*/
        ResultSet rs =CrudUtil.execute("SELECT * FROM PoliceReport WHERE policeReportId=?",code);


        if (rs.next()) {
            String policeReportId = rs.getString(1);
            String description = rs.getString(2);
            String date = rs.getString(3);
            String CitizenId = rs.getString(4);
            String UserId = rs.getString(5);

            PoliceReport policeReport = new PoliceReport();
            policeReport.setTxtReportId(policeReportId);
            policeReport.setTxtDescription(description);
            policeReport.setTxtDate(date);
            policeReport.setCmdCitizenIds(CitizenId);
            policeReport.setCmdUserIds(UserId);

            return Optional.of(policeReport);

        } else {
            return Optional.empty();
        }
    }
    @Override
    public  boolean update(PoliceReport updatedPoliceReport) throws SQLException, ClassNotFoundException {
       /* Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE PoliceReport SET description=?, date=?, CitizenId=?, UserId=? WHERE policeReportId=?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1,  updatedPoliceReportDto.getTxtDescription());
            stm.setString(2, updatedPoliceReportDto.getTxtDate());
            stm.setString(3, updatedPoliceReportDto.getCmdCitizenIds());
            stm.setString(4, updatedPoliceReportDto.getCmdUserIds());
            stm.setString(5, updatedPoliceReportDto.getTxtReportId());

            int affectedRows = stm.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        return CrudUtil.execute("UPDATE PoliceReport SET description=?, date=?, CitizenId=?, UserId=? WHERE policeReportId=?",
                updatedPoliceReport.getTxtDescription(), updatedPoliceReport.getTxtDate(),
                updatedPoliceReport.getCmdCitizenIds(), updatedPoliceReport.getCmdUserIds(),
                updatedPoliceReport.getTxtReportId());
    }
    @Override
    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "DELETE FROM PoliceReport WHERE policeReportId=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, id);
        int affectedRows = stm.executeUpdate();
        if (affectedRows > 0) {
            return true;
        } else {
            return false;
        }*/
        return CrudUtil.execute("DELETE FROM PoliceReport WHERE policeReportId=?",id);
    }
}
