package lk.usj.OPD_Management.java.dto;


import javafx.stage.FileChooser;

import javax.swing.*;

public class VisitorDTO {
    //Purpose, Name, Phone, ID Card Number of Person, Date, In Time, Out Time, Note
    //Attached Document

    private String visitorName;
    private String purpose;
    private String telNo;
    private String nicNo;
    private String visitDay;
    private String visitMonth;
    private String visitYear;
    private String inTimeHour;
    private String inTimeMinutes;
    private String inTimeAMPM;
    private String outTimeHour;
    private String outTimeMinutes;
    private String outTimeAMPM;
    private JFileChooser attachment;
    private String notes;
    private FileChooser fileChooser;


    public VisitorDTO(){}

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

    public String getVisitDay() {
        return visitDay;
    }

    public void setVisitDay(String visitDay) {
        this.visitDay = visitDay;
    }

    public String getVisitMonth() {
        return visitMonth;
    }

    public void setVisitMonth(String visitMonth) {
        this.visitMonth = visitMonth;
    }

    public String getVisitYear() {
        return visitYear;
    }

    public void setVisitYear(String visitYear) {
        this.visitYear = visitYear;
    }

    public String getInTimeHour() {
        return inTimeHour;
    }

    public void setInTimeHour(String inTimeHour) {
        this.inTimeHour = inTimeHour;
    }

    public String getInTimeMinutes() {
        return inTimeMinutes;
    }

    public void setInTimeMinutes(String inTimeMinutes) {
        this.inTimeMinutes = inTimeMinutes;
    }

    public String getInTimeAMPM() {
        return inTimeAMPM;
    }

    public void setInTimeAMPM(String inTimeAMPM) {
        this.inTimeAMPM = inTimeAMPM;
    }

    public String getOutTimeHour() {
        return outTimeHour;
    }

    public void setOutTimeHour(String outTimeHour) {
        this.outTimeHour = outTimeHour;
    }

    public String getOutTimeMinutes() {
        return outTimeMinutes;
    }

    public void setOutTimeMinutes(String outTimeMinutes) {
        this.outTimeMinutes = outTimeMinutes;
    }

    public String getOutTimeAMPM() {
        return outTimeAMPM;
    }

    public void setOutTimeAMPM(String outTimeAMPM) {
        this.outTimeAMPM = outTimeAMPM;
    }

    public boolean getAttachment() {
        return fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));
    }

    public void setAttachment(String attachment) {
//        this.attachment = attachment;
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
                ", visitDay='" + visitDay + '\'' +
                ", visitMonth='" + visitMonth + '\'' +
                ", visitYear='" + visitYear + '\'' +
                ", inTimeHour='" + inTimeHour + '\'' +
                ", inTimeMinutes='" + inTimeMinutes + '\'' +
                ", inTimeAMPM='" + inTimeAMPM + '\'' +
                ", outTimeHour='" + outTimeHour + '\'' +
                ", outTimeMinutes='" + outTimeMinutes + '\'' +
                ", outTimeAMPM='" + outTimeAMPM + '\'' +
                ", attachment='" + attachment + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}

