package lk.ijse.policeStation.Dao;

import lk.ijse.policeStation.dto.CitizenDto;

import java.sql.SQLException;
import java.util.Optional;

public interface CrudDao <T> extends SuperDao{
    boolean save(T t) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;

    Optional<T> search(String id) throws SQLException, ClassNotFoundException;

    boolean update(T t) throws SQLException, ClassNotFoundException;


}
