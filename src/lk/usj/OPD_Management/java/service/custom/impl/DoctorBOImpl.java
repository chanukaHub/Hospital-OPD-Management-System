package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.DoctorDAO;
import lk.usj.OPD_Management.java.dao.custom.PatientDAO;
import lk.usj.OPD_Management.java.dto.DoctorDTO;
import lk.usj.OPD_Management.java.entity.Doctor;
import lk.usj.OPD_Management.java.entity.Patient;
import lk.usj.OPD_Management.java.service.custom.DoctorBO;

public class DoctorBOImpl implements DoctorBO {
    private DoctorDAO doctorDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DOCTOR);
    @Override
    public int getNextDoctorID() throws Exception {
        return (doctorDAO.getLastDoctorID()+1);
    }

    @Override
    public boolean addDoctor(DoctorDTO doctorDTO) throws Exception {
        return doctorDAO.save(new Doctor(
                doctorDTO.getUsername(),
                doctorDTO.getName(),
                doctorDTO.getGender(),
                doctorDTO.getPhoneNumber(),
                doctorDTO.getIdCard(),
                doctorDTO.getDateOfBirth(),
                doctorDTO.getAddress(),
                doctorDTO.getMaritalStatus(),
                doctorDTO.getPassword(),
                doctorDTO.getStaffID(),
                doctorDTO.getStaffEmail(),
                doctorDTO.getDateOfJoin(),
                doctorDTO.getPhotograph(),
                doctorDTO.getDocument(),
                doctorDTO.getNote(),
                doctorDTO.getSpecialistArea()
        ));
    }
}
