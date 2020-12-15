package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.PatientDAO;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.entity.Patient;
import lk.usj.OPD_Management.java.entity.User;
import lk.usj.OPD_Management.java.service.custom.PatientBO;

import java.io.IOException;
import java.util.ArrayList;

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

    @Override
    public ArrayList<PatientDTO> getAllPatient() throws Exception {
        ArrayList<Patient> allPatient = patientDAO.getAll();
        ArrayList<PatientDTO> patients = new ArrayList<>();
        for (Patient patient : allPatient) {
            patients.add(new PatientDTO(patient.getIdCard(), patient.getName(), patient.getUsername(),patient.getGender(),patient.getAddress(),patient.getPhoneNumber()));
        }
        return patients;
    }
}
