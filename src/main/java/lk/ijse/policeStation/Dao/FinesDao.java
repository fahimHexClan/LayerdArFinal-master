package lk.ijse.policeStation.Dao;

import lk.ijse.policeStation.Entity.Fines;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public interface FinesDao {
    ArrayList<Fines> getAllFines() throws SQLException, ClassNotFoundException ;
    boolean update(Fines updatedFines) throws SQLException, ClassNotFoundException;
    Optional<Fines> search(String code) throws SQLException, ClassNotFoundException ;
    boolean save(Fines fines) throws SQLException, ClassNotFoundException ;

}




