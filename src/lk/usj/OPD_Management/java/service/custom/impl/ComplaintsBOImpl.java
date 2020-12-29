package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.ComplaintDAO;
import lk.usj.OPD_Management.java.dao.custom.VisitorDAO;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.dto.ComplaintDTO;
import lk.usj.OPD_Management.java.dto.DoctorDTO;
import lk.usj.OPD_Management.java.entity.Complaint;
import lk.usj.OPD_Management.java.entity.Doctor;
import lk.usj.OPD_Management.java.entity.Visitor;
import lk.usj.OPD_Management.java.service.custom.ComplaintBO;

import java.util.ArrayList;

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

    @Override
    public ArrayList<ComplaintDTO> getAllComplaint() throws Exception {
        ArrayList<Complaint> allComplaints = complaintDAO.getAll();
        ArrayList<ComplaintDTO> complaints = new ArrayList<>();
        for (Complaint complaint : allComplaints) {
            complaints.add(new ComplaintDTO(
                    complaint.getComplaintId(),
                    complaint.getType(),
                    complaint.getComplaintBy(),
                    complaint.getPhoneNumber(),
                    complaint.getDate(),
                    complaint.getDescription(),
                    complaint.getActionTaken(),
                    complaint.getNote(),
                    complaint.getAttachDocument(),
                    complaint.getStatus()
            ));

        }
        return complaints;
    }

    @Override
    public boolean updateComplaint(ComplaintDTO complaintDTO) throws Exception {
        return complaintDAO.update(new Complaint(
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

    @Override
    public int countNewComplaints() throws Exception {
        return complaintDAO.countNewComplaints();
    }

    @Override
    public ArrayList<ComplaintDTO> getComplaintUsingPatientUsername(String patientUsername) throws Exception {
        ArrayList<ComplaintDTO> complaintDTOS=getAllComplaint();
        ArrayList<ComplaintDTO> thisPatientComplaints =new ArrayList<>();
        for (ComplaintDTO complaintDTO:complaintDTOS){
            if (complaintDTO.getComplaintBy().equals(patientUsername)){
                thisPatientComplaints.add(complaintDTO);
            }
        }
        return thisPatientComplaints;
    }

    @Override
    public ArrayList<ComplaintDTO> getNewComplaints() throws Exception {
        ArrayList<ComplaintDTO> complaintDTOS=getAllComplaint();
        ArrayList<ComplaintDTO> newComplaints =new ArrayList<>();
        for (ComplaintDTO complaintDTO:complaintDTOS){
            if (complaintDTO.getStatus().equals("NEW")){
                newComplaints.add(complaintDTO);
            }
        }
        return newComplaints;
    }
}
