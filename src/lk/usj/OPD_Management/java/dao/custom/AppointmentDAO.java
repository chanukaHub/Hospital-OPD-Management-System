package lk.usj.OPD_Management.java.dao.custom;

import lk.usj.OPD_Management.java.dao.CrudDAO;
import lk.usj.OPD_Management.java.dao.SuperDAO;
import lk.usj.OPD_Management.java.entity.Appointment;

public interface AppointmentDAO extends CrudDAO<Appointment,String> {
    int getLastAppointmentID() throws Exception;
}
