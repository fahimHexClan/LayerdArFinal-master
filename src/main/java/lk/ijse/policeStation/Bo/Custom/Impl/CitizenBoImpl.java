package lk.ijse.policeStation.Bo.Custom.Impl;

import lk.ijse.policeStation.Bo.Custom.CitizenBo;
import lk.ijse.policeStation.Dao.CitizenDao;
import lk.ijse.policeStation.Dao.custom.Impl.CitizenDaoImpl;
import lk.ijse.policeStation.Entity.Citizen;
import lk.ijse.policeStation.dto.CitizenDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CitizenBoImpl implements CitizenBo {

    private final CitizenDao citizenDao = new CitizenDaoImpl();
    @Override
    public boolean saveCitizen(CitizenDto citizenDto) throws SQLException, ClassNotFoundException {
        return citizenDao.save(new Citizen(citizenDto.getCitizenId(),citizenDto.getName(),citizenDto.getAddress(),
            citizenDto.getContactNumber(),citizenDto.getGender(),citizenDto.getDob(),citizenDto.getImgview()));
    }

    @Override
    public boolean updateCitizen(CitizenDto updatedCitizenDto) throws SQLException, ClassNotFoundException {
        return citizenDao.update(new Citizen(updatedCitizenDto.getCitizenId(),updatedCitizenDto.getName(),updatedCitizenDto.getAddress(),
                updatedCitizenDto.getContactNumber(),updatedCitizenDto.getGender(),updatedCitizenDto.getDob(),updatedCitizenDto.getImgview()));
    }

    @Override
    public boolean deleteCitizen(String citizenId) throws SQLException, ClassNotFoundException {
        return citizenDao.delete(citizenId);
    }

    @Override
    public Optional<CitizenDto> findCitizen(String citizenId) throws SQLException, ClassNotFoundException {
        Optional<Citizen> optionalCitizen = citizenDao.search(citizenId);

        return optionalCitizen.map(this::convertToDto);
    }

    @Override
    public List<CitizenDto> getAllCitizens() throws SQLException, ClassNotFoundException {
        List<Citizen> citizens=citizenDao.getAllCitizens();
        List<CitizenDto> citizenDtos=new ArrayList<>();

        for (Citizen citizen:citizens) {
            citizenDtos.add(new CitizenDto(citizen.getCitizenId(),citizen.getName(),citizen.getAddress(),
                    citizen.getContactNumber(),citizen.getGender(),citizen.getDob(),citizen.getImgview()
            ));
        }
        return citizenDtos;
    }
    @Override
     public CitizenDto convertToDto(Citizen citizen) {
        return new CitizenDto(
                citizen.getCitizenId(),citizen.getName(),citizen.getAddress(),
                citizen.getContactNumber(),citizen.getGender(),citizen.getDob(),citizen.getImgview()
        );
    }
}