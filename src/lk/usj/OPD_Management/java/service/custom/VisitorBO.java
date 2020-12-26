package lk.usj.OPD_Management.java.service.custom;

import lk.usj.OPD_Management.java.dto.VisitorDTO;
import lk.usj.OPD_Management.java.service.SuperBO;

import java.util.ArrayList;

public interface VisitorBO extends SuperBO {

    boolean addVisitor(VisitorDTO visitorDTO)throws Exception;

    int getNextVisitorID() throws Exception;

    ArrayList<VisitorDTO> getAllVisitor() throws Exception;

    boolean updateVisitor(VisitorDTO visitorDTO) throws Exception;
}
