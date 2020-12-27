package lk.usj.OPD_Management.java.entity;

import java.util.Date;

public class Login {
    private String userName;
    private String name;
    private Date loginDateTime;
    private String userType;

    public Login() {
    }

    public Login(String userName, String name, Date loginDateTime, String userType) {
        this.userName = userName;
        this.name = name;
        this.loginDateTime = loginDateTime;
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(Date loginDateTime) {
        this.loginDateTime = loginDateTime;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "Login{" +
                "userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", loginDateTime=" + loginDateTime +
                ", userType='" + userType + '\'' +
                '}';
    }
}
