package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.VisitorDAO;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.dto.VisitorDTO;
import lk.usj.OPD_Management.java.entity.Patient;
import lk.usj.OPD_Management.java.entity.Visitor;
import lk.usj.OPD_Management.java.service.custom.VisitorBO;

import java.util.ArrayList;

public class VisitorBOImpl implements VisitorBO {
    private VisitorDAO visitorDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VISITOR);

    public VisitorBOImpl() {
    }


    @Override
    public boolean addVisitor(VisitorDTO visitorDTO) throws Exception {
        return visitorDAO.save(new Visitor(
                visitorDTO.getVisitorId(),
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

    @Override
    public int getNextVisitorID() throws Exception {
        return (visitorDAO.getLastVisitorID()+1);
    }

    @Override
    public ArrayList<VisitorDTO> getAllVisitor() throws Exception {
        ArrayList<Visitor> allVisitor = visitorDAO.getAll();
        ArrayList<VisitorDTO> visitors = new ArrayList<>();
        for (Visitor visitor : allVisitor) {
            visitors.add(new VisitorDTO(
                    visitor.getVisitorId(),
                    visitor.getVisitorName(),
                    visitor.getPurpose(),
                    visitor.getTelNo(),
                    visitor.getNicNo(),
                    visitor.getDate(),
                    visitor.getInTime(),
                    visitor.getOutTime(),
                    visitor.getAttachment(),
                    visitor.getNotes()
            ));
        }
        return visitors;
    }


}
