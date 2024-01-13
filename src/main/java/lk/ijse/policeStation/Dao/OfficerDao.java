package lk.ijse.policeStation.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OfficerDao {
    public  ArrayList<String> getOfficerIds() throws SQLException, ClassNotFoundException ;

    }
