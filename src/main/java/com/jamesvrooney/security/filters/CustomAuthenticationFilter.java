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

import java.io.IOException;

@AllArgsConstructor
@Component
public class CustomAuthenticationFilter implements Filter {

    private CustomAuthenticationManager customAuthenticationManager;

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {

        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;

        var key = httpRequest.getHeader("x-api-key");

        var customAuthentication = new CustomAuthentication(false, key);

        try {
            final Authentication result = customAuthenticationManager.authenticate(customAuthentication);

            if (result.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(result);

                filterChain.doFilter(request, response);
            }
        } catch (AuthenticationException ex) {
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }
    }
}
