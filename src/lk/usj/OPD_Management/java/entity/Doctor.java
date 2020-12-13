package lk.usj.OPD_Management.java.entity;

import java.util.Date;

public class Doctor extends Staff {
    private String specialistArea;

    public Doctor() {
    }

    public Doctor(String username, String name, String gender, String phoneNumber, String idCard, Date dateOfBirth, String address, String maritalStatus, String password, String staffID, String staffEmail, Date dateOfJoin, String photograph, String document, String note, String specialistArea) {
        super(username, name, gender, phoneNumber, idCard, dateOfBirth, address, maritalStatus, password, staffID, staffEmail, dateOfJoin, photograph, document, note);
        this.specialistArea = specialistArea;
    }

    public String getSpecialistArea() {
        return specialistArea;
    }

    public void setSpecialistArea(String specialistArea) {
        this.specialistArea = specialistArea;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "specialistArea='" + specialistArea + '\'' +
                '}';
    }
}
