package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@XmlRootElement
@Entity
public class Template {
    private String templateId;
    private String templateName;
    private byte[] fulltemplate;
    private Collection<Messageoutstore> relatedMessagesOutStore;
    private Messagetype messageType;
    private Collection<Templateselection> relatedTemplateSelection;
    private Collection<Undressedmessage> relatedUndressedMessages;

    @Id
    @Column(name = "TEMPLATE_ID", nullable = false, length = 50)
    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    @Basic
    @Column(name = "TEMPLATE_NAME", nullable = true, length = 50)
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }


    @Basic
    @Column(name = "FULLTEMPLATE", nullable = true)
    public byte[] getFulltemplate() {
        return fulltemplate;
    }

    public void setFulltemplate(byte[] fulltemplate) {
        this.fulltemplate = fulltemplate;
    }

    @OneToMany(mappedBy = "template")
    public Collection<Messageoutstore> getRelatedMessagesOutStore() {
        return relatedMessagesOutStore;
    }

    public void setRelatedMessagesOutStore(Collection<Messageoutstore> messageoutstoresByTemplateId) {
        this.relatedMessagesOutStore = messageoutstoresByTemplateId;
    }

    @ManyToOne
    @JoinColumn(name = "MSGTYPE", referencedColumnName = "MSGTYPE")
    public Messagetype getMessageType() {
        return messageType;
    }

    public void setMessageType(Messagetype messagetypeByMsgtype) {
        this.messageType = messagetypeByMsgtype;
    }

    @OneToMany(mappedBy = "relatedTemplate")
    public Collection<Templateselection> getRelatedTemplateSelection() {
        return relatedTemplateSelection;
    }

    public void setRelatedTemplateSelection(Collection<Templateselection> templateselectionsByTemplateId) {
        this.relatedTemplateSelection = templateselectionsByTemplateId;
    }

    @OneToMany(mappedBy = "relatedTemplate")
    public Collection<Undressedmessage> getRelatedUndressedMessages() {
        return relatedUndressedMessages;
    }

    public void setRelatedUndressedMessages(Collection<Undressedmessage> undressedmessagesByTemplateId) {
        this.relatedUndressedMessages = undressedmessagesByTemplateId;
    }

    public Template() {
    }

    public Template(String templateId) {
        this.templateId = templateId;
    }

    public Template(String templateId, String templateName) {
        this.templateId = templateId;
        this.templateName = templateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Template template = (Template) o;
        return Objects.equals(templateId, template.templateId) &&
                Objects.equals(templateName, template.templateName) &&
                Arrays.equals(fulltemplate, template.fulltemplate) &&
                Objects.equals(relatedMessagesOutStore, template.relatedMessagesOutStore) &&
                Objects.equals(messageType, template.messageType) &&
                Objects.equals(relatedTemplateSelection, template.relatedTemplateSelection) &&
                Objects.equals(relatedUndressedMessages, template.relatedUndressedMessages);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(templateId, templateName, relatedMessagesOutStore, messageType, relatedTemplateSelection, relatedUndressedMessages);
        result = 31 * result + Arrays.hashCode(fulltemplate);
        return result;
    }
}
