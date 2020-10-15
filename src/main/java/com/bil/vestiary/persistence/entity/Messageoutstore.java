package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Messageoutstore {
    private String messageoutstoreUuid;
    private Time datetime;
    private String senderBic;
    private String senderDn;
    private String receiverBic;
    private String receiverDn;
    private String swiftServiceType;
    private byte[] fullmessage;
    private Collection<Linkmessageinout> relatedLinkMessageInOut;
    private Messagetype messageType;
    private Template template;
    private Origindestination destination;
    private System systemDestination;

    @Id
    @Column(name = "MESSAGEOUTSTORE_UUID", nullable = false, length = 36)
    public String getMessageoutstoreUuid() {
        return messageoutstoreUuid;
    }

    public void setMessageoutstoreUuid(String messageoutstoreUuid) {
        this.messageoutstoreUuid = messageoutstoreUuid;
    }

    @Basic
    @Column(name = "DATETIME", nullable = false)
    public Time getDatetime() {
        return datetime;
    }

    public void setDatetime(Time datetime) {
        this.datetime = datetime;
    }

    @Basic
    @Column(name = "SENDER_BIC", nullable = true, length = 11)
    public String getSenderBic() {
        return senderBic;
    }

    public void setSenderBic(String senderBic) {
        this.senderBic = senderBic;
    }

    @Basic
    @Column(name = "SENDER_DN", nullable = true, length = 20)
    public String getSenderDn() {
        return senderDn;
    }

    public void setSenderDn(String senderDn) {
        this.senderDn = senderDn;
    }

    @Basic
    @Column(name = "RECEIVER_BIC", nullable = true, length = 11)
    public String getReceiverBic() {
        return receiverBic;
    }

    public void setReceiverBic(String receiverBic) {
        this.receiverBic = receiverBic;
    }

    @Basic
    @Column(name = "RECEIVER_DN", nullable = true, length = 20)
    public String getReceiverDn() {
        return receiverDn;
    }

    public void setReceiverDn(String receiverDn) {
        this.receiverDn = receiverDn;
    }

    @Basic
    @Column(name = "SWIFT_SERVICE_TYPE", nullable = true, length = 20)
    public String getSwiftServiceType() {
        return swiftServiceType;
    }

    public void setSwiftServiceType(String swiftServiceType) {
        this.swiftServiceType = swiftServiceType;
    }



    @Basic
    @Column(name = "FULLMESSAGE", nullable = false)
    public byte[] getFullmessage() {
        return fullmessage;
    }

    public void setFullmessage(byte[] fullmessage) {
        this.fullmessage = fullmessage;
    }



    @OneToMany(mappedBy = "messageOut")
    public Collection<Linkmessageinout> getRelatedLinkMessageInOut() {
        return relatedLinkMessageInOut;
    }

    public void setRelatedLinkMessageInOut(Collection<Linkmessageinout> linkmessageinoutsByMessageoutstoreUuid) {
        this.relatedLinkMessageInOut = linkmessageinoutsByMessageoutstoreUuid;
    }

    @ManyToOne
    @JoinColumn(name = "MSGTYPE", referencedColumnName = "MSGTYPE", nullable = false)
    public Messagetype getMessageType() {
        return messageType;
    }

    public void setMessageType(Messagetype messagetypeByMsgtype) {
        this.messageType = messagetypeByMsgtype;
    }

    @ManyToOne
    @JoinColumn(name = "TEMPLATE_ID", referencedColumnName = "TEMPLATE_ID", nullable = false)
    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template templateByTemplateId) {
        this.template = templateByTemplateId;
    }

    @ManyToOne
    @JoinColumn(name = "DESTINATION", referencedColumnName = "OD_CODE", nullable = false)
    public Origindestination getDestination() {
        return destination;
    }

    public void setDestination(Origindestination origindestinationByDestination) {
        this.destination = origindestinationByDestination;
    }

    @ManyToOne
    @JoinColumn(name = "SYSTEM", referencedColumnName = "SYSTEM", nullable = false)
    public System getSystemDestination() {
        return systemDestination;
    }

    public void setSystemDestination(System systemBySystem) {
        this.systemDestination = systemBySystem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Messageoutstore that = (Messageoutstore) o;
        return Objects.equals(messageoutstoreUuid, that.messageoutstoreUuid) &&
                Objects.equals(datetime, that.datetime) &&
                Objects.equals(senderBic, that.senderBic) &&
                Objects.equals(senderDn, that.senderDn) &&
                Objects.equals(receiverBic, that.receiverBic) &&
                Objects.equals(receiverDn, that.receiverDn) &&
                Objects.equals(swiftServiceType, that.swiftServiceType) &&
                Arrays.equals(fullmessage, that.fullmessage) &&
                Objects.equals(relatedLinkMessageInOut, that.relatedLinkMessageInOut) &&
                Objects.equals(messageType, that.messageType) &&
                Objects.equals(template, that.template) &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(systemDestination, that.systemDestination);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(messageoutstoreUuid, datetime, senderBic, senderDn, receiverBic, receiverDn, swiftServiceType, relatedLinkMessageInOut, messageType, template, destination, systemDestination);
        result = 31 * result + Arrays.hashCode(fullmessage);
        return result;
    }
}
