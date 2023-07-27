package com.paloit.profile.server.grpc;

import com.google.protobuf.StringValue;
import com.paloit.profile.core.service.ProfileService;
import com.paloit.profile.grpc.*;
import com.paloit.profile.server.grpc.ProfileServiceGrpcImpl.ProfileGrpcMapper;

import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.mapstruct.factory.Mappers;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ProfileServiceGrpcImplTest {

    private static ProfileService serviceCore;
    private static ProfileServiceGrpcImpl service;


    private static StreamObserver<CreateProfileResponse> createStreamObserver;
    private static StreamObserver<GetProfileResponse> getStreamObserver;
    private static StreamObserver<GetProfilesResponse> getSStreamObserver;
    private static StreamObserver<UpdateProfileResponse> updateProfileObserver;

    private static CreateProfileResponse createProfileResponse;
    private static GetProfileResponse getProfileResponse;
    private static GetProfilesResponse getProfilesResponse;
    private static UpdateProfileResponse updateProfileResponse;


    private static final UUID gUUID = UUID.randomUUID();


    @BeforeAll
    public static void setUp(){
        serviceCore = Mockito.mock(ProfileService.class);
        ProfileGrpcMapper mapper = Mappers.getMapper( ProfileGrpcMapper.class );

        service = new ProfileServiceGrpcImpl(serviceCore,mapper);

        ProfileDto accountDtoRes = ProfileDto.newBuilder()
                .setName("Profile1")
                .setId(StringValue.of(gUUID.toString()))
                .build();

        createProfileResponse = CreateProfileResponse.newBuilder()
                .setProfile(accountDtoRes)
                .build();

        updateProfileResponse = UpdateProfileResponse.newBuilder()
                .build();


        getProfileResponse = GetProfileResponse.newBuilder()
                .setProfile(accountDtoRes)
                .build();

        getProfilesResponse = GetProfilesResponse.newBuilder()
                .build();

        createStreamObserver = new StreamObserver<>() {
            @Override
            public void onNext(CreateProfileResponse createProfileResponse) {
            }
            @Override
            public void onError(Throwable throwable) {
            }
            @Override
            public void onCompleted() {
            }
        };

        getStreamObserver= new StreamObserver<>() {
            @Override
            public void onNext(GetProfileResponse getProfileResponse) {
            }
            @Override
            public void onError(Throwable throwable) {
            }
            @Override
            public void onCompleted() {
            }
        };

        getSStreamObserver = new StreamObserver<>() {
            @Override
            public void onNext(GetProfilesResponse getProfilesResponse) {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onCompleted() {
            }
        };

        updateProfileObserver = new StreamObserver<>() {
            @Override
            public void onNext(UpdateProfileResponse updateProfileResponse) {
            }
            @Override
            public void onError(Throwable throwable) {
            }
            @Override
            public void onCompleted() {
            }
        };



    }

}