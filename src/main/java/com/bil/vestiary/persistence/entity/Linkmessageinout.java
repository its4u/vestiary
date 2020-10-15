package com.bil.vestiary.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Linkmessageinout {
    private String linkmessageUuid;
    private Messageinstore messageIn;
    private Messageoutstore messageOut;
    private System systemOrigin;

    @Id
    @Column(name = "LINKMESSAGE_UUID", nullable = false, length = 36)
    public String getLinkmessageUuid() {
        return linkmessageUuid;
    }

    public void setLinkmessageUuid(String linkmessageUuid) {
        this.linkmessageUuid = linkmessageUuid;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linkmessageinout that = (Linkmessageinout) o;
        return Objects.equals(linkmessageUuid, that.linkmessageUuid) &&
                Objects.equals(messageIn, that.messageIn) &&
                Objects.equals(messageOut, that.messageOut) &&
                Objects.equals(systemOrigin, that.systemOrigin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkmessageUuid, messageIn, messageOut, systemOrigin);
    }

    @ManyToOne
    @JoinColumn(name = "MESSAGEINSTORE_UUID", referencedColumnName = "MESSAGEINSTORE_UUID", nullable = false)
    public Messageinstore getMessageIn() {
        return messageIn;
    }

    public void setMessageIn(Messageinstore messageinstoreByMessageinstoreUuid) {
        this.messageIn = messageinstoreByMessageinstoreUuid;
    }

    @ManyToOne
    @JoinColumn(name = "MESSAGEOUTSORE_UUID", referencedColumnName = "MESSAGEOUTSTORE_UUID", nullable = false)
    public Messageoutstore getMessageOut() {
        return messageOut;
    }

    public void setMessageOut(Messageoutstore messageoutstoreByMessageoutsoreUuid) {
        this.messageOut = messageoutstoreByMessageoutsoreUuid;
    }

    @ManyToOne
    @JoinColumn(name = "SYSTEM", referencedColumnName = "SYSTEM", nullable = false)
    public System getSystemOrigin() {
        return systemOrigin;
    }

    public void setSystemOrigin(System systemBySystem) {
        this.systemOrigin = systemBySystem;
    }
}
