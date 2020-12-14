package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.VisitorDAO;
import lk.usj.OPD_Management.java.dto.VisitorDTO;
import lk.usj.OPD_Management.java.entity.Patient;
import lk.usj.OPD_Management.java.entity.Visitor;
import lk.usj.OPD_Management.java.service.custom.VisitorBO;

public class VisitorBOImpl implements VisitorBO {
    private VisitorDAO visitorDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VISITOR);

    public VisitorBOImpl() {
    }


    @Override
    public boolean addVisitor(VisitorDTO visitorDTO) throws Exception {
        return visitorDAO.save(new Visitor(
                visitorDTO.getVisitorName(),
                visitorDTO.getPurpose(),
                visitorDTO.getTelNo(),
                visitorDTO.getNicNo(),
                visitorDTO.getDate(),
                visitorDTO.getInTime(),
                visitorDTO.getOutTime(),
                visitorDTO.getAttachment(),
                visitorDTO.getNotes()
        ));
    }
}
