package com.paloit.profile.client;

import io.grpc.ManagedChannelBuilder;
import com.paloit.profile.grpc.*;


public class ProfileServiceClient  {

  ProfileServiceGrpc.ProfileServiceBlockingStub stub;

    public static ProfileServiceClient of(String host, int port) {
        return new ProfileServiceClient(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    private ProfileServiceClient(ManagedChannelBuilder<?> channelBuilder) {
        this.stub = ProfileServiceGrpc.newBlockingStub(channelBuilder.build());
    }

    public CreateProfileResponse createProfile(ProfileDto profile) {
        return stub.createProfile(profile);
    }

    public GetProfilesResponse getProfiles(GetProfilesRequest request) {
        return stub.getProfiles(request);
    }

    public GetProfileResponse getProfile(GetProfileRequest request) {
        return stub.getProfile(request);
    }

    public UpdateProfileResponse updateProfile(ProfileDto profile) {
        return stub.updateProfile(profile);
    }

    public GrpcCreateCardResponse createCard(GrpcCreateCardRequest request) { return stub.createCard(request); }

}
