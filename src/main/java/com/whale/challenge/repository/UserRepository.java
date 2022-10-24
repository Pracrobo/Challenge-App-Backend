package com.whale.challenge.repository;

import com.whale.challenge.entity.User;
import com.whale.challenge.repository.querydsl.QUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>, QUserRepository {
}
