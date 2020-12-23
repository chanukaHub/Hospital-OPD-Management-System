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
    private String status;
    private String patientUsername;
    private String patientName;
    private String patientPhone;
    private String doctorUsername;
    private String doctorName;
    private String specialistArea;

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
        this.status = status;
    }

    public AppointmentDTO(String appointmentId, int appointmentNo, Date appointmentDate, String appointmentTime, String symptoms, String status, String patientUsername, String patientName, String patientPhone, String doctorUsername, String doctorName, String specialistArea) {
        this.appointmentId = appointmentId;
        this.appointmentNo = appointmentNo;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.symptoms = symptoms;
        this.status = status;
        this.patientUsername = patientUsername;
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.doctorUsername = doctorUsername;
        this.doctorName = doctorName;
        this.specialistArea = specialistArea;
    }

    public AppointmentDTO(String appointmentId, PatientDTO patient, DoctorDTO doctor, int appointmentNo, Date appointmentDate, String appointmentTime, String symptoms, String status, String patientUsername, String patientName, String patientPhone, String doctorUsername, String doctorName, String specialistArea) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentNo = appointmentNo;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.symptoms = symptoms;
        this.status = status;
        this.patientUsername = patientUsername;
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.doctorUsername = doctorUsername;
        this.doctorName = doctorName;
        this.specialistArea = specialistArea;
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
        return status;
    }

    public void setStatus(String status) {
        status = status;
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

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientUsername() {
        return patientUsername;
    }

    public void setPatientUsername(String patientUsername) {
        this.patientUsername = patientUsername;
    }

    public String getDoctorUsername() {
        return doctorUsername;
    }

    public void setDoctorUsername(String doctorUsername) {
        this.doctorUsername = doctorUsername;
    }

    public String getSpecialistArea() {
        return specialistArea;
    }

    public void setSpecialistArea(String specialistArea) {
        this.specialistArea = specialistArea;
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patient=" + patient +
                ", doctor=" + doctor +
                ", appointmentNo=" + appointmentNo +
                ", appointmentDate=" + appointmentDate +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", Status='" + status + '\'' +
                ", patientUsername='" + patientUsername + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientPhone='" + patientPhone + '\'' +
                ", doctorUsername='" + doctorUsername + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", specialistArea='" + specialistArea + '\'' +
                '}';
    }
}
