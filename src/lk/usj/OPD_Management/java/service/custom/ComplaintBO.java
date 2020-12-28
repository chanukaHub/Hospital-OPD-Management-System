package lk.usj.OPD_Management.java.service.custom;

import lk.usj.OPD_Management.java.dto.ComplaintDTO;
import lk.usj.OPD_Management.java.service.SuperBO;

public interface ComplaintBO extends SuperBO {
    int getNextComplainID() throws Exception;

    boolean addComplaint(ComplaintDTO complaintDTO) throws Exception;
}
