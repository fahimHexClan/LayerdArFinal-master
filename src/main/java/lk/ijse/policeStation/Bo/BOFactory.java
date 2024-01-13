package lk.ijse.policeStation.Bo;

import lk.ijse.policeStation.Bo.Custom.Impl.*;

public class BOFactory {
    public static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        Citizen,Complaint,Crime,Driver,Employee,Fines,PoliceReport,Vehicle;
    }

    public SuperBO getBO(BOTypes boFactory) {
        switch (boFactory) {
            case Citizen:
                return (SuperBO) new CitizenBoImpl();

            case Complaint:
                return (SuperBO) new ComplaintBoImpl();
            case Crime:
                return (SuperBO) new CrimeBoIml();
            case Driver:
                return (SuperBO) new DriverBoImpl();
            case Employee:
                return (SuperBO) new EmployeesBoImpl();
            case Fines:
                return (SuperBO) new FinesBoImpl();
            case PoliceReport:
                return (SuperBO) new PoliceReportBoImpl();
            case Vehicle:
                return (SuperBO) new VehicleBoImpl();
            default:
                return null;
        }
    }


}

