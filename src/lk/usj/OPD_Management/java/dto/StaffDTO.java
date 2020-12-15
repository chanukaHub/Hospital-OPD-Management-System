package lk.usj.OPD_Management.java.dto;

import java.util.Date;

public abstract class StaffDTO extends UserDTO{
    private int staffID;
    private String staffEmail;
    private Date dateOfJoin;
    private String photograph;
    private String document;
    private String note;

    public StaffDTO() {
    }

    public StaffDTO(String username, String password) {
        super(username, password);
    }

    public StaffDTO(String username, String name, String gender, String phoneNumber, String idCard, Date dateOfBirth, String address, String maritalStatus, String password, int staffID, String staffEmail, Date dateOfJoin, String photograph, String document, String note) {
        super(username, name, gender, phoneNumber, idCard, dateOfBirth, address, maritalStatus, password);
        this.staffID = staffID;
        this.staffEmail = staffEmail;
        this.dateOfJoin = dateOfJoin;
        this.photograph = photograph;
        this.document = document;
        this.note = note;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public String getPhotograph() {
        return photograph;
    }

    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "StaffDTO{" +
                "staffID='" + staffID + '\'' +
                ", staffEmail='" + staffEmail + '\'' +
                ", dateOfJoin=" + dateOfJoin +
                ", photograph='" + photograph + '\'' +
                ", document='" + document + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
