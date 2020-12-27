package lk.usj.OPD_Management.java.service.custom;

import lk.usj.OPD_Management.java.dto.*;
import lk.usj.OPD_Management.java.service.SuperBO;

import java.util.ArrayList;

public interface LoginBO extends SuperBO {
    boolean isValidAdminPassword(AdminDTO user) throws Exception;

    boolean isValidReceptionistPassword(ReceptionistDTO receptionistDTO) throws Exception;

    boolean isValidPatientPassword(PatientDTO patientDTO) throws Exception;

    boolean isValidDoctorPassword(DoctorDTO doctorDTO) throws Exception;

    ArrayList<LoginDTO> getLatestLoginUserList() throws Exception;
}
