package lk.usj.OPD_Management.java.service.custom;

import lk.usj.OPD_Management.java.dto.ReceptionistDTO;
import lk.usj.OPD_Management.java.service.SuperBO;

import java.util.ArrayList;

public interface ReceptionistBO extends SuperBO {
    int getNextReceptionistID() throws Exception;

    boolean addReceptionist(ReceptionistDTO receptionistDTO) throws Exception;

    ArrayList<ReceptionistDTO> getAllReceptionist() throws Exception;

    boolean updateReceptionist(ReceptionistDTO receptionistDTO)throws Exception;

    boolean deleteReceptionist(String text)throws Exception;
}
