package com.bil.vestiary.persistence.entity;

public class StoreMessageResponse {

    private String uuidMessage;

    private String uuidUndressedMessage;

    private String reasonStatus;

    private String reasonCode;

    public StoreMessageResponse(String uuidMessage, String uuidUndressedMessage, String reasonStatus, String reasonCode) {
        this.uuidMessage = uuidMessage;
        this.uuidUndressedMessage = uuidUndressedMessage;
        this.reasonStatus = reasonStatus;
        this.reasonCode = reasonCode;
    }

    public String getUuidMessage() {
        return uuidMessage;
    }

    public void setUuidMessage(String uuidMessage) {
        this.uuidMessage = uuidMessage;
    }

    public String getUuidUndressedMessage() {
        return uuidUndressedMessage;
    }

    public void setUuidUndressedMessage(String uuidUndressedMessage) {
        this.uuidUndressedMessage = uuidUndressedMessage;
    }

    public String getReasonStatus() {
        return reasonStatus;
    }

    public void setReasonStatus(String reasonStatus) {
        this.reasonStatus = reasonStatus;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }
}
