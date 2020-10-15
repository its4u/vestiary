package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Origindestination {
    private String odCode;
    private String odName;
    private String direction;
    private Collection<Messageinstore> relatedMessageInStore;
    private Collection<Messageoutstore> relatedMessageOutStore;

    @Id
    @Column(name = "OD_CODE", nullable = false, length = 4)
    public String getOdCode() {
        return odCode;
    }

    public void setOdCode(String odCode) {
        this.odCode = odCode;
    }

    @Basic
    @Column(name = "OD_NAME", nullable = true, length = 20)
    public String getOdName() {
        return odName;
    }

    public void setOdName(String odName) {
        this.odName = odName;
    }

    @Basic
    @Column(name = "DIRECTION", nullable = true, length = 2)
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Origindestination that = (Origindestination) o;
        return Objects.equals(odCode, that.odCode) &&
                Objects.equals(odName, that.odName) &&
                Objects.equals(direction, that.direction);
    }

    public Origindestination() {
    }

    public Origindestination(String odCode) {
        this.odCode = odCode;
    }

    public Origindestination(String odCode, String odName, String direction) {
        this.odCode = odCode;
        this.odName = odName;
        this.direction = direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(odCode, odName, direction);
    }

    @OneToMany(mappedBy = "origin")
    public Collection<Messageinstore> getRelatedMessageInStore() {
        return relatedMessageInStore;
    }

    public void setRelatedMessageInStore(Collection<Messageinstore> messageinstoresByOdCode) {
        this.relatedMessageInStore = messageinstoresByOdCode;
    }

    @OneToMany(mappedBy = "destination")
    public Collection<Messageoutstore> getRelatedMessageOutStore() {
        return relatedMessageOutStore;
    }

    public void setRelatedMessageOutStore(Collection<Messageoutstore> messageoutstoresByOdCode) {
        this.relatedMessageOutStore = messageoutstoresByOdCode;
    }


}
