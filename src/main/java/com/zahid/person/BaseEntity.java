package com.zahid.person;

import java.time.Instant;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Getter
    public Instant createdAt = Instant.now();

    @Getter
    @Setter
    public Instant updatedAt = Instant.now();

    @Getter
    @Setter
    public Boolean deleted = false;

    @Getter
    @Setter
    @Version
    public Integer version;
}
