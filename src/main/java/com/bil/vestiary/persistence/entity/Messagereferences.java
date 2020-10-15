package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Messagereferences {
    private String messagereferenceUuid;
    private String linkreference;
    private Typereferences typeReferences;
    private Messageinstore messageInStore;

    @Id
    @Column(name = "MESSAGEREFERENCE_UUID", nullable = false, length = 36)
    public String getMessagereferenceUuid() {
        return messagereferenceUuid;
    }

    public void setMessagereferenceUuid(String messagereferenceUuid) {
        this.messagereferenceUuid = messagereferenceUuid;
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
    public Typereferences getTypeReferences() {
        return typeReferences;
    }

    public void setTypeReferences(Typereferences typereferencesByReftype) {
        this.typeReferences = typereferencesByReftype;
    }

    @ManyToOne
    @JoinColumn(name = "MESSAGEINSTORE_UUID", referencedColumnName = "MESSAGEINSTORE_UUID", nullable = false)
    public Messageinstore getMessageInStore() {
        return messageInStore;
    }

    public void setMessageInStore(Messageinstore messageinstoreByMessageinstoreUuid) {
        this.messageInStore = messageinstoreByMessageinstoreUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Messagereferences that = (Messagereferences) o;
        return Objects.equals(messagereferenceUuid, that.messagereferenceUuid) &&
                Objects.equals(linkreference, that.linkreference) &&
                Objects.equals(typeReferences, that.typeReferences) &&
                Objects.equals(messageInStore, that.messageInStore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messagereferenceUuid, linkreference, typeReferences, messageInStore);
    }
}
