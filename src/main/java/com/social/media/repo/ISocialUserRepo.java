package com.social.media.repo;

import com.social.media.model.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISocialUserRepo extends JpaRepository<SocialUser, Long> {
}
