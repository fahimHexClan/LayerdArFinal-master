package lk.ijse.policeStation.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoliceReportDto {
    public String TxtReportId;
    public String TxtDescription;
    public String TxtDate;
    public String CmdCitizenIds;
    public String CmdUserIds;

}
