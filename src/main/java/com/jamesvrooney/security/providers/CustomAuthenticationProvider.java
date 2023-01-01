package com.jamesvrooney.security.providers;

import com.jamesvrooney.security.authentication.CustomAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${key}")
    private String secretKey;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final CustomAuthentication ca = (CustomAuthentication) authentication;

        if (secretKey.equals(ca.getKey())) {
            var validCustomAuthentication = new CustomAuthentication(true, null);

            return validCustomAuthentication;
        }

        throw new BadCredentialsException("Booo!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
