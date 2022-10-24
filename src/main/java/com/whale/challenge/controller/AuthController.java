package com.whale.challenge.controller;

import com.whale.challenge.dto.ResponseDto;
import com.whale.challenge.dto.SignUpDto;
import com.whale.challenge.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

	private final AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<ResponseDto> signUp(@RequestBody SignUpDto signUpDto) {
		return authService.signUp(signUpDto);
	}

	@PostMapping("/email")
	public ResponseEntity<ResponseDto> sendAuthEmail(@RequestBody String email) throws MessagingException {
//		return authService.sendAuthEmail(email);
		return null;
	}

}
