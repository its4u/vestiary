package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Messagetype {
    private String msgtype;
    private String description;
    private String relatedidpath;
    private String reportingindicator;
    private String instructionpath;
    private String instructiondetails;
    private Collection<Messageinstore> relatedMessageInStore;
    private Collection<Messageoutstore> relatedMessageOutStore;
    private Collection<Referencesparam> relatedReferencesParam;
    private Collection<Template> relatedTemplates;

    @Id
    @Column(name = "MSGTYPE", nullable = false, length = 15)
    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "RELATEDIDPATH", nullable = false, length = 100)
    public String getRelatedidpath() {
        return relatedidpath;
    }

    public void setRelatedidpath(String relatedidpath) {
        this.relatedidpath = relatedidpath;
    }

    @Basic
    @Column(name = "REPORTINGINDICATOR", nullable = true, length = 1)
    public String getReportingindicator() {
        return reportingindicator;
    }

    public void setReportingindicator(String reportingindicator) {
        this.reportingindicator = reportingindicator;
    }

    @Basic
    @Column(name = "INSTRUCTIONPATH", nullable = true, length = 100)
    public String getInstructionpath() {
        return instructionpath;
    }

    public void setInstructionpath(String instructionpath) {
        this.instructionpath = instructionpath;
    }

    @Basic
    @Column(name = "INSTRUCTIONDETAILS", nullable = true, length = 100)
    public String getInstructiondetails() {
        return instructiondetails;
    }

    public void setInstructiondetails(String instructiondetails) {
        this.instructiondetails = instructiondetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Messagetype that = (Messagetype) o;
        return Objects.equals(msgtype, that.msgtype) &&
                Objects.equals(description, that.description) &&
                Objects.equals(relatedidpath, that.relatedidpath) &&
                Objects.equals(reportingindicator, that.reportingindicator) &&
                Objects.equals(instructionpath, that.instructionpath) &&
                Objects.equals(instructiondetails, that.instructiondetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(msgtype, description, relatedidpath, reportingindicator, instructionpath, instructiondetails);
    }

    @OneToMany(mappedBy = "messageType")
    public Collection<Messageinstore> getRelatedMessageInStore() {
        return relatedMessageInStore;
    }

    public void setRelatedMessageInStore(Collection<Messageinstore> messageinstoresByMsgtype) {
        this.relatedMessageInStore = messageinstoresByMsgtype;
    }

    @OneToMany(mappedBy = "messageType")
    public Collection<Messageoutstore> getRelatedMessageOutStore() {
        return relatedMessageOutStore;
    }

    public void setRelatedMessageOutStore(Collection<Messageoutstore> messageoutstoresByMsgtype) {
        this.relatedMessageOutStore = messageoutstoresByMsgtype;
    }

    @OneToMany(mappedBy = "messageType")
    public Collection<Referencesparam> getRelatedReferencesParam() {
        return relatedReferencesParam;
    }

    public void setRelatedReferencesParam(Collection<Referencesparam> referencesparamsByMsgtype) {
        this.relatedReferencesParam = referencesparamsByMsgtype;
    }

    @OneToMany(mappedBy = "messageType")
    public Collection<Template> getRelatedTemplates() {
        return relatedTemplates;
    }

    public void setRelatedTemplates(Collection<Template> templatesByMsgtype) {
        this.relatedTemplates = templatesByMsgtype;
    }


}
