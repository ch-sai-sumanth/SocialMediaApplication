package com.social.media.repo;

import com.social.media.model.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISocialProfileRepo extends JpaRepository<SocialProfile, Long> {
}
