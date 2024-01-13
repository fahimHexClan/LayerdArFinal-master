package lk.ijse.policeStation.Bo.Custom;

import lk.ijse.policeStation.Entity.Crime;
import lk.ijse.policeStation.dto.CrimeDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public interface CrimeBo {
    boolean deleteCrime(String id) throws SQLException, ClassNotFoundException;

    boolean saveCrime(CrimeDto crimeDto) throws SQLException, ClassNotFoundException;

    ArrayList<CrimeDto> getAllCrimes() throws SQLException, ClassNotFoundException;

    Optional<CrimeDto> searchCrime(String code) throws SQLException, ClassNotFoundException;

    boolean updateCrime(CrimeDto updatedCrimeDto) throws SQLException, ClassNotFoundException;
    CrimeDto convertToDto(Crime crime);
}
