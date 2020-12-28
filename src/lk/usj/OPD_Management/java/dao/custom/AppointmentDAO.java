package lk.usj.OPD_Management.java.dao.custom;

import lk.usj.OPD_Management.java.dao.CrudDAO;
import lk.usj.OPD_Management.java.entity.Appointment;

import java.util.ArrayList;

public interface AppointmentDAO extends CrudDAO<Appointment,String> {
    int getLastAppointmentID() throws Exception;

    ArrayList<Appointment> getAllAppointmentUsingStatus(String status) throws Exception;

    int getNextAppointmentNo(String doctorUsername)throws Exception;

    void approveAppointment(String currentAppointmentID,String currentAppointmentNo)throws Exception;

    int countTodayAppointments() throws Exception;

    void completeAppointment(String text) throws Exception;

    int countPendingAppointmentsUsingDoctorUsername(String doctorUserName, String status) throws Exception;
}
