package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Referencesparam {
    private String refparamUuid;
    private String reflevel;
    private String refpath;
    private Messagetype messageType;
    private Typereferences typeReferences;

    @Id
    @Column(name = "REFPARAM_UUID", nullable = false, length = 36)
    public String getRefparamUuid() {
        return refparamUuid;
    }

    public void setRefparamUuid(String refparamUuid) {
        this.refparamUuid = refparamUuid;
    }

    @Basic
    @Column(name = "REFLEVEL", nullable = false, length = 3)
    public String getReflevel() {
        return reflevel;
    }

    public void setReflevel(String reflevel) {
        this.reflevel = reflevel;
    }

    @Basic
    @Column(name = "REFPATH", nullable = false, length = 100)
    public String getRefpath() {
        return refpath;
    }

    public void setRefpath(String refpath) {
        this.refpath = refpath;
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
    @JoinColumn(name = "REFTYPE", referencedColumnName = "REFTYPE", nullable = false)
    public Typereferences getTypeReferences() {
        return typeReferences;
    }

    public void setTypeReferences(Typereferences typereferencesByReftype) {
        this.typeReferences = typereferencesByReftype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Referencesparam that = (Referencesparam) o;
        return Objects.equals(refparamUuid, that.refparamUuid) &&
                Objects.equals(reflevel, that.reflevel) &&
                Objects.equals(refpath, that.refpath) &&
                Objects.equals(messageType, that.messageType) &&
                Objects.equals(typeReferences, that.typeReferences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refparamUuid, reflevel, refpath, messageType, typeReferences);
    }
}
