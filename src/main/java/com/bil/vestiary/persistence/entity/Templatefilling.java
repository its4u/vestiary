package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Templatefilling {
    private String templatefillingUuid;
    private Messagetype messagetypeByMsgtypeExpMsg;
    private Messagetype messagetypeByMsgtypeRelMsg;
    private Origindestination origindestinationByOriginRelMsg;
    private Origindestination origindestinationByDestination;
    private Fillingrulestemplate fillingrulestemplateByFillingRuleId;

    @Id
    @Column(name = "TEMPLATEFILLING_UUID", nullable = false, length = 36)
    public String getTemplatefillingUuid() {
        return templatefillingUuid;
    }

    public void setTemplatefillingUuid(String templatefillingUuid) {
        this.templatefillingUuid = templatefillingUuid;
    }



    @ManyToOne
    @JoinColumn(name = "MSGTYPE_EXP_MSG", referencedColumnName = "MSGTYPE", nullable = false)
    public Messagetype getMessagetypeByMsgtypeExpMsg() {
        return messagetypeByMsgtypeExpMsg;
    }

    public void setMessagetypeByMsgtypeExpMsg(Messagetype messagetypeByMsgtypeExpMsg) {
        this.messagetypeByMsgtypeExpMsg = messagetypeByMsgtypeExpMsg;
    }

    @ManyToOne
    @JoinColumn(name = "MSGTYPE_REL_MSG", referencedColumnName = "MSGTYPE", nullable = false)
    public Messagetype getMessagetypeByMsgtypeRelMsg() {
        return messagetypeByMsgtypeRelMsg;
    }

    public void setMessagetypeByMsgtypeRelMsg(Messagetype messagetypeByMsgtypeRelMsg) {
        this.messagetypeByMsgtypeRelMsg = messagetypeByMsgtypeRelMsg;
    }

    @ManyToOne
    @JoinColumn(name = "ORIGIN_REL_MSG", referencedColumnName = "OD_CODE", nullable = false)
    public Origindestination getOrigindestinationByOriginRelMsg() {
        return origindestinationByOriginRelMsg;
    }

    public void setOrigindestinationByOriginRelMsg(Origindestination origindestinationByOriginRelMsg) {
        this.origindestinationByOriginRelMsg = origindestinationByOriginRelMsg;
    }

    @ManyToOne
    @JoinColumn(name = "DESTINATION", referencedColumnName = "OD_CODE", nullable = false)
    public Origindestination getOrigindestinationByDestination() {
        return origindestinationByDestination;
    }

    public void setOrigindestinationByDestination(Origindestination origindestinationByDestination) {
        this.origindestinationByDestination = origindestinationByDestination;
    }

    @ManyToOne
    @JoinColumn(name = "FILLING_RULE_ID", referencedColumnName = "FILLING_RULE_ID", nullable = false)
    public Fillingrulestemplate getFillingrulestemplateByFillingRuleId() {
        return fillingrulestemplateByFillingRuleId;
    }

    public void setFillingrulestemplateByFillingRuleId(Fillingrulestemplate fillingrulestemplateByFillingRuleId) {
        this.fillingrulestemplateByFillingRuleId = fillingrulestemplateByFillingRuleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Templatefilling that = (Templatefilling) o;
        return Objects.equals(templatefillingUuid, that.templatefillingUuid) &&
                Objects.equals(messagetypeByMsgtypeExpMsg, that.messagetypeByMsgtypeExpMsg) &&
                Objects.equals(messagetypeByMsgtypeRelMsg, that.messagetypeByMsgtypeRelMsg) &&
                Objects.equals(origindestinationByOriginRelMsg, that.origindestinationByOriginRelMsg) &&
                Objects.equals(origindestinationByDestination, that.origindestinationByDestination) &&
                Objects.equals(fillingrulestemplateByFillingRuleId, that.fillingrulestemplateByFillingRuleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(templatefillingUuid, messagetypeByMsgtypeExpMsg, messagetypeByMsgtypeRelMsg, origindestinationByOriginRelMsg, origindestinationByDestination, fillingrulestemplateByFillingRuleId);
    }
}
