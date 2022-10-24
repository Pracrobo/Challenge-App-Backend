package com.whale.challenge.repository;

import com.whale.challenge.entity.Challenge;
import com.whale.challenge.repository.querydsl.QChallengeRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge, Integer>, QChallengeRepository {
}
