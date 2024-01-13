package lk.ijse.policeStation.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fines {
    private String TxtFinesId;
    private String TxtFinesDescrip;
    private Double TxtFinesAmount;
    private String TxtFinesDate;
    private String CmbDriverId;
}
