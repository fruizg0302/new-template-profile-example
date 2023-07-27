package com.paloit.profile.persistence.jpa.repositories;

import com.paloit.profile.persistence.jpa.entities.ProfileEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProfileJpaRepositoryTest {
    
    private static ProfileJpaRepository gProfileJpaRepository;
    private static ProfileEntity gProfileEntity;


    @BeforeAll
    static void setUp(){
       
    }

    @Test
    void test_createProfile(){
        
    }


    @Test
    void test_getProfileById(){


    }


}