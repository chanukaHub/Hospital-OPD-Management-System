package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.ComplaintDAO;
import lk.usj.OPD_Management.java.dao.custom.VisitorDAO;
import lk.usj.OPD_Management.java.dto.ComplaintDTO;
import lk.usj.OPD_Management.java.entity.Complaint;
import lk.usj.OPD_Management.java.entity.Visitor;
import lk.usj.OPD_Management.java.service.custom.ComplaintBO;

public class ComplaintsBOImpl implements ComplaintBO {
    private ComplaintDAO complaintDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.COMPLAINT);

    @Override
    public int getNextComplainID() throws Exception {
        return (complaintDAO.getLastVisitorID()+1);
    }

    @Override
    public boolean addComplaint(ComplaintDTO complaintDTO) throws Exception {
        return complaintDAO.save(new Complaint(
                complaintDTO.getComplaintId(),
                complaintDTO.getType(),
                complaintDTO.getComplaintBy(),
                complaintDTO.getPhoneNumber(),
                complaintDTO.getDate(),
                complaintDTO.getDescription(),
                complaintDTO.getActionTaken(),
                complaintDTO.getNote(),
                complaintDTO.getAttachDocument(),
                complaintDTO.getStatus()

        ));
    }
}
