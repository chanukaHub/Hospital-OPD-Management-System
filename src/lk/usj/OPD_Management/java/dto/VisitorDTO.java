package lk.usj.OPD_Management.java.dto;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.sql.Time;
import java.util.Date;

public class VisitorDTO {


    private String visitorName;
    private String purpose;
    private String telNo;
    private String nicNo;
    private Date date;
    private Time inTime;
    private Time outTime;
    private String attachment;
    private String notes;


    public VisitorDTO(){}

    public VisitorDTO(String visitorName, String purpose, String telNo, String nicNo, Date date, Time inTime, Time outTime, String attachment, String notes) {
        this.visitorName = visitorName;
        this.purpose = purpose;
        this.telNo = telNo;
        this.nicNo = nicNo;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.attachment = attachment;
        this.notes = notes;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getInTime() {
        return inTime;
    }

    public void setInTime(Time inTime) {
        this.inTime = inTime;
    }

    public Time getOutTime() {
        return outTime;
    }

    public void setOutTime(Time outTime) {
        this.outTime = outTime;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "VisitorDTO{" +
                "visitorName='" + visitorName + '\'' +
                ", purpose='" + purpose + '\'' +
                ", telNo='" + telNo + '\'' +
                ", nicNo='" + nicNo + '\'' +
                ", date=" + date +
                ", inTime=" + inTime +
                ", outTime=" + outTime +
                ", attachment='" + attachment + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}

