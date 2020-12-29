package lk.usj.OPD_Management.java.service.custom;

import lk.usj.OPD_Management.java.dto.ComplaintDTO;
import lk.usj.OPD_Management.java.service.SuperBO;

import java.util.ArrayList;

public interface ComplaintBO extends SuperBO {
    int getNextComplainID() throws Exception;

    boolean addComplaint(ComplaintDTO complaintDTO) throws Exception;

    ArrayList<ComplaintDTO> getAllComplaint() throws Exception;

    boolean updateComplaint(ComplaintDTO complaintDTO)throws Exception;

    int countNewComplaints() throws Exception;

    ArrayList<ComplaintDTO> getComplaintUsingPatientUsername(String patientUsername) throws Exception;
}
