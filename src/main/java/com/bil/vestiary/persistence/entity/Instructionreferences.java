package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Instructionreferences {
    private String instructionreferencesUuid;
    private String linkreference;
    private Typereferences typeReference;
    private Instructioninstore instructionInStore;

    @Id
    @Column(name = "INSTRUCTIONREFERENCES_UUID", nullable = false, length = 36)
    public String getInstructionreferencesUuid() {
        return instructionreferencesUuid;
    }

    public void setInstructionreferencesUuid(String instructionreferencesUuid) {
        this.instructionreferencesUuid = instructionreferencesUuid;
    }

    @Basic
    @Column(name = "LINKREFERENCE", nullable = false, length = 36)
    public String getLinkreference() {
        return linkreference;
    }

    public void setLinkreference(String linkreference) {
        this.linkreference = linkreference;
    }


    @ManyToOne
    @JoinColumn(name = "REFTYPE", referencedColumnName = "REFTYPE", nullable = false)
    public Typereferences getTypeReference() {
        return typeReference;
    }

    public void setTypeReference(Typereferences typereferencesByReftype) {
        this.typeReference = typereferencesByReftype;
    }

    @ManyToOne
    @JoinColumn(name = "INSTRUCTIONINSTORE_UUID", referencedColumnName = "INSTRUCTIONINSTORE_UUID", nullable = false)
    public Instructioninstore getInstructionInStore() {
        return instructionInStore;
    }

    public void setInstructionInStore(Instructioninstore instructioninstoreByInstructioninstoreUuid) {
        this.instructionInStore = instructioninstoreByInstructioninstoreUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructionreferences that = (Instructionreferences) o;
        return Objects.equals(instructionreferencesUuid, that.instructionreferencesUuid) &&
                Objects.equals(linkreference, that.linkreference) &&
                Objects.equals(typeReference, that.typeReference) &&
                Objects.equals(instructionInStore, that.instructionInStore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructionreferencesUuid, linkreference, typeReference, instructionInStore);
    }
}
