package lk.ijse.policeStation.Dao;
import lk.ijse.policeStation.Entity.Complaint;
import lk.ijse.policeStation.dto.ComplaintDto;

import java.sql.SQLException;
import java.util.Map;

public interface ComplaintDao extends CrudDao<Complaint>{


    //bar chart eke complaints details tika ganna
     Map<String, Integer> getComplaintDetails() throws SQLException, ClassNotFoundException;
}
