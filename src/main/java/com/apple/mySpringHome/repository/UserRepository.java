package com.apple.mySpringHome.repository;

import com.apple.mySpringHome.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
