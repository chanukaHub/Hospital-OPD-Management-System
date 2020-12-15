package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.DoctorDAO;
import lk.usj.OPD_Management.java.dao.custom.PatientDAO;
import lk.usj.OPD_Management.java.service.custom.DoctorBO;

public class DoctorBOImpl implements DoctorBO {
    private DoctorDAO doctorDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DOCTOR);
    @Override
    public int getNextDoctorID() throws Exception {
        return (doctorDAO.getLastDoctorID()+1);
    }
}
