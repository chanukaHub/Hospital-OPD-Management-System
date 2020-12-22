package lk.usj.OPD_Management.java.dto;

import lk.usj.OPD_Management.java.entity.Doctor;
import lk.usj.OPD_Management.java.entity.Patient;

import java.time.LocalTime;
import java.util.Date;

public class AppointmentDTO {
    private String appointmentId;
    private PatientDTO patient;
    private DoctorDTO doctor;
    private int appointmentNo;
    private Date appointmentDate;
    private String appointmentTime;
    private String symptoms;
    private String Status;

    public AppointmentDTO() {
    }

    public AppointmentDTO(String appointmentId, PatientDTO patient, DoctorDTO doctor, int appointmentNo, Date appointmentDate, String appointmentTime, String symptoms, String status) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentNo = appointmentNo;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.symptoms = symptoms;
        Status = status;
    }

    public PatientDTO getPatient() {
        return patient;
    }

    public void setPatient(PatientDTO patient) {
        this.patient = patient;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getAppointmentNo() {
        return appointmentNo;
    }

    public void setAppointmentNo(int appointmentNo) {
        this.appointmentNo = appointmentNo;
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", appointmentNo=" + appointmentNo +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                ", symptoms='" + symptoms + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
