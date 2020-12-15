package lk.usj.OPD_Management.java.entity;

import java.util.Date;

public class Receptionist extends Staff{
    public Receptionist() {
    }

    public Receptionist(String username, String name, String gender, String phoneNumber, String idCard, Date dateOfBirth, String address, String maritalStatus, String password, int staffID, String staffEmail, Date dateOfJoin, String photograph, String document, String note) {
        super(username, name, gender, phoneNumber, idCard, dateOfBirth, address, maritalStatus, password, staffID, staffEmail, dateOfJoin, photograph, document, note);
    }
}
