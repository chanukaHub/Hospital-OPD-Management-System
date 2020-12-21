package lk.usj.OPD_Management.java.entity;

import java.time.LocalTime;
import java.util.Date;

public class Appointment {
    private String appointmentId;
    private Patient patient;
    private Doctor doctor;
    private int appointmentNo;
    private Date appointmentDate;
    private LocalTime appointmentTime;
    private String symptoms;
    private String Status;

    public Appointment() {
    }

    public Appointment(String appointmentId, Patient patient, Doctor doctor, int appointmentNo, Date appointmentDate, LocalTime appointmentTime, String symptoms, String status) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentNo = appointmentNo;
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
        return "Appointment{" +
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
