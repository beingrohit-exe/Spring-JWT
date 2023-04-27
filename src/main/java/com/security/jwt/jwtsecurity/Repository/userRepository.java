package com.security.jwt.jwtsecurity.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.jwt.jwtsecurity.Modal.User;

public interface userRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
