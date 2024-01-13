package lk.ijse.policeStation.Bo.Custom.Impl;

import lk.ijse.policeStation.Bo.Custom.ComplaintBo;
import lk.ijse.policeStation.Dao.ComplaintDao;
import lk.ijse.policeStation.Dao.custom.Impl.ComplaintDaoImpl;
import lk.ijse.policeStation.Entity.Citizen;
import lk.ijse.policeStation.Entity.Complaint;
import lk.ijse.policeStation.dto.CitizenDto;
import lk.ijse.policeStation.dto.ComplaintDto;

import java.sql.SQLException;
import java.util.Optional;

public class ComplaintBoImpl implements ComplaintBo {
    ComplaintDao complaintDao=new ComplaintDaoImpl();
    @Override
    public boolean deleteComplaint(String id) throws SQLException, ClassNotFoundException {
        return complaintDao.delete(id);
    }
    @Override
    public boolean saveComplaint(ComplaintDto complaintDto) throws SQLException, ClassNotFoundException {
        return complaintDao.save(new Complaint(complaintDto.getComplainId(),complaintDto.getDescriptionOfIncident(),complaintDto.getDate(),complaintDto.getCitizenId(),complaintDto.getOfficerId(),
                complaintDto.getTypeOfIncident(),complaintDto.getLocationOfIncident(),complaintDto.getEvidence(),complaintDto.getWitnessInformation(),complaintDto.getSuspectName(),complaintDto.getSuspectAddress()
                ,complaintDto.getSuspectContactNumber(),complaintDto.getStatusOfTheComplaint(),complaintDto.getSuspectEmail()));
    }
    @Override
    public Optional<ComplaintDto> searchComplaint(String code) throws SQLException, ClassNotFoundException {
        Optional<Complaint> optionalComplaint = complaintDao.search(code);

        return optionalComplaint.map(this::convertToDto);
    }
    @Override
    public ComplaintDto convertToDto(Complaint complaint) {
        return new ComplaintDto(
                complaint.getComplainId(),complaint.getDescriptionOfIncident(),complaint.getDate(),complaint.getCitizenId(),complaint.getOfficerId(),
                complaint.getTypeOfIncident(),complaint.getLocationOfIncident(),complaint.getEvidence(),complaint.getWitnessInformation(),complaint.getSuspectName(),complaint.getSuspectAddress()
                ,complaint.getSuspectContactNumber(),complaint.getStatusOfTheComplaint(),complaint.getSuspectEmail()  );
    }


    @Override
    public boolean updateComplaint(ComplaintDto updatedComplaintDto) throws SQLException, ClassNotFoundException {
        return complaintDao.update(new Complaint(updatedComplaintDto.getComplainId(),updatedComplaintDto.getDescriptionOfIncident(),updatedComplaintDto.getDate(),updatedComplaintDto.getCitizenId(),updatedComplaintDto.getOfficerId(),
                updatedComplaintDto.getTypeOfIncident(),updatedComplaintDto.getLocationOfIncident(),updatedComplaintDto.getEvidence(),updatedComplaintDto.getWitnessInformation(),updatedComplaintDto.getSuspectName(),updatedComplaintDto.getSuspectAddress()
                ,updatedComplaintDto.getSuspectContactNumber(),updatedComplaintDto.getStatusOfTheComplaint(),updatedComplaintDto.getSuspectEmail()));

    }
}
