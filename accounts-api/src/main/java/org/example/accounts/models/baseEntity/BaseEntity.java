package org.example.accounts.models.baseEntity;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

import static java.time.ZoneOffset.UTC;

@MappedSuperclass
@ToString
@Getter @Setter

public abstract class BaseEntity {

    @Column(updatable = false)
    private ZonedDateTime createdAt;

    @Column(updatable = false)
    private String createdBy;

    @Column(insertable = false)
    private ZonedDateTime updatedAt;

    @Column(insertable = false)
    private String updatedBy;

    @PrePersist
    protected void onCreate() {
        createdAt = ZonedDateTime.now(UTC);
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = ZonedDateTime.now(UTC);
    }

}
