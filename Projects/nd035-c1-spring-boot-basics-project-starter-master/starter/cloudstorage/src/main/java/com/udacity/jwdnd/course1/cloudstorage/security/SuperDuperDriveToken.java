package com.udacity.jwdnd.course1.cloudstorage.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class SuperDuperDriveToken extends UsernamePasswordAuthenticationToken {
    private Integer userId;

    public SuperDuperDriveToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities,
                                Integer userId) {
        super(principal, credentials, authorities);
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "SuperDuperDriveToken{" +
                "userId=" + userId +
                '}';
    }
}
