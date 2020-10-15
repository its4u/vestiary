package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Templateselection {
    private String templateselectionUuid;
    private String inout;
    private Messagetype messagetypeOfExposedmsg;
    private Messagetype messagetypeOfRelatedmsg;
    private Origindestination originOfExposedmsg;
    private Origindestination destinationOfRelatedmsg;
    private Template relatedTemplate;

    @Id
    @Column(name = "TEMPLATESELECTION_UUID", nullable = false, length = 36)
    public String getTemplateselectionUuid() {
        return templateselectionUuid;
    }

    public void setTemplateselectionUuid(String templateselectionUuid) {
        this.templateselectionUuid = templateselectionUuid;
    }

    @Basic
    @Column(name = "INOUT", nullable = false, length = 3)
    public String getInout() {
        return inout;
    }

    public void setInout(String inout) {
        this.inout = inout;
    }


    @ManyToOne
    @JoinColumn(name = "MSGTYPE_EXPOSEDMSG", referencedColumnName = "MSGTYPE", nullable = false)
    public Messagetype getMessagetypeOfExposedmsg() {
        return messagetypeOfExposedmsg;
    }

    public void setMessagetypeOfExposedmsg(Messagetype messagetypeByMsgtypeExposedmsg) {
        this.messagetypeOfExposedmsg = messagetypeByMsgtypeExposedmsg;
    }

    @ManyToOne
    @JoinColumn(name = "MSGTYPE_RELATEDMSG", referencedColumnName = "MSGTYPE", nullable = false)
    public Messagetype getMessagetypeOfRelatedmsg() {
        return messagetypeOfRelatedmsg;
    }

    public void setMessagetypeOfRelatedmsg(Messagetype messagetypeByMsgtypeRelatedmsg) {
        this.messagetypeOfRelatedmsg = messagetypeByMsgtypeRelatedmsg;
    }

    @ManyToOne
    @JoinColumn(name = "ORIGIN", referencedColumnName = "OD_CODE", nullable = false)
    public Origindestination getOriginOfExposedmsg() {
        return originOfExposedmsg;
    }

    public void setOriginOfExposedmsg(Origindestination origindestinationByOrigin) {
        this.originOfExposedmsg = origindestinationByOrigin;
    }

    @ManyToOne
    @JoinColumn(name = "DESTINATION", referencedColumnName = "OD_CODE", nullable = false)
    public Origindestination getDestinationOfRelatedmsg() {
        return destinationOfRelatedmsg;
    }

    public void setDestinationOfRelatedmsg(Origindestination origindestinationByDestination) {
        this.destinationOfRelatedmsg = origindestinationByDestination;
    }

    @ManyToOne
    @JoinColumn(name = "TEMPLATE_ID", referencedColumnName = "TEMPLATE_ID", nullable = false)
    public Template getRelatedTemplate() {
        return relatedTemplate;
    }

    public void setRelatedTemplate(Template templateByTemplateId) {
        this.relatedTemplate = templateByTemplateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Templateselection that = (Templateselection) o;
        return Objects.equals(templateselectionUuid, that.templateselectionUuid) &&
                Objects.equals(inout, that.inout) &&
                Objects.equals(messagetypeOfExposedmsg, that.messagetypeOfExposedmsg) &&
                Objects.equals(messagetypeOfRelatedmsg, that.messagetypeOfRelatedmsg) &&
                Objects.equals(originOfExposedmsg, that.originOfExposedmsg) &&
                Objects.equals(destinationOfRelatedmsg, that.destinationOfRelatedmsg) &&
                Objects.equals(relatedTemplate, that.relatedTemplate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(templateselectionUuid, inout, messagetypeOfExposedmsg, messagetypeOfRelatedmsg, originOfExposedmsg, destinationOfRelatedmsg, relatedTemplate);
    }
}
