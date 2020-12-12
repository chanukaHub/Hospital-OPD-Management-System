package lk.usj.OPD_Management.java.dto;

import lk.usj.OPD_Management.java.entity.Staff;

import java.util.Date;

public class DoctorDTO extends StaffDTO{
    private String specialistArea;

    public DoctorDTO() {
    }

    public DoctorDTO(String username, String password) {
        super(username, password);
    }

    public DoctorDTO(String username, String name, String gender, String phoneNumber, String idCard, Date dateOfBirth, String address, String maritalStatus, String password, String staffID, String staffEmail, Date dateOfJoin, String photograph, String document, String note, String specialistArea) {
        super(username, name, gender, phoneNumber, idCard, dateOfBirth, address, maritalStatus, password, staffID, staffEmail, dateOfJoin, photograph, document, note);
        this.specialistArea = specialistArea;
    }
}
