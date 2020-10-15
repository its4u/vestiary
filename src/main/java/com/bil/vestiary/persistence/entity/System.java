package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class System {
    private String systemActor;
    private String systemDescription;
    private Collection<Linkmessageinout> relatedLinkMessageInOut;
    private Collection<Messageoutstore> relatedMessageoutstore;

    @Id
    @Column(name = "SYSTEM", nullable = false, length = 4)
    public String getSystemActor() {
        return systemActor;
    }

    public void setSystemActor(String system) {
        this.systemActor = system;
    }

    @Basic
    @Column(name = "SYSTEM_DESCRIPTION", nullable = true, length = 50)
    public String getSystemDescription() {
        return systemDescription;
    }

    public void setSystemDescription(String systemDescription) {
        this.systemDescription = systemDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        System system1 = (System) o;
        return Objects.equals(systemActor, system1.systemActor) &&
                Objects.equals(systemDescription, system1.systemDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(systemActor, systemDescription);
    }

    @OneToMany(mappedBy = "systemOrigin")
    public Collection<Linkmessageinout> getRelatedLinkMessageInOut() {
        return relatedLinkMessageInOut;
    }

    public void setRelatedLinkMessageInOut(Collection<Linkmessageinout> linkmessageinoutsBySystem) {
        this.relatedLinkMessageInOut = linkmessageinoutsBySystem;
    }

    @OneToMany(mappedBy = "systemDestination")
    public Collection<Messageoutstore> getRelatedMessageoutstore() {
        return relatedMessageoutstore;
    }

    public void setRelatedMessageoutstore(Collection<Messageoutstore> messageoutstoresBySystem) {
        this.relatedMessageoutstore = messageoutstoresBySystem;
    }
}
