package com.bloomberg.clustereddata.domain.xtras;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;

@MappedSuperclass
public class AbstractBaseEntity implements java.io.Serializable, AbstractEntity<String> {


    @Transient
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractBaseEntity.class);
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false, length = 40)
    protected String id;

    @Version
    private long version = 0;


    @Column(name="order_time")
    private ZonedDateTime orderingTime;


    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public ZonedDateTime getOrderDate() {
        return this.orderingTime;
    }

    @Override
    public void setOrderDate(ZonedDateTime createdDate) {
        this.orderingTime = createdDate;
    }

    public long getVersion() {
        return version;
    }


    @PrePersist
    public void abstractPrePersist() {
        LOGGER.debug("about to run abstractPrePersist method");
        if (AppUtil.INSTANCE.stringIsNullOrEmpty(id)) {
            id = ID.generateUUIDString();
        }
        LOGGER.debug("finished running abstractPrePersist method");
    }

    @Override
    public int hashCode() {
        int hash = 3;/*
        hash = 71 * hash + Objects.hashCode(this.status);*/
        hash = 71 * hash + Objects.hashCode(this.version);
        hash = 71 * hash + Objects.hashCode(this.orderingTime);

        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractBaseEntity that = (AbstractBaseEntity) o;

        if (version != that.version) return false;
        if (LOGGER != null ? !LOGGER.equals(that.LOGGER) : that.LOGGER != null) return false;
        if (orderingTime != null ? !orderingTime.equals(that.orderingTime) : that.orderingTime != null) return false;
        return !(orderingTime != null ? !orderingTime.equals(that.orderingTime) : that.orderingTime != null);

    }


    @Override
    public String toString() {
        return "AbstractBaseEntity{" +
                "id='" + id + '\'' +
                ", version=" + version +
                ", orderingTime=" + orderingTime +

                '}';
    }

    @Transient
    @Override
    public String getIdx() {
        return id;
    }

    @Override
    public String getPk() {
        return id;
    }

    @Override
    public String getIde() {
        String idd = (id == null) ? "" : id;
        return EncDec.INSTANCE.encryptAndEncode(idd);
    }

    @Override
    public boolean isIdSet() {
        return id != null && !id.isEmpty();
    }
}
