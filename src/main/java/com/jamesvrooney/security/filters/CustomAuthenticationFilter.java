package com.jamesvrooney.security.filters;

import com.jamesvrooney.security.authentication.CustomAuthentication;
import com.jamesvrooney.security.manager.CustomAuthenticationManager;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@AllArgsConstructor
@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private CustomAuthenticationManager customAuthenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        var key = request.getHeader("x-api-key");

        var customAuthentication = new CustomAuthentication(false, key);

        try {
            final Authentication result = customAuthenticationManager.authenticate(customAuthentication);

            if (result.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(result);

                filterChain.doFilter(request, response);
            }
        } catch (AuthenticationException ex) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
