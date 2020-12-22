package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.AppointmentDAO;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.entity.Appointment;
import lk.usj.OPD_Management.java.entity.Doctor;
import lk.usj.OPD_Management.java.entity.Patient;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;

public class AppointmentBOImpl implements AppointmentBO {
    private AppointmentDAO appointmentDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.APPOINTMENT);
    @Override
    public int getNextAppointmentID() throws Exception {
        return (appointmentDAO.getLastAppointmentID()+1);
    }

    @Override
    public boolean addAppointment(AppointmentDTO appointmentDTO) throws Exception {
        Patient patient=new Patient(
                appointmentDTO.getPatient().getUsername(),
                appointmentDTO.getPatient().getName(),
                appointmentDTO.getPatient().getGender(),
                appointmentDTO.getPatient().getPhoneNumber(),
                appointmentDTO.getPatient().getIdCard(),
                appointmentDTO.getPatient().getDateOfBirth(),
                appointmentDTO.getPatient().getAddress(),
                appointmentDTO.getPatient().getMaritalStatus(),
                appointmentDTO.getPatient().getPassword(),
                appointmentDTO.getPatient().getBloodGroup(),
                appointmentDTO.getPatient().getAllergies(),
                appointmentDTO.getPatient().getNote());
        Doctor doctor =new Doctor(
                appointmentDTO.getDoctor().getUsername(),
                appointmentDTO.getDoctor().getName(),
                appointmentDTO.getDoctor().getGender(),
                appointmentDTO.getDoctor().getPhoneNumber(),
                appointmentDTO.getDoctor().getIdCard(),
                appointmentDTO.getDoctor().getDateOfBirth(),
                appointmentDTO.getDoctor().getAddress(),
                appointmentDTO.getDoctor().getMaritalStatus(),
                appointmentDTO.getDoctor().getPassword(),
                appointmentDTO.getDoctor().getStaffID(),
                appointmentDTO.getDoctor().getStaffEmail(),
                appointmentDTO.getDoctor().getDateOfJoin(),
                appointmentDTO.getDoctor().getPhotograph(),
                appointmentDTO.getDoctor().getDocument(),
                appointmentDTO.getDoctor().getNote(),
                appointmentDTO.getDoctor().getSpecialistArea()
        );

        return appointmentDAO.save(new Appointment(
                appointmentDTO.getAppointmentId(),
                patient,
                doctor,
                appointmentDTO.getAppointmentNo(),
                appointmentDTO.getAppointmentDate(),
                appointmentDTO.getAppointmentTime(),
                appointmentDTO.getSymptoms(),
                appointmentDTO.getStatus()
        ));
    }
}
