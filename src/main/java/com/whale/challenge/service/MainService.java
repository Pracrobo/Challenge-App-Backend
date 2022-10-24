package com.whale.challenge.service;

import com.whale.challenge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MainService {

	private final UserRepository userRepository;

}
