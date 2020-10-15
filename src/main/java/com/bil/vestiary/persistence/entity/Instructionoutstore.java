package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Instructionoutstore {
    private String instructionoutstoreuuid;
    private String fillingruleId;
    private byte[] fullinstruction;
    private Messageinstore messageInStore;
    private Collection<Linkinstructioninout> relatedLinInstructionInOut;

    @Id
    @Column(name = "INSTRUCTIONOUTSTOREUUID", nullable = false, length = 36)
    public String getInstructionoutstoreuuid() {
        return instructionoutstoreuuid;
    }

    public void setInstructionoutstoreuuid(String instructionoutstoreuuid) {
        this.instructionoutstoreuuid = instructionoutstoreuuid;
    }

    @Basic
    @Column(name = "FILLINGRULE_ID", nullable = true, length = 20)
    public String getFillingruleId() {
        return fillingruleId;
    }

    public void setFillingruleId(String fillingruleId) {
        this.fillingruleId = fillingruleId;
    }

    @Basic
    @Column(name = "FULLINSTRUCTION", nullable = true)
    public byte[] getFullinstruction() {
        return fullinstruction;
    }

    public void setFullinstruction(byte[] fullinstruction) {
        this.fullinstruction = fullinstruction;
    }

    @ManyToOne
    @JoinColumn(name = "MESSAGEINSTORE_UUID", referencedColumnName = "MESSAGEINSTORE_UUID", nullable = false)
    public Messageinstore getMessageInStore() {
        return messageInStore;
    }

    public void setMessageInStore(Messageinstore messageinstoreByMessageinstoreUuid) {
        this.messageInStore = messageinstoreByMessageinstoreUuid;
    }

    @OneToMany(mappedBy = "relatedInstructionsOutStore")
    public Collection<Linkinstructioninout> getRelatedLinInstructionInOut() {
        return relatedLinInstructionInOut;
    }

    public void setRelatedLinInstructionInOut(Collection<Linkinstructioninout> linkinstructioninoutsByInstructionoutstoreuuid) {
        this.relatedLinInstructionInOut = linkinstructioninoutsByInstructionoutstoreuuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructionoutstore that = (Instructionoutstore) o;
        return Objects.equals(instructionoutstoreuuid, that.instructionoutstoreuuid) &&
                Objects.equals(fillingruleId, that.fillingruleId) &&
                Arrays.equals(fullinstruction, that.fullinstruction) &&
                Objects.equals(messageInStore, that.messageInStore) &&
                Objects.equals(relatedLinInstructionInOut, that.relatedLinInstructionInOut);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(instructionoutstoreuuid, fillingruleId, messageInStore, relatedLinInstructionInOut);
        result = 31 * result + Arrays.hashCode(fullinstruction);
        return result;
    }
}
