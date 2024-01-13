package lk.ijse.policeStation.Bo.Custom;

import lk.ijse.policeStation.Entity.Citizen;
import lk.ijse.policeStation.dto.CitizenDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CitizenBo {
    boolean saveCitizen(CitizenDto citizenDto) throws SQLException, ClassNotFoundException;

    boolean updateCitizen(CitizenDto updatedCitizenDto) throws SQLException, ClassNotFoundException;

    boolean deleteCitizen(String citizenId) throws SQLException, ClassNotFoundException;

     Optional<CitizenDto> findCitizen(String citizenId) throws SQLException, ClassNotFoundException;

     List<CitizenDto> getAllCitizens() throws SQLException, ClassNotFoundException;
     CitizenDto convertToDto(Citizen citizen);

    }
