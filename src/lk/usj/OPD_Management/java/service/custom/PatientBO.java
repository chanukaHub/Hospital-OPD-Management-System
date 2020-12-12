package lk.usj.OPD_Management.java.service.custom;

import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.service.SuperBO;

import java.io.IOException;

public interface PatientBO extends SuperBO {
    boolean addPatient(PatientDTO patientDTO) throws Exception;
}
