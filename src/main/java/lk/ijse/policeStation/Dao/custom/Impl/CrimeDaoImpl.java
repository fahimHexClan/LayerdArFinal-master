package lk.ijse.policeStation.Dao.custom.Impl;

import lk.ijse.policeStation.DB.DatabaseConnection;
import lk.ijse.policeStation.Dao.CrimeDao;
import lk.ijse.policeStation.Entity.Citizen;
import lk.ijse.policeStation.Entity.Crime;
import lk.ijse.policeStation.dto.CitizenDto;
import lk.ijse.policeStation.dto.CrimeDto;
import lk.ijse.policeStation.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class CrimeDaoImpl implements CrimeDao {
    @Override
    public  boolean save(Crime crime) throws SQLException, ClassNotFoundException {
       /* Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "insert into Crime (CrimeId,description,date,crimeType,location,CriminalRecord,InjuriesOrCasualties,Motivereason,WeaponsUsed,Status) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, crimeDto.getCrimeID());
        stm.setString(2, crimeDto.getDeatails());
        stm.setString(3, crimeDto.getDate());
        stm.setString(4, crimeDto.getTxtTypeOfCrime());
        stm.setString(5, crimeDto.getTxtLocation());
        stm.setString(6, crimeDto.getCriminalRecord());
        stm.setString(7, crimeDto.getInjuries());
        stm.setString(8, crimeDto.getTxtMotiveReson());
        stm.setString(9, crimeDto.getTxtWeponUsed());
        stm.setString(10, crimeDto.getTxtStatus());

        int affectedRows = stm.executeUpdate();
        if (affectedRows > 0) {
            return true;
        } else {
            return false;
        }
*/
        return CrudUtil.execute("insert into Crime (CrimeId,description,date,crimeType,location,CriminalRecord,InjuriesOrCasualties,Motivereason,WeaponsUsed,Status) values(?,?,?,?,?,?,?,?,?,?)",
                crime.getCrimeID(),crime.getDeatails(),crime.getDate(),crime.getTxtTypeOfCrime(),crime.getTxtLocation(),
                crime.getCriminalRecord(),crime.getInjuries(),crime.getTxtMotiveReson(),crime.getTxtWeponUsed(),crime.getTxtStatus());
    }
    @Override
    public  ArrayList<Crime> getAllCrimes() throws SQLException, ClassNotFoundException {
       /* Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Crime";
        PreparedStatement stm = connection.prepareStatement(sql);
        ArrayList<Crime> List = new ArrayList<>();
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            String CrimeId = rs.getString(1);
            String description = rs.getString(2);
            String date = rs.getString(3);
            String crimeType = rs.getString(4);
            String location = rs.getString(5);
            String CriminalRecord = rs.getString(6);
            String InjuriesOrCasualties = rs.getString(7);
            String Motivereason = rs.getString(8);
            String WeaponsUsed = rs.getString(9);
            String Status = rs.getString(10);

            Crime crime = new Crime();

            crime.setCrimeID(CrimeId);
            crime.setDeatails(description);
            crime.setDate(date);
            crime.setTxtTypeOfCrime(crimeType);
            crime.setTxtLocation(location);
            crime.setCriminalRecord(CriminalRecord);
            crime.setInjuries(InjuriesOrCasualties);
            crime.setTxtMotiveReson(Motivereason);
            crime.setTxtWeponUsed(WeaponsUsed);
            crime.setTxtStatus(Status);

            List.add(crime);
        }
        return List;*/
        ArrayList<Crime> list = new ArrayList<>();
        ResultSet rs = CrudUtil.execute("SELECT * FROM Crime");
        while (rs.next()) {
            list.add(new Crime(
                    rs.getString("CrimeId"),rs.getString("description"), rs.getString("date"),
                    rs.getString("crimeType"), rs.getString("location"),rs.getString("CriminalRecord"),
                    rs.getString("InjuriesOrCasualties"),rs.getString("Motivereason"),rs.getString("WeaponsUsed"),rs.getString("Status"))
            );
        }
        return list;

    }
    @Override
    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "DELETE FROM Crime WHERE CrimeId=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, id);
        int affectedRows = stm.executeUpdate();
        if (affectedRows > 0) {
            return true;
        } else {
            return false;
        }*/
        return CrudUtil.execute("DELETE FROM Crime WHERE CrimeId=?", id);

    }
    @Override
    public  boolean update(Crime updatedCrime) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE Crime SET description=?, date=?, crimeType=?, location=?, CriminalRecord=?, InjuriesOrCasualties=?, Motivereason=?, WeaponsUsed=? ,Status=? WHERE CrimeId=?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, updatedCrimeDto.getDeatails());
            stm.setString(2, updatedCrimeDto.getDate());
            stm.setString(3, updatedCrimeDto.getTxtTypeOfCrime());
            stm.setString(4, updatedCrimeDto.getTxtLocation());
            stm.setString(5, updatedCrimeDto.getCriminalRecord());
            stm.setString(6, updatedCrimeDto.getInjuries());
            stm.setString(7, updatedCrimeDto.getTxtMotiveReson());
            stm.setString(8, updatedCrimeDto.getTxtWeponUsed());
            stm.setString(9, updatedCrimeDto.getTxtStatus());


            stm.setString(10, updatedCrimeDto.getCrimeID());

            int affectedRows = stm.executeUpdate();
            return affectedRows > 0;
        }*/
        return CrudUtil.execute("UPDATE Crime SET description=?, date=?, crimeType=?, location=?, CriminalRecord=?, InjuriesOrCasualties=?, Motivereason=?, WeaponsUsed=?, Status=? WHERE CrimeId=?",
                updatedCrime.getDeatails(), updatedCrime.getDate(), updatedCrime.getTxtTypeOfCrime(), updatedCrime.getTxtLocation(),
                updatedCrime.getCriminalRecord(), updatedCrime.getInjuries(), updatedCrime.getTxtMotiveReson(), updatedCrime.getTxtWeponUsed(), updatedCrime.getTxtStatus(),
                updatedCrime.getCrimeID());
    }

    @Override
    public  Optional<Crime> search(String code) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Crime WHERE CrimeId=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, code);*/
      /*  ResultSet rs = CrudUtil.execute("SELECT * FROM Crime WHERE CrimeId=?",code);

        if (rs.next()) {
            String crimeId = rs.getString(1);
            String description = rs.getString(2);
            String date = rs.getString(3);
            String crimeType = rs.getString(4);
            String location = rs.getString(5);
            String CriminalRecord = rs.getString(6);
            String InjuriesOrCasualties = rs.getString(7);
            String Motivereason = rs.getString(8);
            String WeaponsUsed = rs.getString(9);
            String Status = rs.getString(10);


            Crime crime = new Crime();
            crime.setCrimeID(crimeId);
            crime.setDeatails(description);
            crime.setDate(date);
            crime.setTxtTypeOfCrime(crimeType);
            crime.setTxtLocation(location);
            crime.setCriminalRecord(CriminalRecord);
            crime.setInjuries(InjuriesOrCasualties);
            crime.setTxtMotiveReson(Motivereason);
            crime.setTxtWeponUsed(WeaponsUsed);
            crime.setTxtStatus(Status);

            return Optional.of(crime);

        } else {
            return Optional.empty();
        }*/
        ResultSet rst = CrudUtil.execute("SELECT * FROM Crime WHERE CrimeId=?",code);
        if (rst.next()) {
            return Optional.of(new Crime(code,rst.getString("description"), rst.getString("date"),
                    rst.getString("crimeType"), rst.getString("location"),rst.getString("CriminalRecord"),
                        rst.getString("InjuriesOrCasualties"),rst.getString("Motivereason"),rst.getString("WeaponsUsed"),rst.getString("Status")));
        } else {
            return Optional.empty();
        }
    }
}
