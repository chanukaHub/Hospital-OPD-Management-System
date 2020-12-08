package lk.usj.OPD_Management.java.dto;

import java.util.Date;

public class AdminDTO extends UserDTO {
    public AdminDTO() {
    }

    public AdminDTO(String username, String password) {
        super(username, password);
    }

    public AdminDTO(String username, String name, String gender, String phoneNumber, String idCard, Date dateOfBirth, String address, String maritalStatus, String password) {
        super(username, name, gender, phoneNumber, idCard, dateOfBirth, address, maritalStatus, password);
    }
}
