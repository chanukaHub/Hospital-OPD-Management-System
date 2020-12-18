package lk.usj.OPD_Management.java.dto;

import lk.usj.OPD_Management.java.entity.Doctor;
import lk.usj.OPD_Management.java.entity.Patient;

import java.time.LocalTime;
import java.util.Date;

public class AppointmentDTO {
    private Patient patient;
    private Doctor doctor;
    private Date appointmentDate;
    private LocalTime appointmentTime;
    private String symptoms;
    private String Status;

    public AppointmentDTO() {
    }

    public AppointmentDTO(Patient patient, Doctor doctor, Date appointmentDate, LocalTime appointmentTime, String symptoms, String status) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.symptoms = symptoms;
        Status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime) {
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

    @Override
    public String toString() {
        return "Appointments{" +
                "patient=" + patient +
                ", doctor=" + doctor +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime=" + appointmentTime +
                ", symptoms='" + symptoms + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
