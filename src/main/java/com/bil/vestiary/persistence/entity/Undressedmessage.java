package com.bil.vestiary.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
public class Undressedmessage {
    private String undressedmessageUuid;
    private byte[] fullUndressedMessage;
    private String originalMessageInStoreUuid;
    private Messageinstore originalMessageInStore;
    private Template relatedTemplate;
    private String relatedTemplateId;


    @Id
    @Column(name = "UNDRESSEDMESSAGE_UUID", nullable = false, length = 36)
    public String getUndressedmessageUuid() {
        return undressedmessageUuid;
    }

    public void setUndressedmessageUuid(String undressedmessageUuid) {
        this.undressedmessageUuid = undressedmessageUuid;
    }

    @Basic
    @Column(name = "TEMPLATE_ID")
    public String getRelatedTemplateId() {
        return relatedTemplateId;
    }

    public void setRelatedTemplateId(String templateID) {
        this.relatedTemplateId = templateID;
    }

    @Basic
    @Column(name = "MESSAGEINSTORE_UUID", nullable = false)
    public String getOriginalMessageInStoreUuid() { return this.originalMessageInStoreUuid;}

    public void setOriginalMessageInStoreUuid(String messageinstoreUuid) {
        this.originalMessageInStoreUuid = messageinstoreUuid;
    }

    @Basic
    @Column(name = "FULL_UNDRESSED_MESSAGE", nullable = false)
    @JsonIgnore
    @JsonProperty(value = "fullUndressedMessage")
    public byte[] getFullUndressedMessage() {
        return fullUndressedMessage;
    }

    public void setFullUndressedMessage(byte[] fullUndressedMessage) {
        this.fullUndressedMessage = fullUndressedMessage;
    }

    @ManyToOne
    @JoinColumn(name = "MESSAGEINSTORE_UUID", referencedColumnName = "MESSAGEINSTORE_UUID", nullable = false, insertable = false, updatable =  false)
    @JsonIgnore
    @JsonProperty(value = "messageinstoreByMessageinstoreUuid")
    public Messageinstore getOriginalMessageInStore() {
        return originalMessageInStore;
    }

    public void setOriginalMessageInStore(Messageinstore messageinstoreByMessageinstoreUuid) {
        this.originalMessageInStore = messageinstoreByMessageinstoreUuid;
    }

    @ManyToOne
    @JoinColumn(name = "TEMPLATE_ID", referencedColumnName = "TEMPLATE_ID", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    @JsonProperty(value = "templateByTemplateId")
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
        Undressedmessage that = (Undressedmessage) o;
        return Objects.equals(undressedmessageUuid, that.undressedmessageUuid) &&
                Arrays.equals(fullUndressedMessage, that.fullUndressedMessage) &&
                Objects.equals(originalMessageInStore, that.originalMessageInStore) &&
                Objects.equals(relatedTemplate, that.relatedTemplate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(undressedmessageUuid, originalMessageInStore, relatedTemplate);
        result = 31 * result + Arrays.hashCode(fullUndressedMessage);
        return result;
    }
}
