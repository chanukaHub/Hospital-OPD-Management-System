package lk.usj.OPD_Management.java.dto;

import java.util.Date;

public class ReceptionistDTO extends StaffDTO {
    public ReceptionistDTO() {
    }

    public ReceptionistDTO(String username, String password) {
        super(username, password);
    }

    public ReceptionistDTO(String username, String name, String gender, String phoneNumber, String idCard, Date dateOfBirth, String address, String maritalStatus, String password, String staffID, String staffEmail, Date dateOfJoin, String photograph, String document, String note) {
        super(username, name, gender, phoneNumber, idCard, dateOfBirth, address, maritalStatus, password, staffID, staffEmail, dateOfJoin, photograph, document, note);
    }
}
