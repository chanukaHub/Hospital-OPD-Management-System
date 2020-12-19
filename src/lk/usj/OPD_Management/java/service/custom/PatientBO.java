package lk.usj.OPD_Management.java.service.custom;

import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.service.SuperBO;

import java.io.IOException;
import java.util.ArrayList;

public interface PatientBO extends SuperBO {
    boolean addPatient(PatientDTO patientDTO) throws Exception;

    ArrayList<PatientDTO> getAllPatient() throws Exception;

    boolean updatePatient(PatientDTO patientDTO) throws Exception;
}
