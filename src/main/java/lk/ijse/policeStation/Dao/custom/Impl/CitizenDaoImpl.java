package lk.ijse.policeStation.Dao.custom.Impl;

import lk.ijse.policeStation.Dao.CitizenDao;
import lk.ijse.policeStation.Entity.Citizen;
import lk.ijse.policeStation.dto.CitizenDto;
import lk.ijse.policeStation.util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CitizenDaoImpl implements CitizenDao {
    @Override
    public  boolean save(Citizen citizen) throws SQLException, ClassNotFoundException {
       /* Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "insert into Citizen(CitizenId,name,address,contactNumber,gender,Dob,Citizenphoto) values(?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, citizenDto.getCitizenId());
        stm.setString(2, citizenDto.getName());
        stm.setString(3, citizenDto.getAddress());
        stm.setString(4, citizenDto.getContactNumber());
        stm.setString(5, citizenDto.getGender());
        stm.setString(6, citizenDto.getDob());
        return stm.executeUpdate()>0;*/

        /*try (Connection connection = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stm = connection.prepareStatement("INSERT INTO Citizen(CitizenId, name, address, contactNumber, gender, Dob, Citizenphoto) VALUES (?, ?, ?, ?, ?, ?, ?))) {

            stm.setString(1, citizenDto.getCitizenId());
            stm.setString(2, citizenDto.getName());
            stm.setString(3, citizenDto.getAddress());
            stm.setString(4, citizenDto.getContactNumber());
            stm.setString(5, citizenDto.getGender());
            stm.setString(6, citizenDto.getDob());

            byte[] photoBytes = citizenDto.getImgview();
            if (photoBytes != null) {
                stm.setBlob(7, new ByteArrayInputStream(photoBytes));
            } else {
                stm.setNull(7, java.sql.Types.BLOB);
            }

            return stm.executeUpdate() > 0;
        }*/
       return CrudUtil.execute("INSERT INTO Citizen(CitizenId, name, address, contactNumber, gender, Dob, Citizenphoto) VALUES (?, ?, ?, ?, ?, ?, ?)",
               citizen.getCitizenId(),citizen.getName(),citizen.getAddress(),citizen.getContactNumber(),citizen.getGender(),
               citizen.getDob(),citizen.getImgview());
    }
@Override
public  boolean delete(String id) throws SQLException, ClassNotFoundException {
       /* Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "DELETE FROM Citizen WHERE CitizenId=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, id);
        int affectedRows = stm.executeUpdate();
        if (affectedRows > 0) {
            return true;
        } else {
            return false;
        }*/
        return CrudUtil.execute("DELETE FROM Citizen WHERE CitizenId=?",id);
    }
    @Override
    public  Optional<Citizen> search(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Citizen WHERE CitizenId=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, id);*/

       /* ResultSet rs =CrudUtil.execute("SELECT * FROM Citizen WHERE CitizenId=?",id);

        if (rs.next()) {
            String code = rs.getString(1);
            String name = rs.getString(2);
            String address = rs.getString(3);
            String contactNumber = rs.getString(4);
            String gender = rs.getString(5);
            String Dob = rs.getString(6);
            Blob empImgBlob = rs.getBlob(7);

            Citizen citizen = new Citizen();
            citizen.setCitizenId(code);
            citizen.setName(name);
            citizen.setAddress(address);
            citizen.setContactNumber(contactNumber);
            citizen.setGender(gender);
            citizen.setDob(Dob);

            if (empImgBlob != null) {
                byte[] empImgBytes = empImgBlob.getBytes(1, (int) empImgBlob.length());
                citizen.setImgview(empImgBytes);
            } else {
                citizen.setImgview(null);
            }

            return Optional.of(citizen);

        } else {
            return Optional.empty();
        }*/
        ResultSet rst = CrudUtil.execute("SELECT * FROM Citizen WHERE CitizenId=?", id);
        if (rst.next()) {
            return Optional.of(new Citizen(id, rst.getString("name"), rst.getString("address"), rst.getString("contactNumber"),
                    rst.getString("gender"), rst.getString("Dob"), rst.getBytes("Citizenphoto")));
        } else {
            return Optional.empty();
        }
    }
    @Override
    public  ArrayList<Citizen> getAllCitizens() throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Citizen";
        PreparedStatement stm = connection.prepareStatement(sql);*/

       /* ArrayList<CitizenDto> List =new ArrayList<>();
        ResultSet rs=CrudUtil.execute("SELECT * FROM Citizen");
        while (rs.next()){
            String CitizenId=rs.getString(1);
            String name=rs.getString(2);
            String address=rs.getString(3);
            String contactNumber=rs.getString(4);
            String gender=rs.getString(5);
            String Dob=rs.getString(6);

            CitizenDto citizenDto= new CitizenDto();

            citizenDto.setCitizenId(CitizenId);
            citizenDto.setName(name);
            citizenDto.setAddress(address);
            citizenDto.setContactNumber(contactNumber);
            citizenDto.setGender(gender);
            citizenDto.setDob(Dob);

            List.add(citizenDto);
        }
        return List;
    }*/
        ArrayList<Citizen> list = new ArrayList<>();
        ResultSet rs = CrudUtil.execute("SELECT * FROM Citizen");
        while (rs.next()) {
            list.add(new Citizen(
                    rs.getString("CitizenId"), rs.getString("name"), rs.getString("address"),
                    rs.getString("contactNumber"), rs.getString("gender"), rs.getString("Dob"),
                    rs.getBytes("Citizenphoto"))
            );
        }
        return list;
    }

    @Override
    public  boolean update(Citizen citizen) throws SQLException, ClassNotFoundException {
      /*  Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE Citizen SET name=?, address=?, contactNumber=?, gender=?, Dob=?, Citizenphoto=? WHERE CitizenId=?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, citizenDto.getName());
            stm.setString(2, citizenDto.getAddress());
            stm.setString(3, citizenDto.getContactNumber());
            stm.setString(4, citizenDto.getGender());
            stm.setString(5, citizenDto.getDob());

            byte[] photoBytes = citizenDto.getImgview();
            if (photoBytes != null) {
                try (ByteArrayInputStream inputStream = new ByteArrayInputStream(photoBytes)) {
                    stm.setBlob(6, inputStream);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                stm.setNull(6, java.sql.Types.BLOB);
            }

            stm.setString(7, citizenDto.getCitizenId());

            int affectedRows = stm.executeUpdate();
            return affectedRows > 0;
        }*/
        String sql = "UPDATE Citizen SET name=?, address=?, contactNumber=?, gender=?, Dob=?, Citizenphoto=? WHERE CitizenId=?";
        return CrudUtil.execute(sql,
                citizen.getName(), citizen.getAddress(), citizen.getContactNumber(),
                citizen.getGender(), citizen.getDob(), citizen.getImgview(), citizen.getCitizenId());

    }
    @Override
    public    List<String> getCitizenIds() throws SQLException, ClassNotFoundException {
       /* Connection connection = DatabaseConnection.getInstance().getConnection();
        ResultSet resultSet = connection.prepareStatement("SELECT CitizenId FROM Citizen").executeQuery();

        List<String> ids = new ArrayList<>();
        while (resultSet.next()) {
            ids.add(resultSet.getString("CitizenId"));
        }
        return ids;
*/       String sql = "SELECT CitizenId FROM Citizen";
        ResultSet resultSet = CrudUtil.execute(sql);

        List<String> ids = new ArrayList<>();
        while (resultSet.next()) {
            ids.add(resultSet.getString("CitizenId"));
        }
        return ids;
    }
}
