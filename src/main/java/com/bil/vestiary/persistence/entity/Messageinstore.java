package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
public class Messageinstore {
    private String messageinstoreUuid;
    private Date datetime;
    private String senderBic;
    private String senderDn;
    private String receiverBic;
    private String receiverDn;
    private String swiftServiceType;
    private String relatedMessageUuid;
    private String relatedInstructionUuid;
    private byte[] fullmessage;
    private Collection<Instructioninstore> relatedInstructionInStore;
    private Collection<Instructionoutstore> relatedInstructionOutStore;
    private Collection<Linkmessageinout> relatedLinkMessageInOut;
    private Messagetype messageType;
    private Origindestination origin;
    private Collection<Messagereferences> relatedMessageReferences;
    private Collection<Undressedmessage> relatedUndressedMessages;



    @Id
    @Column(name = "MESSAGEINSTORE_UUID", nullable = false, length = 36)
    public String getMessageinstoreUuid() {
        return messageinstoreUuid;
    }

    public void setMessageinstoreUuid(String messageinstoreUuid) {
        this.messageinstoreUuid = messageinstoreUuid;
    }

    @Basic
    @Column(name = "DATETIME", nullable = false)
    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
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
    @Column(name = "RELATED_MESSAGE_UUID", nullable = true, length = 36)
    public String getRelatedMessageUuid() {
        return relatedMessageUuid;
    }

    public void setRelatedMessageUuid(String relatedMessageUuid) {
        this.relatedMessageUuid = relatedMessageUuid;
    }

    @Basic
    @Column(name = "RELATED_INSTRUCTION_UUID", nullable = true, length = 36)
    public String getRelatedInstructionUuid() {
        return relatedInstructionUuid;
    }

    public void setRelatedInstructionUuid(String relatedInstructionUuid) {
        this.relatedInstructionUuid = relatedInstructionUuid;
    }

    @Basic
    @Column(name = "FULLMESSAGE", nullable = true)
    public byte[] getFullmessage() {
        return fullmessage;
    }

    public void setFullmessage(byte[] fullmessage) {
        this.fullmessage = fullmessage;
    }


    @OneToMany(mappedBy = "messageInStore")
    public Collection<Instructioninstore> getRelatedInstructionInStore() {
        return relatedInstructionInStore;
    }

    public void setRelatedInstructionInStore(Collection<Instructioninstore> instructioninstoresByMessageinstoreUuid) {
        this.relatedInstructionInStore = instructioninstoresByMessageinstoreUuid;
    }

    @OneToMany(mappedBy = "messageInStore")
    public Collection<Instructionoutstore> getRelatedInstructionOutStore() {
        return relatedInstructionOutStore;
    }

    public void setRelatedInstructionOutStore(Collection<Instructionoutstore> instructionoutstoresByMessageinstoreUuid) {
        this.relatedInstructionOutStore = instructionoutstoresByMessageinstoreUuid;
    }

    @OneToMany(mappedBy = "messageIn")
    public Collection<Linkmessageinout> getRelatedLinkMessageInOut() {
        return relatedLinkMessageInOut;
    }

    public void setRelatedLinkMessageInOut(Collection<Linkmessageinout> linkmessageinoutsByMessageinstoreUuid) {
        this.relatedLinkMessageInOut = linkmessageinoutsByMessageinstoreUuid;
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
    @JoinColumn(name = "ORIGIN", referencedColumnName = "OD_CODE", nullable = false)
    public Origindestination getOrigin() {
        return origin;
    }

    public void setOrigin(Origindestination origindestinationByOrigin) {
        this.origin = origindestinationByOrigin;
    }

    @OneToMany(mappedBy = "messageInStore")
    public Collection<Messagereferences> getRelatedMessageReferences() {
        return relatedMessageReferences;
    }

    public void setRelatedMessageReferences(Collection<Messagereferences> messagereferencesByMessageinstoreUuid) {
        this.relatedMessageReferences = messagereferencesByMessageinstoreUuid;
    }

    @OneToMany(mappedBy = "originalMessageInStore")
    public Collection<Undressedmessage> getRelatedUndressedMessages() {
        return relatedUndressedMessages;
    }

    public void setRelatedUndressedMessages(Collection<Undressedmessage> undressedmessagesByMessageinstoreUuid) {
        this.relatedUndressedMessages = undressedmessagesByMessageinstoreUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Messageinstore that = (Messageinstore) o;
        return Objects.equals(messageinstoreUuid, that.messageinstoreUuid) &&
                Objects.equals(datetime, that.datetime) &&
                Objects.equals(senderBic, that.senderBic) &&
                Objects.equals(senderDn, that.senderDn) &&
                Objects.equals(receiverBic, that.receiverBic) &&
                Objects.equals(receiverDn, that.receiverDn) &&
                Objects.equals(swiftServiceType, that.swiftServiceType) &&
                Objects.equals(relatedMessageUuid, that.relatedMessageUuid) &&
                Objects.equals(relatedInstructionUuid, that.relatedInstructionUuid) &&
                Arrays.equals(fullmessage, that.fullmessage) &&
                Objects.equals(relatedInstructionInStore, that.relatedInstructionInStore) &&
                Objects.equals(relatedInstructionOutStore, that.relatedInstructionOutStore) &&
                Objects.equals(relatedLinkMessageInOut, that.relatedLinkMessageInOut) &&
                Objects.equals(messageType, that.messageType) &&
                Objects.equals(origin, that.origin) &&
                Objects.equals(relatedMessageReferences, that.relatedMessageReferences) &&
                Objects.equals(relatedUndressedMessages, that.relatedUndressedMessages);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(messageinstoreUuid, datetime, senderBic, senderDn, receiverBic, receiverDn, swiftServiceType, relatedMessageUuid, relatedInstructionUuid, relatedInstructionInStore, relatedInstructionOutStore, relatedLinkMessageInOut, messageType, origin, relatedMessageReferences, relatedUndressedMessages);
        result = 31 * result + Arrays.hashCode(fullmessage);
        return result;
    }
}
