package com.whale.challenge.controller;

import com.whale.challenge.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/challenge")
public class ChallengeController {

	private final ChallengeService challengeService;

}
