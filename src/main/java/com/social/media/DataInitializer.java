package com.social.media;

import com.social.media.model.Post;
import com.social.media.model.SocialGroup;
import com.social.media.model.SocialProfile;
import com.social.media.model.SocialUser;
import com.social.media.repo.IPostRepo;
import com.social.media.repo.ISocialGroupRepo;
import com.social.media.repo.ISocialProfileRepo;
import com.social.media.repo.ISocialUserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {


    private final ISocialUserRepo userRepo;
    private final ISocialGroupRepo groupRepo;
    private final ISocialProfileRepo profileRepo;
    private final IPostRepo postRepo;


    public DataInitializer(ISocialUserRepo userRepo, ISocialGroupRepo groupRepo, ISocialProfileRepo profileRepo, IPostRepo postRepo) {
        this.userRepo = userRepo;
        this.groupRepo = groupRepo;
        this.profileRepo = profileRepo;
        this.postRepo = postRepo;
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {

            //Create users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            //save users to the database
            userRepo.save(user1);
            userRepo.save(user2);
            userRepo.save(user3);

            //create group
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            //add users to group
            group1.getSocialUsers().add(user1);
            group1.getSocialUsers().add(user2);
            group2.getSocialUsers().add(user2);
            group2.getSocialUsers().add(user3);

            groupRepo.save(group1);
            groupRepo.save(group2);

            //Associate users with groups
            user1.getGroups().add(group1);
            user2.getGroups().add(group1);
            user2.getGroups().add(group2);
            user3.getGroups().add(group2);

            userRepo.save(user1);
            userRepo.save(user2);
            userRepo.save(user3);

            //Create posts
            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            //associating posts to users
            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            //saving Posts
            postRepo.save(post1);
            postRepo.save(post2);
            postRepo.save(post3);


            //creating social profiles
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            //Associating profiles to users
            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            //saving the profiles to repo
            profileRepo.save(profile1);
            profileRepo.save(profile2);
            profileRepo.save(profile3);

        };
    }
}
