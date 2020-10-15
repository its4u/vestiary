package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Typereferences {
    private String reftype;
    private String description;
    private Collection<Instructionreferences> relatedInstructionReferences;
    private Collection<Messagereferences> relatedMessageReferences;
    private Collection<Referencesparam> relatedReferencesparams;

    @Id
    @Column(name = "REFTYPE", nullable = false, length = 4)
    public String getReftype() {
        return reftype;
    }

    public void setReftype(String reftype) {
        this.reftype = reftype;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = false, length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Typereferences that = (Typereferences) o;
        return Objects.equals(reftype, that.reftype) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reftype, description);
    }

    @OneToMany(mappedBy = "typeReference")
    public Collection<Instructionreferences> getRelatedInstructionReferences() {
        return relatedInstructionReferences;
    }

    public void setRelatedInstructionReferences(Collection<Instructionreferences> instructionreferencesByReftype) {
        this.relatedInstructionReferences = instructionreferencesByReftype;
    }

    @OneToMany(mappedBy = "typeReferences")
    public Collection<Messagereferences> getRelatedMessageReferences() {
        return relatedMessageReferences;
    }

    public void setRelatedMessageReferences(Collection<Messagereferences> messagereferencesByReftype) {
        this.relatedMessageReferences = messagereferencesByReftype;
    }

    @OneToMany(mappedBy = "typeReferences")
    public Collection<Referencesparam> getRelatedReferencesparams() {
        return relatedReferencesparams;
    }

    public void setRelatedReferencesparams(Collection<Referencesparam> referencesparamsByReftype) {
        this.relatedReferencesparams = referencesparamsByReftype;
    }
}
