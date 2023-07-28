package com.paloit.profile.server.grpc;

import com.paloit.profile.core.domain.ProfileDO;
import com.paloit.profile.core.service.ProfileService;
import com.paloit.profile.grpc.*;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.lognet.springboot.grpc.GRpcService;
import org.mapstruct.Mapper;

@GRpcService
@RequiredArgsConstructor
public class ProfileServiceGrpcImpl extends ProfileServiceGrpc.ProfileServiceImplBase {

    private final ProfileService service;
    private final ProfileGrpcMapper mapper;

    @Override
    public void createProfile(ProfileDto request, StreamObserver<CreateProfileResponse> responseObserver) {
        ProfileDO response = service.createProfile(
                                    mapper.fromCreateProfileRequestToDomain(request));

        CreateProfileResponse createProfileResponse = CreateProfileResponse.newBuilder()
                                                    .setProfile(mapper.fromDomainToProfileDto(response) )
                                                    .build();



        responseObserver.onNext(createProfileResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getProfile(GetProfileRequest request, StreamObserver<GetProfileResponse> responseObserver) {
        ProfileDO response = service.findById(request.getId());
        GetProfileResponse getProfileResponse = GetProfileResponse.newBuilder()
                                                    .setProfile(mapper.fromDomainToProfileDto(response) )
                                                    .build();

        responseObserver.onNext(getProfileResponse);
        responseObserver.onCompleted();
    }

    @Override
    public void getProfiles(GetProfilesRequest request, StreamObserver<GetProfilesResponse> responseObserver) {
        responseObserver.onCompleted();
    }

    @Override
    public void updateProfile(ProfileDto request, StreamObserver<UpdateProfileResponse> responseObserver) {
        responseObserver.onCompleted();
    }

    @Mapper(uses = {ProtobufMapper.class})
    public interface ProfileGrpcMapper {
        ProfileDO fromCreateProfileRequestToDomain(ProfileDto request);
        ProfileDto fromDomainToProfileDto (ProfileDO domain );
    }
}
