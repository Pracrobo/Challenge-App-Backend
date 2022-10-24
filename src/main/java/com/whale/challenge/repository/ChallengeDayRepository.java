package com.whale.challenge.repository;

import com.whale.challenge.entity.ChallengeDay;
import com.whale.challenge.repository.QRepository.QChallengeDayRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeDayRepository extends JpaRepository<ChallengeDay, Integer>, QChallengeDayRepository {
}