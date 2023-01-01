package com.jamesvrooney.security.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@AllArgsConstructor
@Getter
@Setter
//@Component
//public class CustomAuthentication extends UsernamePasswordAuthenticationToken {
public class CustomAuthentication implements Authentication {

    private final boolean isAuthenticated;
    private final String key;

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

//    public CustomAuthentication(Object principal, Object credentials) {
//        super(principal, credentials);
//    }
//
//    public CustomAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
//        super(principal, credentials, authorities);
//    }
}
