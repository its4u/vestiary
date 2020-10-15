package com.bil.vestiary.persistence.entity;

public class MxMessageMetadata {

    private String msgType;

    private String origin;

    public MxMessageMetadata(String msgType, String origin) {
        this.msgType = msgType;
        this.origin = origin;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
