package lk.ijse.policeStation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitizenDto {
    private String CitizenId;
    private String Name;
    private String Address;
    private String ContactNumber;
    private String Gender;
    private String Dob;
    private byte[] imgview;
}
