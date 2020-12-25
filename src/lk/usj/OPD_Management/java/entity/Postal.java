package lk.usj.OPD_Management.java.entity;

import java.util.Date;

public class Postal {
    private String referenceNumber;
    private String fromAddress;
    private String toAddress;
    private String fromName;
    private String toName;
    private Date postalDate;
    private String attachment;
    private String notes;
    private String type;

    public Postal() {

    }

    public Postal(String referenceNumber, String fromAddress, String toAddress, String fromName, String toName, Date postalDate, String attachment, String notes, String type) {
        this.referenceNumber = referenceNumber;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.fromName = fromName;
        this.toName = toName;
        this.postalDate = postalDate;
        this.attachment = attachment;
        this.notes = notes;
        this.type = type;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public Date getPostalDate() {
        return postalDate;
    }

    public void setPostalDate(Date postalDate) {
        this.postalDate = postalDate;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Postal{" +
                "referenceNumber='" + referenceNumber + '\'' +
                ", fromAddress='" + fromAddress + '\'' +
                ", toAddress='" + toAddress + '\'' +
                ", fromName='" + fromName + '\'' +
                ", toName='" + toName + '\'' +
                ", postalDate=" + postalDate +
                ", attachment='" + attachment + '\'' +
                ", notes='" + notes + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
