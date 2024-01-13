package lk.ijse.policeStation.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicale {
    private String TxtVehicleId;
    private String TxtEngineNum;
    private String TxtOwnerId;
    private String TxtPlateNum;
    private String TxtVehicleType;
    private String TxtModelId;

}
