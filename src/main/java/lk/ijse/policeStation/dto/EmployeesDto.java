package lk.ijse.policeStation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesDto {
    private String TxtEmpId;
    private String TxtEmpName;
    private String TxtAddress;
    private String TxtContactNumber;
    private String TxtGender;
    private String TxtEmpType;
    private String TxtRank;
    private String TxtDob;
    private String TxtOfficerId;
    private String TxtUsrId;
    private byte[] ImgEmployee;


}
