package com.whale.challenge.repository;

import com.whale.challenge.entity.Challenge;
import com.whale.challenge.repository.QRepository.QChallengeRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge, Integer>, QChallengeRepository {
}
