package com.vd.vid_share.secure;

import com.vd.vid_share.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class UserDet implements UserDetails {
    private final User user;

    public UserDet(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>(); //roles here
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    public UUID getId(){
        return user.getId();
    }


    public User getUser() {
        return user;
    }
}
