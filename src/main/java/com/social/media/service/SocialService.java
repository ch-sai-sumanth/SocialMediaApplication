package com.social.media.service;

import com.social.media.model.SocialUser;
import com.social.media.repo.ISocialUserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {

    @Autowired
    ISocialUserRepo socialUserRepo;


    public List<SocialUser> getAllUsers() {
        return socialUserRepo.findAll();
    }

    public SocialUser addUser(SocialUser socialUser) {
        return socialUserRepo.save(socialUser);
    }

    public void deleteUser(Long userId) {
        SocialUser user = socialUserRepo.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        socialUserRepo.delete(user);
    }
}
