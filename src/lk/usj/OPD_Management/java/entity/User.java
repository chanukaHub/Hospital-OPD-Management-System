package lk.usj.OPD_Management.java.entity;

import java.util.Date;

public abstract class User {
    private String username;
    private String name;
    private String gender;
    private String phoneNumber;
    private String idCard;
    private Date dateOfBirth;
    private String Address;
    private String maritalStatus;
    private String password;

    public User() {
    }

    public User(String username, String name, String gender, String phoneNumber, String idCard, Date dateOfBirth, String address, String maritalStatus, String password) {
        this.username = username;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.idCard = idCard;
        this.dateOfBirth = dateOfBirth;
        Address = address;
        this.maritalStatus = maritalStatus;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", idCard='" + idCard + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", Address='" + Address + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
