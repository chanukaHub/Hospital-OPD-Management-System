package lk.usj.OPD_Management.java.entity;

import java.util.Date;

public class Admin extends User {
    public Admin() {
    }

    public Admin(String username, String name, String gender, String phoneNumber, String idCard, Date dateOfBirth, String address, String maritalStatus, String password) {
        super(username, name, gender, phoneNumber, idCard, dateOfBirth, address, maritalStatus, password);
    }
}
