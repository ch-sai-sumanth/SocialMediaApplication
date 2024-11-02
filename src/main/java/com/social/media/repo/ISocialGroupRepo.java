package com.social.media.repo;

import com.social.media.model.SocialGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISocialGroupRepo extends JpaRepository<SocialGroup, Long> {
}
