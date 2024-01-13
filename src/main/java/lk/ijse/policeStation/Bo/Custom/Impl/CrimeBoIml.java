package lk.ijse.policeStation.Bo.Custom.Impl;

import lk.ijse.policeStation.Bo.Custom.CrimeBo;
import lk.ijse.policeStation.Dao.CrimeDao;
import lk.ijse.policeStation.Dao.custom.Impl.CrimeDaoImpl;
import lk.ijse.policeStation.Entity.Crime;
import lk.ijse.policeStation.dto.CrimeDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CrimeBoIml implements CrimeBo {
    private final CrimeDao crimeDao = new CrimeDaoImpl();
    @Override
    public boolean deleteCrime(String id) throws SQLException, ClassNotFoundException {
        return crimeDao.delete(id);
   }
    @Override
   public boolean saveCrime(CrimeDto crimeDto) throws SQLException, ClassNotFoundException {
    return crimeDao.save(new Crime(crimeDto.getCrimeID(),crimeDto.getDeatails(),crimeDto.getDate(),
            crimeDto.getTxtTypeOfCrime(),crimeDto.getTxtLocation(),crimeDto.getCriminalRecord(),crimeDto.getInjuries(),crimeDto.getTxtMotiveReson(),crimeDto.getTxtWeponUsed(),crimeDto.getTxtStatus()));
    }
    @Override
   public ArrayList<CrimeDto> getAllCrimes() throws SQLException, ClassNotFoundException {
       List<Crime> crimes = crimeDao.getAllCrimes();
       ArrayList<CrimeDto> crimeDtos = new ArrayList<>();

       for (Crime crime : crimes) {
           CrimeDto crimeDto = convertToDto(crime);
           crimeDtos.add(crimeDto);
       }

       return crimeDtos;
   }
    @Override
    public Optional<CrimeDto> searchCrime(String code) throws SQLException, ClassNotFoundException {
        Optional<Crime> optionalCrime = crimeDao.search(code);

        return optionalCrime.map(this::convertToDto);
    }
    @Override
    public CrimeDto convertToDto(Crime crime) {
        return new CrimeDto(crime.getCrimeID(),crime.getDeatails(),crime.getDate(),
                crime.getTxtTypeOfCrime(),crime.getTxtLocation(),crime.getCriminalRecord(),
                crime.getInjuries(),crime.getTxtMotiveReson(),crime.getTxtWeponUsed(),crime.getTxtStatus()
                );
    }
    @Override
    public boolean updateCrime(CrimeDto updatedCrimeDto) throws SQLException, ClassNotFoundException {
    return crimeDao.update(new Crime(updatedCrimeDto.getCrimeID(),updatedCrimeDto.getDeatails(),updatedCrimeDto.getDate(),
            updatedCrimeDto.getTxtTypeOfCrime(),updatedCrimeDto.getTxtLocation(),updatedCrimeDto.getCriminalRecord(),updatedCrimeDto.getInjuries(),updatedCrimeDto.getTxtMotiveReson(),updatedCrimeDto.getTxtWeponUsed(),updatedCrimeDto.getTxtStatus()));
    }

}
