package com.example.platform.services;

import com.example.platform.models.Profile;
import com.example.platform.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Optional<Profile> getProfileById(Integer userId) {
        return profileRepository.findById(userId);
    }

    public void updateProfile(Profile profile, String photo, String description) {
        if (photo != null) {
            profile.setPhoto(photo);
        }
        if (description != null) {
            profile.setDescription(description);
        }
        profileRepository.save(profile);
    }
}
