package com.paloit.profile.core.service.impl;

import java.time.Instant;

import com.paloit.card.grpc.CreateCardResponse;
import com.paloit.profile.core.domain.ProfileDO;
import com.paloit.profile.core.enums.ProfileStatus;
import com.paloit.profile.core.exceptions.ResourceNotFoundException;
import com.paloit.profile.core.mappers.ProfileMapper;
import com.paloit.profile.core.service.ProfileService;
import com.paloit.profile.persistence.jpa.entities.ProfileEntity;
import com.paloit.profile.persistence.jpa.repositories.ProfileJpaRepository;
import com.paloit.card.client.CardServiceClient;
import com.paloit.card.grpc.CardDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileJpaRepository repository;
    private final ProfileMapper mapper;
    private final CardServiceClient cardService;


    @Override
    public ProfileDO createProfile(ProfileDO profile) {
        ProfileEntity entity = mapper.domainToEntity(profile);

        CardDto.Builder cardDto = CardDto.newBuilder();
        cardDto.setName(entity.getName());
        CreateCardResponse createCardResponse = cardService.createCard(cardDto.build());

        entity.setStatus(ProfileStatus.ACTIVE.toString());
        entity.setCreatedDatetime(Instant.now());
        entity.setLastModifiedDatetime(Instant.now());
        entity.setCardId(String.valueOf(createCardResponse.getCard().getId()));

        entity = repository.save(entity);

        return mapper.entityToDomain(entity);   
    }

    @Override
    public ProfileDO findById(String id) {
    return repository.findById(id)
        .map(mapper::entityToDomain)
        .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void deleteById(String id){
        repository.updateStatus(ProfileStatus.DELETED.toString(),id);
    }

}
