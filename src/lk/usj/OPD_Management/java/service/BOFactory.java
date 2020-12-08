package lk.usj.OPD_Management.java.service;

import lk.usj.OPD_Management.java.service.custom.impl.LoginBOImpl;

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
            default:
                return null;
        }
    }

    public static enum BOTypes {
         LOG_IN
    }
}
