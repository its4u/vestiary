package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Instructioninstore {
    private String instructioninstoreUuid;
    private String relatedMessageUuid;
    private String relatedInstructionUuid;
    private byte[] fullInstruction;
    private Messageinstore messageInStore;
    private Collection<Instructionreferences> relatedInstructionReferences;
    private Collection<Linkinstructioninout> relatedInstructionInOut;

    @Id
    @Column(name = "INSTRUCTIONINSTORE_UUID", nullable = false, length = 36)
    public String getInstructioninstoreUuid() {
        return instructioninstoreUuid;
    }

    public void setInstructioninstoreUuid(String instructioninstoreUuid) {
        this.instructioninstoreUuid = instructioninstoreUuid;
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
    @Column(name = "FULL_INSTRUCTION", nullable = true)
    public byte[] getFullInstruction() {
        return fullInstruction;
    }

    public void setFullInstruction(byte[] fullInstruction) {
        this.fullInstruction = fullInstruction;
    }

    @ManyToOne
    @JoinColumn(name = "MESSAGE_UUID", referencedColumnName = "MESSAGEINSTORE_UUID", nullable = false)
    public Messageinstore getMessageInStore() {
        return messageInStore;
    }

    public void setMessageInStore(Messageinstore messageinstoreByMessageUuid) {
        this.messageInStore = messageinstoreByMessageUuid;
    }

    @OneToMany(mappedBy = "instructionInStore")
    public Collection<Instructionreferences> getRelatedInstructionReferences() {
        return relatedInstructionReferences;
    }

    public void setRelatedInstructionReferences(Collection<Instructionreferences> instructionreferencesByInstructioninstoreUuid) {
        this.relatedInstructionReferences = instructionreferencesByInstructioninstoreUuid;
    }

    @OneToMany(mappedBy = "relatedInstructionsInStore")
    public Collection<Linkinstructioninout> getRelatedInstructionInOut() {
        return relatedInstructionInOut;
    }

    public void setRelatedInstructionInOut(Collection<Linkinstructioninout> linkinstructioninoutsByInstructioninstoreUuid) {
        this.relatedInstructionInOut = linkinstructioninoutsByInstructioninstoreUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructioninstore that = (Instructioninstore) o;
        return Objects.equals(instructioninstoreUuid, that.instructioninstoreUuid) &&
                Objects.equals(relatedMessageUuid, that.relatedMessageUuid) &&
                Objects.equals(relatedInstructionUuid, that.relatedInstructionUuid) &&
                Arrays.equals(fullInstruction, that.fullInstruction) &&
                Objects.equals(messageInStore, that.messageInStore) &&
                Objects.equals(relatedInstructionReferences, that.relatedInstructionReferences) &&
                Objects.equals(relatedInstructionInOut, that.relatedInstructionInOut);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(instructioninstoreUuid, relatedMessageUuid, relatedInstructionUuid, messageInStore, relatedInstructionReferences, relatedInstructionInOut);
        result = 31 * result + Arrays.hashCode(fullInstruction);
        return result;
    }
}
