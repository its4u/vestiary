package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Fillingrulestemplate {
    private String fillingRuleId;
    private String fillingRuleName;
    private byte[] mappingTemplate;
    private Collection<Templatefilling> relatedTemplateFilling;

    @Id
    @Column(name = "FILLING_RULE_ID", nullable = false, length = 36)
    public String getFillingRuleId() {
        return fillingRuleId;
    }

    public void setFillingRuleId(String fillingRuleId) {
        this.fillingRuleId = fillingRuleId;
    }

    @Basic
    @Column(name = "FILLING_RULE_NAME", nullable = true, length = 50)
    public String getFillingRuleName() {
        return fillingRuleName;
    }

    public void setFillingRuleName(String fillingRuleName) {
        this.fillingRuleName = fillingRuleName;
    }

    @Basic
    @Column(name = "MAPPING_TEMPLATE", nullable = true)
    public byte[] getMappingTemplate() {
        return mappingTemplate;
    }

    public void setMappingTemplate(byte[] mappingTemplate) {
        this.mappingTemplate = mappingTemplate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fillingrulestemplate that = (Fillingrulestemplate) o;
        return Objects.equals(fillingRuleId, that.fillingRuleId) &&
                Objects.equals(fillingRuleName, that.fillingRuleName) &&
                Arrays.equals(mappingTemplate, that.mappingTemplate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(fillingRuleId, fillingRuleName);
        result = 31 * result + Arrays.hashCode(mappingTemplate);
        return result;
    }

    @OneToMany(mappedBy = "fillingrulestemplateByFillingRuleId")
    public Collection<Templatefilling> getRelatedTemplateFilling() {
        return relatedTemplateFilling;
    }

    public void setRelatedTemplateFilling(Collection<Templatefilling> templatefillingsByFillingRuleId) {
        this.relatedTemplateFilling = templatefillingsByFillingRuleId;
    }
}
