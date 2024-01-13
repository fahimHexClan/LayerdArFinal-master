package lk.ijse.policeStation.Dao.custom.Impl;

import lk.ijse.policeStation.DB.DatabaseConnection;
import lk.ijse.policeStation.Dao.VehicleDao;
import lk.ijse.policeStation.Entity.Driver;
import lk.ijse.policeStation.Entity.Vehicale;
import lk.ijse.policeStation.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class VehicleDaoImpl implements VehicleDao {
    @Override
    public  boolean save(Vehicale vehicale) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "insert into Vehicle (VehicleId,EngineNumber,Owner,VehicleNumPlate,VehicleType,Model) values(?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, vehicleDto.getTxtVehicleId());
        stm.setString(2, vehicleDto.getTxtEngineNum());
        stm.setString(3, vehicleDto.getTxtOwnerId());
        stm.setString(4, vehicleDto.getTxtPlateNum());
        stm.setString(5, vehicleDto.getTxtVehicleType());
        stm.setString(6, vehicleDto.getTxtModelId());

        int affectedRows = stm.executeUpdate();
        if (affectedRows > 0) {
            return true;
        } else {
            return false;
        }
*/
        return CrudUtil.execute("INSERT INTO Vehicle (VehicleId, EngineNumber, Owner, VehicleNumPlate, VehicleType, Model) VALUES (?, ?, ?, ?, ?, ?)",
                vehicale.getTxtVehicleId(), vehicale.getTxtEngineNum(), vehicale.getTxtOwnerId(),
                vehicale.getTxtPlateNum(), vehicale.getTxtVehicleType(), vehicale.getTxtModelId());
    }
    @Override
    public  ArrayList<Vehicale> getAllVehicle() throws SQLException, ClassNotFoundException {

        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Vehicle";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();*/

   /* ResultSet rs = CrudUtil.execute("SELECT * FROM Vehicle");
    ArrayList<Vehicale> List = new ArrayList<>();
        while (rs.next()) {
            String VehicleId = rs.getString(1);
            String EngineNumber = rs.getString(2);
            String Owner = rs.getString(3);
            String VehicleNumPlate = rs.getString(4);
            String VehicleType = rs.getString(5);
            String Model = rs.getString(6);

            Vehicale vehicale = new Vehicale();

            vehicale.setTxtVehicleId(VehicleId);
            vehicale.setTxtEngineNum(EngineNumber);
            vehicale.setTxtOwnerId(Owner);
            vehicale.setTxtPlateNum(VehicleNumPlate);
            vehicale.setTxtVehicleType(VehicleType);
            vehicale.setTxtModelId(Model);

            List.add(vehicale);
        }
        return List;
    }*/
        ArrayList<Vehicale> list = new ArrayList<>();
        ResultSet rs = CrudUtil.execute("SELECT * FROM Vehicle");
        while (rs.next()) {
            list.add(new Vehicale(rs.getString("VehicleId"),rs.getString("EngineNumber"), rs.getString("Owner"),
                    rs.getString("VehicleNumPlate"), rs.getString("VehicleType"),rs.getString("Model")));
        }
        return list;
    }
    @Override
    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "DELETE FROM Vehicle WHERE VehicleId=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, id);
        int affectedRows = stm.executeUpdate();
        if (affectedRows > 0) {
            return true;
        } else {
            return false;
        }*/
        return CrudUtil.execute("DELETE FROM Vehicle WHERE VehicleId=?",id);
    }

    @Override
    public  Optional<Vehicale> search(String code) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Vehicle WHERE VehicleId=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, code);
        ResultSet rs = stm.executeQuery();*/
       /* ResultSet rs = CrudUtil.execute("SELECT * FROM Vehicle WHERE VehicleId=?", code);


        if (rs.next()) {
            String VehicleId = rs.getString(1);
            String EngineNumber = rs.getString(2);
            String Owner = rs.getString(3);
            String VehicleNumPlate = rs.getString(4);
            String VehicleType = rs.getString(5);
            String Model = rs.getString(6);


            Vehicale vehicale = new Vehicale();
            vehicale.setTxtVehicleId(VehicleId);
            vehicale.setTxtEngineNum(EngineNumber);
            vehicale.setTxtOwnerId(Owner);
            vehicale.setTxtPlateNum(VehicleNumPlate);
            vehicale.setTxtVehicleType(VehicleType);
            vehicale.setTxtModelId(Model);


            return Optional.of(vehicale);

        } else {
            return Optional.empty();
        }*/
        ResultSet rst = CrudUtil.execute("SELECT * FROM Vehicle WHERE VehicleId=?",code);
        if (rst.next()) {
            return Optional.of(new Vehicale(code,rst.getString("EngineNumber"), rst.getString("Owner"),
                    rst.getString("VehicleNumPlate"), rst.getString("VehicleType"),rst.getString("Model")));
        } else {
            return Optional.empty();
        }

    }
    @Override
    public  boolean update(Vehicale updatedVehicle) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE Vehicle SET EngineNumber=?, Owner=?, VehicleNumPlate=?, VehicleType=?, Model=? WHERE VehicleId=?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, updatedVehicleDto.getTxtEngineNum());
            stm.setString(2, updatedVehicleDto.getTxtOwnerId());
            stm.setString(3, updatedVehicleDto.getTxtPlateNum());
            stm.setString(4, updatedVehicleDto.getTxtVehicleType());
            stm.setString(5, updatedVehicleDto.getTxtModelId());


            stm.setString(6, updatedVehicleDto.getTxtVehicleId());

            int affectedRows = stm.executeUpdate();
            return affectedRows > 0;
        }*/
        return CrudUtil.execute("UPDATE Vehicle SET EngineNumber=?, Owner=?, VehicleNumPlate=?, VehicleType=?, Model=? WHERE VehicleId=?",
                updatedVehicle.getTxtEngineNum(), updatedVehicle.getTxtOwnerId(),
                updatedVehicle.getTxtPlateNum(), updatedVehicle.getTxtVehicleType(),
                updatedVehicle.getTxtModelId(), updatedVehicle.getTxtVehicleId());
    }
    @Override
    public  ArrayList<String> getAllVehicleIds() throws SQLException, ClassNotFoundException {
        /*try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stm = connection.prepareStatement("SELECT VehicleId FROM Vehicle");
             ResultSet rs = stm.executeQuery()) {

            ArrayList<String> vehicleIds = new ArrayList<>();
            while (rs.next()) {
                vehicleIds.add(rs.getString("VehicleId"));
            }
            return vehicleIds;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/
   /* ResultSet rs = CrudUtil.execute("SELECT VehicleId FROM Vehicle");
    ArrayList<Vehicale> vehicleIds = new ArrayList<>();
    while (rs.next()) {
        Vehicale vehicleId = rs.getString("DriverId");
        vehicleIds.add(vehicleId);
    }
    return vehicleIds;
}*/
        ArrayList<String> vehicleIds = new ArrayList<>();
        ResultSet rs = CrudUtil.execute("SELECT VehicleId FROM Vehicle");
        while (rs.next()) {
            vehicleIds.add(rs.getString("VehicleId"));
        }
        return vehicleIds;
    }
}

