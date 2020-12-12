package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.PatientDAO;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.entity.Patient;
import lk.usj.OPD_Management.java.service.custom.PatientBO;

import java.io.IOException;

public class PatientBOImpl implements PatientBO {
    private PatientDAO patientDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PATIENT);

    @Override
    public boolean addPatient(PatientDTO patientDTO) throws Exception {
        return patientDAO.save(new Patient(
                patientDTO.getUsername(),
                patientDTO.getName(),
                patientDTO.getGender(),
                patientDTO.getPhoneNumber(),
                patientDTO.getIdCard(),
                patientDTO.getDateOfBirth(),
                patientDTO.getAddress(),
                patientDTO.getMaritalStatus(),
                patientDTO.getPassword(),
                patientDTO.getBloodGroup(),
                patientDTO.getAllergies(),
                patientDTO.getNote()
        ));
    }
}
