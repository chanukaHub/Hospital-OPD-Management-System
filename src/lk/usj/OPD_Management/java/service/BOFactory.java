package lk.usj.OPD_Management.java.service;

import lk.usj.OPD_Management.java.service.custom.impl.DoctorBOImpl;
import lk.usj.OPD_Management.java.service.custom.impl.LoginBOImpl;
import lk.usj.OPD_Management.java.service.custom.impl.PatientBOImpl;
import lk.usj.OPD_Management.java.service.custom.impl.VisitorBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }

        return boFactory;
    }

    public <T extends SuperBO> T getBO(BOFactory.BOTypes boType) {
        switch(boType) {
            case LOG_IN:
                return (T) new LoginBOImpl();
            case PATIENT:
                return (T) new PatientBOImpl();
            case VISITOR:
                return (T) new VisitorBOImpl();
            case DOCTOR:
                return (T) new DoctorBOImpl();
            default:
                return null;
        }
    }

    public static enum BOTypes {
         LOG_IN,
        PATIENT,
        VISITOR,
        DOCTOR
    }
}
