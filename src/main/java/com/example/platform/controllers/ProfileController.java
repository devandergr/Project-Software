package com.example.platform.controllers;

import com.example.platform.models.Profile;
import com.example.platform.repositories.UserRepository;
import com.example.platform.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private UserRepository userRepository;

    @PutMapping("/update/{userId}")
    public ResponseEntity<?> updateProfile(@PathVariable Integer userId,
                                           @RequestBody Map<String, String> updates){
        Optional<Profile> optionalProfile = profileService.getProfileById(userId);
        if (!optionalProfile.isPresent()) {
            return ResponseEntity.badRequest().body("Profile not found for userId: " + userId);
        }

        profileService.updateProfile(optionalProfile.get()  , updates.get("photo"), updates.get("description"));

        return ResponseEntity.ok("Profile update successfully");
    }

    @GetMapping("/view/{userId}")
    public ResponseEntity<?> viewProfile(@PathVariable Integer userId) {
        Optional<Profile> optionalProfile = profileService.getProfileById(userId);
        if (!optionalProfile.isPresent()) {
            return ResponseEntity.badRequest().body("Profile Not Found for userid: " + userId);
        }
        return ResponseEntity.ok(optionalProfile.get());
    }

}
