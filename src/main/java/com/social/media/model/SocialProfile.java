package com.social.media.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name="user_id")
    private SocialUser user;

//    public void setUser(SocialUser socialUser) {
//        this.user = socialUser;
//        if(user.getSocialProfile()!=this){
//            user.setSocialProfile(this);
//        }
//    }
}
