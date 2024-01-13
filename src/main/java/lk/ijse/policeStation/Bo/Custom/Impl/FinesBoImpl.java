package lk.ijse.policeStation.Bo.Custom.Impl;

import lk.ijse.policeStation.Bo.Custom.FinesBo;
import lk.ijse.policeStation.Dao.FinesDao;
import lk.ijse.policeStation.Dao.custom.Impl.FinesDaoImpl;
import lk.ijse.policeStation.dto.FinesDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FinesBoImpl implements FinesBo {
    private final FinesDao finesDao = new FinesDaoImpl();

    public boolean saveFines(FinesDto finesDto) throws SQLException, ClassNotFoundException {
        return finesDao.save(new lk.ijse.policeStation.Entity.Fines(finesDto.getTxtFinesId(),finesDto.getTxtFinesDescrip(),finesDto.getTxtFinesAmount(),
                finesDto.getTxtFinesDate(),finesDto.getCmbDriverId()));
    }

    public ArrayList<FinesDto> getAllFines() throws SQLException, ClassNotFoundException {
        List<lk.ijse.policeStation.Entity.Fines> fines = finesDao.getAllFines();
        ArrayList<FinesDto> finesDtos = new ArrayList<>();

        for (lk.ijse.policeStation.Entity.Fines fines1 : fines) {
            FinesDto finesDto = convertToDto(fines1);
            finesDtos.add(finesDto);
        }
        return finesDtos;
    }

    private FinesDto convertToDto(lk.ijse.policeStation.Entity.Fines fines1) {
        return new FinesDto(fines1.getTxtFinesId(),fines1.getTxtFinesDescrip(),fines1.getTxtFinesAmount(),
                fines1.getTxtFinesDate(),fines1.getCmbDriverId()
        );
    }

    public Optional<FinesDto> searchFines(String code) throws SQLException, ClassNotFoundException {
        Optional<lk.ijse.policeStation.Entity.Fines> optionalFines = finesDao.search(code);
        return optionalFines.map(this::convertToDto);
    }

    public boolean updateFines(FinesDto updatedFines) throws SQLException, ClassNotFoundException {
        return finesDao.update(new lk.ijse.policeStation.Entity.Fines(updatedFines.getTxtFinesId(),updatedFines.getTxtFinesDescrip(),updatedFines.getTxtFinesAmount(),
                updatedFines.getTxtFinesDate(),updatedFines.getCmbDriverId()));
    }
}
