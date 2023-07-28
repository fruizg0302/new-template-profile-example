package com.paloit.profile.persistence.jpa.entities;

import java.time.Instant;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "profiles")
public class ProfileEntity {

    @Id
    @UuidGenerator
    @Column(name = "profile_id")
    private String id;
    private String name;
    private String status;
    private Instant lastModifiedDatetime;
    private Instant createdDatetime;
    private String cardId;

    @Version
    protected Short version;

}
