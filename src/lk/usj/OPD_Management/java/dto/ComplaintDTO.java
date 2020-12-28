package lk.usj.OPD_Management.java.dto;

import java.util.Date;

public class ComplaintDTO {

    private String complaintId;
    private String type;
    private String complaintBy;
    private String phoneNumber;
    private Date date;
    private String description;
    private String actionTaken;
    private String note;
    private String attachDocument;
    private String status;

    public ComplaintDTO() {
    }

    public ComplaintDTO(String complaintId, String type, String complaintBy, String phoneNumber, Date date, String description, String actionTaken, String note, String attachDocument, String status) {
        this.complaintId = complaintId;
        this.type = type;
        this.complaintBy = complaintBy;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.description = description;
        this.actionTaken = actionTaken;
        this.note = note;
        this.attachDocument = attachDocument;
        this.status = status;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComplaintBy() {
        return complaintBy;
    }

    public void setComplaintBy(String complaintBy) {
        this.complaintBy = complaintBy;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAttachDocument() {
        return attachDocument;
    }

    public void setAttachDocument(String attachDocument) {
        this.attachDocument = attachDocument;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ComplaintDTO{" +
                "complaintId='" + complaintId + '\'' +
                ", type='" + type + '\'' +
                ", complaintBy='" + complaintBy + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", actionTaken='" + actionTaken + '\'' +
                ", note='" + note + '\'' +
                ", attachDocument='" + attachDocument + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
