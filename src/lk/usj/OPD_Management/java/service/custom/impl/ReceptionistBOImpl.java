package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.ReceptionistDAO;
import lk.usj.OPD_Management.java.service.custom.ReceptionistBO;

public class ReceptionistBOImpl implements ReceptionistBO {
    private ReceptionistDAO receptionistDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RECEPTIONIST);
    @Override
    public int getNextReceptionistID() throws Exception {
        return (receptionistDAO.getLastReceptionistID()+1);
    }
}