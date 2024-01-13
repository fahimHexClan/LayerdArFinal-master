package lk.ijse.policeStation.Dao.custom.Impl;

import lk.ijse.policeStation.Dao.FinesDao;
import lk.ijse.policeStation.Entity.Fines;
import lk.ijse.policeStation.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class FinesDaoImpl implements FinesDao {
    public  ArrayList<Fines> getAllFines() throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Fines";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs=stm.executeQuery();*/
       /* ResultSet rs = CrudUtil.execute("SELECT * FROM Fines");
        ArrayList<FinesDto> List =new ArrayList<>();
        while (rs.next()){
            String FinesId=rs.getString(1);
            String FinesDescription=rs.getString(2);
            Double FinesAmount= Double.valueOf(rs.getString(3));
            String FinesDate=rs.getString(4);
            String DriverId=rs.getString(5);

            FinesDto finesDto= new FinesDto();

            finesDto.setTxtFinesId(FinesId);
            finesDto.setTxtFinesDescrip(FinesDescription);
            finesDto.setTxtFinesAmount(FinesAmount);
            finesDto.setTxtFinesDate(FinesDate);
            finesDto.setCmbDriverId(DriverId);


            List.add(finesDto);
        }
        return List;
    }*/ ResultSet rs = CrudUtil.execute("SELECT * FROM Fines");
        ArrayList<Fines> fineIds = new ArrayList<>();
        while (rs.next()) {
            Fines fine = new Fines(
                    rs.getString("FinesId"),
                    rs.getString("FinesDescription"),
                    rs.getDouble("FinesAmount"),
                    rs.getString("FinesDate"),
                    rs.getString("DriverId")
            );
            fineIds.add(fine);
        }
        return fineIds;
    }

    @Override
    public  boolean update(Fines updatedFines) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE Fines SET FinesDescription=?, FinesAmount=?, FinesDate=?, DriverId=? WHERE FinesId=?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, updatedFines.getTxtFinesDescrip());
            stm.setDouble(2, updatedFines.getTxtFinesAmount());
            stm.setString(3, updatedFines.getTxtFinesDate());
            stm.setString(4, updatedFines.getCmbDriverId());
            stm.setString(5, updatedFines.getTxtFinesId());

            int affectedRows = stm.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        return CrudUtil.execute("UPDATE Fines SET FinesDescription=?, FinesAmount=?, FinesDate=?, DriverId=? WHERE FinesId=?",
                updatedFines.getTxtFinesDescrip(), updatedFines.getTxtFinesAmount(), updatedFines.getTxtFinesDate(),
                updatedFines.getCmbDriverId(), updatedFines.getTxtFinesId());
    }
    @Override
    public  Optional<Fines> search(String code) throws SQLException, ClassNotFoundException {
      /*  Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Fines WHERE FinesId=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, code);
        ResultSet rs = stm.executeQuery();*/
        /*ResultSet rs = CrudUtil.execute("SELECT * FROM Fines WHERE FinesId=?", code);


        if (rs.next()) {
            String FinesId = rs.getString(1);
            String FinesDescription = rs.getString(2);
            Double FinesAmount = Double.valueOf(rs.getString(3));
            String FinesDate = rs.getString(4);
            String DriverId = rs.getString(5);

            FinesDto finesDto = new FinesDto();
            finesDto.setTxtFinesId(FinesId);
            finesDto.setTxtFinesDescrip(FinesDescription);
            finesDto.setTxtFinesAmount(FinesAmount);
            finesDto.setTxtFinesDate(FinesDate);
            finesDto.setCmbDriverId(DriverId);

            return Optional.of(finesDto);

        } else {
            return Optional.empty();
        }*/
        ResultSet rst = CrudUtil.execute("SELECT * FROM Fines WHERE FinesId=?",code);
        if (rst.next()) {
            return Optional.of(new Fines(code,rst.getString("FinesDescription"), rst.getDouble("FinesAmount"),
                    rst.getString("FinesDate"), rst.getString("DriverId")));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public  boolean save(Fines fines) throws SQLException, ClassNotFoundException {
       /* Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "insert into Fines(FinesId,FinesDescription,FinesAmount,FinesDate,DriverId) values(?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, finesDto.getTxtFinesId());
        stm.setString(2, finesDto.getTxtFinesDescrip());
        stm.setDouble(3, finesDto.getTxtFinesAmount());
        stm.setString(4, finesDto.getTxtFinesDate());
        stm.setString(5, finesDto.getCmbDriverId());


        int affectedRows = stm.executeUpdate();
        if (affectedRows > 0) {
            return true;
        } else {
            return false;
        }
*/      return CrudUtil.execute("INSERT INTO Fines(FinesId, FinesDescription, FinesAmount, FinesDate, DriverId) VALUES (?, ?, ?, ?, ?)",
                fines.getTxtFinesId(), fines.getTxtFinesDescrip(), fines.getTxtFinesAmount(),
                fines.getTxtFinesDate(), fines.getCmbDriverId());

    }


}
