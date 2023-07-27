package com.paloit.profile.core.mappers;

import com.paloit.profile.core.domain.ProfileDO;
import com.paloit.profile.persistence.jpa.entities.ProfileEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProfileMapper {

    ProfileEntity domainToEntity(ProfileDO profile);

    ProfileDO entityToDomain(ProfileEntity profileEntity);
}