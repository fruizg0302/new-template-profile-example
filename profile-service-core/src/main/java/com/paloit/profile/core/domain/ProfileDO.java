package com.paloit.profile.core.domain;

import java.time.Instant;

import com.paloit.profile.core.enums.ProfileStatus;

import lombok.Data;

@Data
public class ProfileDO {
  private String id;
  private String name;
  private ProfileStatus status;
  private Instant createdDatetime;
  private Instant lastModifiedDatetime;
  private String cardId;
}