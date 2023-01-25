package org.app.models;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@MappedSuperclass
public class BaseModel extends PanacheEntityBase {
    @Column(name = "created_by", nullable = true)
    public String createdBy;

    @Column(name = "created_datetime", nullable = true)
    public LocalDateTime createdDateTime = LocalDateTime.now(ZoneOffset.UTC);

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDateTime() {
        return this.createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDatetime) {
        this.createdDateTime = createdDatetime;
    }
}
