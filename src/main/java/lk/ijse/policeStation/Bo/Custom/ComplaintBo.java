package lk.ijse.policeStation.Bo.Custom;

import lk.ijse.policeStation.Entity.Complaint;
import lk.ijse.policeStation.dto.ComplaintDto;

import java.sql.SQLException;
import java.util.Optional;

public interface ComplaintBo {

    public boolean deleteComplaint(String id) throws SQLException, ClassNotFoundException ;
    boolean saveComplaint(ComplaintDto complaintDto) throws SQLException, ClassNotFoundException;

    Optional<ComplaintDto> searchComplaint(String code) throws SQLException, ClassNotFoundException;

    boolean updateComplaint(ComplaintDto updatedComplaintDto) throws SQLException, ClassNotFoundException;
    ComplaintDto convertToDto(Complaint complaint) ;

    }
