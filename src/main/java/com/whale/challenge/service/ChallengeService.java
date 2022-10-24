package com.whale.challenge.service;

import com.whale.challenge.repository.ChallengeDayRepository;
import com.whale.challenge.repository.ChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChallengeService {

	private final ChallengeRepository challengeRepository;
	private final ChallengeDayRepository challengeDayRepository;

}
