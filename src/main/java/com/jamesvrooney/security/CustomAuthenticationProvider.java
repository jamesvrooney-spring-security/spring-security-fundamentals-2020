package com.jamesvrooney.security;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final UserDetails user = userDetailsService.loadUserByUsername(authentication.getName());

        if (passwordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())) {

            var updatedAuth = new UsernamePasswordAuthenticationToken(
                    authentication.getName(),
                    user.getPassword(),
                    List.of(() -> "read")
            );

            return updatedAuth;
        }

        throw new BadCredentialsException("Error!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
