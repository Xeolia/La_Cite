package com.la_cite.surfrider.repository;

import com.la_cite.surfrider.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User getUserByUsername(String username);
}
