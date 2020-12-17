package lk.usj.OPD_Management.java.service.custom;

import lk.usj.OPD_Management.java.dto.ReceptionistDTO;
import lk.usj.OPD_Management.java.service.SuperBO;

public interface ReceptionistBO extends SuperBO {
    int getNextReceptionistID() throws Exception;

    boolean addReceptionist(ReceptionistDTO receptionistDTO) throws Exception;
}
