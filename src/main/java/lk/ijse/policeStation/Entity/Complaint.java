package lk.ijse.policeStation.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complaint {
    private String ComplainId;
    private String DescriptionOfIncident;
    private String Date;
    private String CitizenId;
    private String OfficerId;
    private String TypeOfIncident;
    private String LocationOfIncident;
    private String Evidence;
    private String WitnessInformation;
    private String SuspectName;
    private String SuspectAddress;
    private String SuspectContactNumber;
    private String StatusOfTheComplaint;
    private String SuspectEmail;
}
