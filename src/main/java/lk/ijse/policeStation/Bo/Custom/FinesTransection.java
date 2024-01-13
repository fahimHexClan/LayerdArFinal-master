package lk.ijse.policeStation.Bo.Custom;

import lk.ijse.policeStation.controller.ManageFinesFormController;
import lk.ijse.policeStation.dto.FinesDto;

import java.sql.SQLException;

public interface FinesTransection {
    public void PlaceOrder(FinesDto finesDto, String driveId, ManageFinesFormController manageFinesFormController) throws SQLException ;

    }
