package lk.ijse.policeStation.Bo.Custom.Impl;

import javafx.scene.control.Alert;
import lk.ijse.policeStation.Bo.Custom.DriverBo;
import lk.ijse.policeStation.Bo.Custom.FinesBo;
import lk.ijse.policeStation.Bo.Custom.FinesTransection;
import lk.ijse.policeStation.DB.DatabaseConnection;
import lk.ijse.policeStation.controller.ManageFinesFormController;
import lk.ijse.policeStation.dto.FinesDto;

import java.sql.Connection;
import java.sql.SQLException;

public class FinesBoTransectionImpl implements FinesTransection {
    DriverBo driverBo =new DriverBoImpl();
    FinesBo finesBo =new FinesBoImpl();

    public void PlaceOrder( FinesDto finesDto,String driveId,ManageFinesFormController manageFinesFormController) throws SQLException {
        Connection connection = null;

        try {
            connection = DatabaseConnection.getInstance().getConnection();
            connection.setAutoCommit(false);
            boolean isSuccess = finesBo.saveFines(finesDto);

            boolean b = driverBo.updateStatus(finesDto, driveId);
            if (!b) {
                connection.rollback();
                new Alert(Alert.AlertType.ERROR, "Data Not Added").show();
                return;
            }
            if (isSuccess) {
                new Alert(Alert.AlertType.INFORMATION, "Data added").show();
                manageFinesFormController.setTable();
            } else {
                connection.rollback();
                new Alert(Alert.AlertType.ERROR, "Data Not Added").show();
            }

        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            connection.rollback();
            e.printStackTrace();
        }finally {
            connection.setAutoCommit(true);
        }
    }
}
