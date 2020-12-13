package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.VisitorDAO;
import lk.usj.OPD_Management.java.service.custom.VisitorBO;

public class VisitorBOImpl implements VisitorBO {
    private VisitorDAO visitorDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VISITOR);

    public VisitorBOImpl() {
    }



}
