package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.AppointmentDAO;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.entity.Appointment;
import lk.usj.OPD_Management.java.entity.Doctor;
import lk.usj.OPD_Management.java.entity.Patient;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;

import java.util.ArrayList;

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
                appointmentDTO.getPatient().getNote()
        );
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

    @Override
    public ArrayList<AppointmentDTO> getPendingAppointmentList() throws Exception {
        String status ="Pending";
        ArrayList<Appointment> pendingAppointments = appointmentDAO.getAllAppointmentUsingStatus(status);
        ArrayList<AppointmentDTO> appointments = new ArrayList<>();
        for (Appointment appointment : pendingAppointments) {
            appointments.add(new AppointmentDTO(
                    appointment.getAppointmentId(),
                    appointment.getAppointmentNo(),
                    appointment.getAppointmentDate(),
                    appointment.getAppointmentTime(),
                    appointment.getSymptoms(),
                    appointment.getStatus(),
                    appointment.getPatient().getUsername(),
                    appointment.getPatient().getName(),
                    appointment.getPatient().getPhoneNumber(),
                    appointment.getDoctor().getUsername(),
                    appointment.getDoctor().getName(),
                    appointment.getDoctor().getSpecialistArea()));
        }
        return appointments;
    }

    @Override
    public int getNextAppointmentNo(String doctorUsername) throws Exception {
        return appointmentDAO.getNextAppointmentNo(doctorUsername);
    }

    @Override
    public void approveAppointment(String appointmentID,String appointmentNo) throws Exception {
        appointmentDAO.approveAppointment(appointmentID,appointmentNo);
    }

    @Override
    public ArrayList<AppointmentDTO> getApprovedAppointmentList() throws Exception {
        String status ="Approve";
        ArrayList<Appointment> pendingAppointments = appointmentDAO.getAllAppointmentUsingStatus(status);
        ArrayList<AppointmentDTO> appointments = new ArrayList<>();
        for (Appointment appointment : pendingAppointments) {
            appointments.add(new AppointmentDTO(
                    appointment.getAppointmentId(),
                    appointment.getAppointmentNo(),
                    appointment.getAppointmentDate(),
                    appointment.getAppointmentTime(),
                    appointment.getSymptoms(),
                    appointment.getStatus(),
                    appointment.getPatient().getUsername(),
                    appointment.getPatient().getName(),
                    appointment.getPatient().getPhoneNumber(),
                    appointment.getDoctor().getUsername(),
                    appointment.getDoctor().getName(),
                    appointment.getDoctor().getSpecialistArea()));
        }
        return appointments;
    }

    @Override
    public boolean updateAppointment(AppointmentDTO appointmentDTO) throws Exception {
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
                appointmentDTO.getPatient().getNote()
        );
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

        return appointmentDAO.update(new Appointment(
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

    @Override
    public ArrayList<AppointmentDTO> getAppointmentList() throws Exception {
        ArrayList<Appointment> pendingAppointments = appointmentDAO.getAll();
        ArrayList<AppointmentDTO> appointments = new ArrayList<>();
        for (Appointment appointment : pendingAppointments) {
            appointments.add(new AppointmentDTO(
                    appointment.getAppointmentId(),
                    appointment.getAppointmentNo(),
                    appointment.getAppointmentDate(),
                    appointment.getAppointmentTime(),
                    appointment.getSymptoms(),
                    appointment.getStatus(),
                    appointment.getPatient().getUsername(),
                    appointment.getPatient().getName(),
                    appointment.getPatient().getPhoneNumber(),
                    appointment.getDoctor().getUsername(),
                    appointment.getDoctor().getName(),
                    appointment.getDoctor().getSpecialistArea()));
        }
        return appointments;
    }

    @Override
    public boolean deleteAppointment(String appointmentId) throws Exception {
        return appointmentDAO.delete(appointmentId);
    }

    @Override
    public int countTodayAppointments() throws Exception {
        return appointmentDAO.countTodayAppointments();
    }

    @Override
    public ArrayList<AppointmentDTO> getApprovedAppointmentListUsingDoctorUsername(String username) throws Exception{
        ArrayList<AppointmentDTO> appointmentDTOS=getApprovedAppointmentList();
        ArrayList<AppointmentDTO> thisDoctorAppointments =new ArrayList<>();
        for (AppointmentDTO appointmentDTO:appointmentDTOS){
            if (appointmentDTO.getDoctorUsername().equals(username)){
                thisDoctorAppointments.add(appointmentDTO);
            }
        }
        return thisDoctorAppointments;
    }

    @Override
    public void completeAppointment(String text) throws Exception {
        appointmentDAO.completeAppointment(text);
    }

    @Override
    public int countPendingAppointmentsUsingDoctorUsername(String doctorUserName) throws Exception {
        return appointmentDAO.countPendingAppointmentsUsingDoctorUsername(doctorUserName,"Pending");
    }

    @Override
    public int countApproveAppointmentsUsingDoctorUsername(String doctorUserName) throws Exception {
        return appointmentDAO.countPendingAppointmentsUsingDoctorUsername(doctorUserName,"Approve");
    }

    @Override
    public int countCompletedAppointmentsUsingDoctorUsername(String doctorUserName) throws Exception {
        return appointmentDAO.countPendingAppointmentsUsingDoctorUsername(doctorUserName,"Completed");
    }

    @Override
    public ArrayList<AppointmentDTO> loadThisDoctorAppointmentTable(String doctorUserName) throws Exception {
        ArrayList<AppointmentDTO> appointmentDTOS=getAppointmentList();
        ArrayList<AppointmentDTO> thisDoctorAppointments =new ArrayList<>();
        for (AppointmentDTO appointmentDTO:appointmentDTOS){
            if (appointmentDTO.getDoctorUsername().equals(doctorUserName)){
                thisDoctorAppointments.add(appointmentDTO);
            }
        }
        return thisDoctorAppointments;
    }


}
