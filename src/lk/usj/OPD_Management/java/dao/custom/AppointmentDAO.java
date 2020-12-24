package lk.usj.OPD_Management.java.dao.custom;

import lk.usj.OPD_Management.java.dao.CrudDAO;
import lk.usj.OPD_Management.java.entity.Appointment;

import java.util.ArrayList;

public interface AppointmentDAO extends CrudDAO<Appointment,String> {
    int getLastAppointmentID() throws Exception;

    ArrayList<Appointment> getAllAppointmentUsingStatus(String status) throws Exception;

    int getNextAppointmentNo(String doctorUsername)throws Exception;

    void approveAppointment(String currentAppointmentID)throws Exception;
}
