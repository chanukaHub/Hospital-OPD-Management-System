package lk.usj.OPD_Management.java.service.custom;

import lk.usj.OPD_Management.java.dto.AdminDTO;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.dto.ReceptionistDTO;
import lk.usj.OPD_Management.java.dto.UserDTO;
import lk.usj.OPD_Management.java.service.SuperBO;

public interface LoginBO extends SuperBO {
    boolean isValidAdminPassword(AdminDTO user) throws Exception;

    boolean isValidReceptionistPassword(ReceptionistDTO receptionistDTO) throws Exception;

    boolean isValidPatientPassword(PatientDTO patientDTO) throws Exception;
}
