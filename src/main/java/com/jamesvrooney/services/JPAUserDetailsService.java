package com.jamesvrooney.services;

import com.jamesvrooney.entities.SecurityUser;
import com.jamesvrooney.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class JPAUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var user = userRepository.findByUsername(username);

        final SecurityUser userFromDb = user.map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        log.info("User from database retrieved: {}", userFromDb.getUsername());
        
        return userFromDb;
    }
}
