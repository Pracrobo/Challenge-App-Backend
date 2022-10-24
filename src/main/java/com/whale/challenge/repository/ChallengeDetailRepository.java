package com.whale.challenge.repository;

import com.whale.challenge.entity.ChallengeDetail;
import com.whale.challenge.repository.QRepository.QChallengeDetailRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeDetailRepository extends JpaRepository<ChallengeDetail, Integer>, QChallengeDetailRepository {
}