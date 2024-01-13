package lk.ijse.policeStation.Bo.Custom;

import lk.ijse.policeStation.dto.FinesDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public interface FinesBo {
    boolean saveFines(FinesDto finesDto) throws SQLException, ClassNotFoundException;

    ArrayList<FinesDto> getAllFines() throws SQLException, ClassNotFoundException;

    Optional<FinesDto> searchFines(String code) throws SQLException, ClassNotFoundException;

    boolean updateFines(FinesDto updatedFines) throws SQLException, ClassNotFoundException;

}