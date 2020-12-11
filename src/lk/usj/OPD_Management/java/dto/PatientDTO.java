package lk.usj.OPD_Management.java.dto;

import java.util.Date;

public class PatientDTO extends UserDTO{
    private String bloodGroup;
    private String allergies;
    private String note;

    public PatientDTO() {
    }

    public PatientDTO(String username, String password) {
        super(username, password);
    }

    public PatientDTO(String username, String name, String gender, String phoneNumber, String idCard, Date dateOfBirth, String address, String maritalStatus, String password, String bloodGroup, String allergies, String note) {
        super(username, name, gender, phoneNumber, idCard, dateOfBirth, address, maritalStatus, password);
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.note = note;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "bloodGroup='" + bloodGroup + '\'' +
                ", allergies='" + allergies + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
