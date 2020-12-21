package lk.usj.OPD_Management.java.service.custom;

import lk.usj.OPD_Management.java.service.SuperBO;

public interface AppointmentBO extends SuperBO {
    int getNextAppointmentID()throws Exception;
}
