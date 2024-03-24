package com.ms.user.repositories;

import com.ms.user.enterprise.CustomQuerydslPredicateExecutor;
import com.ms.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, CustomQuerydslPredicateExecutor<User> {
    UserDetails findByUsername(String username);
    UserDetails findByEmail(String email);
}
