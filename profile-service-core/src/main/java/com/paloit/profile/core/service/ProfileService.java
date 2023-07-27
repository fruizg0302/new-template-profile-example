package com.paloit.profile.core.service;

import com.paloit.profile.core.domain.ProfileDO;

public interface ProfileService {
    ProfileDO createProfile(ProfileDO profile);
    ProfileDO findById(String id);
    void deleteById(String id);
}

