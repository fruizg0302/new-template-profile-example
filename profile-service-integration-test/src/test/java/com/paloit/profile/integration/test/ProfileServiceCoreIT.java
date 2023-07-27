package com.paloit.profile.integration.test;

import com.paloit.profile.grpc.ProfileDto;
import com.paloit.profile.grpc.GetProfileRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProfileServiceCoreIT extends ProfileServiceBaseIT{

    @Test
    public void createProfile(){
     var createRequest= ProfileDto.newBuilder().setName("test").build();
        var response=client.createProfile(createRequest);
        Assertions.assertTrue(response.getProfile().getId().isInitialized());
    }

    @Test
    public void findProfile(){
        var createProfile= ProfileDto.newBuilder().setName("test").build();
        var response=client.createProfile(createProfile);
        var getProfileRequest=GetProfileRequest.newBuilder().setId(response.getProfile().getId().getValue()).build();
        var getProfileResponse=client.getProfile(getProfileRequest);
        Assertions.assertTrue(getProfileResponse.hasProfile());
        Assertions.assertTrue(getProfileResponse.getProfile().getId().isInitialized());
    }

}