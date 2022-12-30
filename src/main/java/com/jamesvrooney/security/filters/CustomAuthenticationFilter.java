package com.jamesvrooney.security.filters;

import jakarta.servlet.*;
import org.springframework.security.web.authentication.AuthenticationFilter;

import java.io.IOException;

public class CustomAuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        
    }
}
