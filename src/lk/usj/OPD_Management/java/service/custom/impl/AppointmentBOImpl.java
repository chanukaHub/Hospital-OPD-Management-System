package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.AppointmentDAO;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;

public class AppointmentBOImpl implements AppointmentBO {
    private AppointmentDAO appointmentDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.APPOINTMENT);
    @Override
    public int getNextAppointmentID() throws Exception {
        return (appointmentDAO.getLastAppointmentID()+1);
    }
}
