package lk.ijse.policeStation.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Driver {
    private String TxtDriverId;
    private String TxtDriverName;
    private String TxtAddress;
    private String TxtContactNumber;
    private String TxtGender;
    private String TxtDob;
    private String TxtLicenseNumber;
    private String CmbVehicleId;
    private String FinesStatus;

}
