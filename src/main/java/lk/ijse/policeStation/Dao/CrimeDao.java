package lk.ijse.policeStation.Dao;
import lk.ijse.policeStation.Entity.Crime;
import lk.ijse.policeStation.dto.CrimeDto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrimeDao extends CrudDao<Crime> {
     ArrayList<Crime> getAllCrimes() throws SQLException, ClassNotFoundException;

}
