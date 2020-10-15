package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Linkinstructioninout {
    private String linkinstructionUuid;
    private Instructioninstore relatedInstructionsInStore;
    private Instructionoutstore relatedInstructionsOutStore;

    @Id
    @Column(name = "LINKINSTRUCTION_UUID", nullable = false, length = 36)
    public String getLinkinstructionUuid() {
        return linkinstructionUuid;
    }

    public void setLinkinstructionUuid(String linkinstructionUuid) {
        this.linkinstructionUuid = linkinstructionUuid;
    }


    @ManyToOne
    @JoinColumn(name = "INSTRUCTIONINSTORE_UUID", referencedColumnName = "INSTRUCTIONINSTORE_UUID", nullable = false)
    public Instructioninstore getRelatedInstructionsInStore() {
        return relatedInstructionsInStore;
    }

    public void setRelatedInstructionsInStore(Instructioninstore instructioninstoreByInstructioninstoreUuid) {
        this.relatedInstructionsInStore = instructioninstoreByInstructioninstoreUuid;
    }

    @ManyToOne
    @JoinColumn(name = "INSTRUCTIONOUTSTORE_UUID", referencedColumnName = "INSTRUCTIONOUTSTOREUUID", nullable = false)
    public Instructionoutstore getRelatedInstructionsOutStore() {
        return relatedInstructionsOutStore;
    }

    public void setRelatedInstructionsOutStore(Instructionoutstore instructionoutstoreByInstructionoutstoreUuid) {
        this.relatedInstructionsOutStore = instructionoutstoreByInstructionoutstoreUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linkinstructioninout that = (Linkinstructioninout) o;
        return Objects.equals(linkinstructionUuid, that.linkinstructionUuid) &&
                Objects.equals(relatedInstructionsInStore, that.relatedInstructionsInStore) &&
                Objects.equals(relatedInstructionsOutStore, that.relatedInstructionsOutStore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkinstructionUuid, relatedInstructionsInStore, relatedInstructionsOutStore);
    }
}
