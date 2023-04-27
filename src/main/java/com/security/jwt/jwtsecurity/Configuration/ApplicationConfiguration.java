package com.security.jwt.jwtsecurity.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.security.jwt.jwtsecurity.Repository.userRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {

    private final userRepository userRepository;

    /**
     * Generic Way
     */
    // @Bean
    // public UserDetailsService userDetailsService(){
    // return new UserDetailsService() {

    // @Override
    // public UserDetails loadUserByUsername(String username) throws
    // UsernameNotFoundException {

    // }

    // };
    // }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not Present : " + getClass().getName()));
    }
}
