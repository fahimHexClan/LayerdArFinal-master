package lk.ijse.policeStation.Dao.custom.Impl;

import lk.ijse.policeStation.Dao.ComplaintDao;
import lk.ijse.policeStation.Entity.Citizen;
import lk.ijse.policeStation.Entity.Complaint;
import lk.ijse.policeStation.dto.CitizenDto;
import lk.ijse.policeStation.dto.ComplaintDto;
import lk.ijse.policeStation.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ComplaintDaoImpl implements ComplaintDao {
    @Override
    public boolean save(Complaint complaint) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "insert into Complaint(ComplaintId ,description,date,CitizenId ,OfficerId,TypeOfIncident,LocationOfIncident,Evidence,WitnessInformation,SuspectName,SuspectAddress,SuspectContactNumber,StatusOfTheComplaint,SuspectEmail) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, complaintDto.getComplainId());
        stm.setString(2, complaintDto.getDescriptionOfIncident());
        stm.setString(3, complaintDto.getDate());
        stm.setString(4, complaintDto.getCitizenId());
        stm.setString(5, complaintDto.getOfficerId());
        stm.setString(6, complaintDto.getTypeOfIncident());
        stm.setString(7, complaintDto.getLocationOfIncident());
        stm.setString(8, complaintDto.getEvidence());
        stm.setString(9, complaintDto.getWitnessInformation());
        stm.setString(10, complaintDto.getSuspectName());
        stm.setString(11, complaintDto.getSuspectAddress());
        stm.setString(12, complaintDto.getSuspectContactNumber());
        stm.setString(13, complaintDto.getStatusOfTheComplaint());
        stm.setString(14, complaintDto.getSuspectEmail());

        int affectedRows = stm.executeUpdate();
        if (affectedRows > 0) {
            return true;
        } else {
            return false;
        }*/
        return CrudUtil.execute("insert into Complaint(ComplaintId ,description,date,CitizenId ,OfficerId,TypeOfIncident,LocationOfIncident,Evidence,WitnessInformation,SuspectName,SuspectAddress,SuspectContactNumber,StatusOfTheComplaint,SuspectEmail) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                complaint.getComplainId(), complaint.getDescriptionOfIncident(), complaint.getDate(), complaint.getCitizenId(), complaint.getOfficerId(), complaint.getTypeOfIncident(), complaint.getLocationOfIncident(), complaint.getEvidence(), complaint.getWitnessInformation(),
                complaint.getSuspectName(), complaint.getSuspectAddress(), complaint.getSuspectContactNumber(), complaint.getStatusOfTheComplaint(), complaint.getSuspectEmail());
    }

    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "DELETE FROM Complaint WHERE ComplaintId=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, id);
        int affectedRows = stm.executeUpdate();
        if (affectedRows > 0) {
            return true;
        } else {
            return false;
        }*/
        return CrudUtil.execute("DELETE FROM Complaint WHERE ComplaintId=?",id);
    }

    public Optional<Complaint> search(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Complaint WHERE ComplaintId=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, id);
        ResultSet rs = stm.executeQuery();*/
       /* ResultSet rs = CrudUtil.execute("SELECT * FROM Complaint WHERE ComplaintId=?", id);


        if (rs.next()) {
            String code = rs.getString(1);
            String description = rs.getString(2);
            String date = rs.getString(3);
            String CitizenId = rs.getString(4);
            String officerId = rs.getString(5);
            String TypeofIncident = rs.getString(6);
            String LocationofIncident = rs.getString(7);
            String Evidence = rs.getString(8);
            String WitnessInformation = rs.getString(9);
            String SuspectName = rs.getString(10);
            String SuspectAddress = rs.getString(11);
            String SuspectContactNumber = rs.getString(12);
            String StatusOfTheComplaint = rs.getString(13);
            String SuspectEmail = rs.getString(14);

            Complaint complaint = new Complaint();
            complaint.setComplainId(code);
            complaint.setDescriptionOfIncident(description);
            complaint.setDate(date);
            complaint.setCitizenId(CitizenId);
            complaint.setOfficerId(officerId);
            complaint.setTypeOfIncident(TypeofIncident);
            complaint.setLocationOfIncident(LocationofIncident);
            complaint.setEvidence(Evidence);
            complaint.setWitnessInformation(WitnessInformation);
            complaint.setSuspectName(SuspectName);
            complaint.setSuspectAddress(SuspectAddress);
            complaint.setSuspectContactNumber(SuspectContactNumber);
            complaint.setStatusOfTheComplaint(StatusOfTheComplaint);
            complaint.setSuspectEmail(SuspectEmail);


            return Optional.of(complaint);

        } else {
            return Optional.empty();
        }
*/

        ResultSet rst = CrudUtil.execute("SELECT * FROM Complaint WHERE ComplaintId=?", id);
        if (rst.next()) {
            return Optional.of(new Complaint(id, rst.getString("description"), rst.getString("date"), rst.getString("CitizenId"), rst.getString("OfficerId"), rst.getString("TypeOfIncident"),
                    rst.getString("LocationOfIncident"), rst.getString("Evidence"), rst.getString("WitnessInformation"), rst.getString("SuspectName"), rst.getString("SuspectAddress"), rst.getString("SuspectContactNumber"), rst.getString("StatusOfTheComplaint"), rst.getString("SuspectEmail")));
        } else {
            return Optional.empty();
        }

    }

    public boolean update(Complaint complaint) throws SQLException, ClassNotFoundException {
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "UPDATE Complaint SET description=?, date=?, CitizenId=?, OfficerId=?, TypeOfIncident=?, LocationOfIncident=?, Evidence=?, WitnessInformation=?, SuspectName=?, SuspectAddress=?, SuspectContactNumber=?, StatusOfTheComplaint=?,SuspectEmail=?WHERE ComplaintId=?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, complaintDto.getDescriptionOfIncident());
            stm.setString(2, complaintDto.getDate());
            stm.setString(3, complaintDto.getCitizenId());
            stm.setString(4, complaintDto.getOfficerId());
            stm.setString(5, complaintDto.getTypeOfIncident());
            stm.setString(6, complaintDto.getLocationOfIncident());
            stm.setString(7, complaintDto.getEvidence());
            stm.setString(8, complaintDto.getWitnessInformation());
            stm.setString(9, complaintDto.getSuspectName());
            stm.setString(10, complaintDto.getSuspectAddress());
            stm.setString(11, complaintDto.getSuspectContactNumber());
            stm.setString(12, complaintDto.getStatusOfTheComplaint());
            stm.setString(13, complaintDto.getComplainId());
            stm.setString(14, complaintDto.getSuspectEmail());

            int affectedRows = stm.executeUpdate();
            return affectedRows > 0;
        }*/
        return CrudUtil.execute("UPDATE Complaint SET description=?, date=?, CitizenId=?, OfficerId=?, TypeOfIncident=?, LocationOfIncident=?, Evidence=?, WitnessInformation=?, SuspectName=?, SuspectAddress=?, SuspectContactNumber=?, StatusOfTheComplaint=?, SuspectEmail=? WHERE ComplaintId=?",
                complaint.getDescriptionOfIncident(), complaint.getDate(), complaint.getCitizenId(), complaint.getOfficerId(), complaint.getTypeOfIncident(),
                complaint.getLocationOfIncident(), complaint.getEvidence(), complaint.getWitnessInformation(), complaint.getSuspectName(), complaint.getSuspectAddress(), complaint.getSuspectContactNumber(), complaint.getStatusOfTheComplaint(), complaint.getSuspectEmail(), complaint.getComplainId());

    }

    //bar chart eke complaints details tika ganna
    public Map<String, Integer> getComplaintDetails() throws SQLException, ClassNotFoundException {
        String sql = "SELECT date, COUNT(*) FROM Complaint GROUP BY date";
        ResultSet rs = CrudUtil.execute(sql);

        Map<String, Integer> complaintDetails = new HashMap<>();

        while (rs.next()) {
            String date = rs.getString("date");
            int count = rs.getInt(2);

            complaintDetails.put(date, count);
        }

        return complaintDetails;
        /*Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT date, COUNT(*) FROM Complaint GROUP BY date";
        PreparedStatement stm = connection.prepareStatement(sql);

        ResultSet rs = stm.executeQuery();
        Map<String, Integer> complaintDetails = new HashMap<>();

        while (rs.next()) {
            String date = rs.getString("date");
            int count = rs.getInt(2);

            complaintDetails.put(date, count);
        }

        return complaintDetails;

    }*/
    }
}