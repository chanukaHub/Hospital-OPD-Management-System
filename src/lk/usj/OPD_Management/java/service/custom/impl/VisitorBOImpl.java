package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.VisitorDAO;

public class VisitorBOImpl {
    private VisitorDAO adminDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ADMIN);

    public VisitorBOImpl() {
    }

}
