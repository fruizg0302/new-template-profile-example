package com.paloit.profile.persistence.jpa.repositories;

import com.paloit.profile.persistence.jpa.entities.ProfileEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProfileJpaRepository extends JpaRepository<ProfileEntity, String> {

    
    @Modifying
    @Query("update #{#entityName} set status = :status where id = :id")
    int updateStatus(String status, String id);
    

}