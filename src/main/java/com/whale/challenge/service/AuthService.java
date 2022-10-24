package com.whale.challenge.service;

import com.whale.challenge.dto.ResponseDto;
import com.whale.challenge.dto.SignUpDto;
import com.whale.challenge.module.mapper.UserMapper;
import com.whale.challenge.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
//	private final MailHandler mailHandler;
	private final TemplateEngine templateEngine;
	private final RedisTemplate<String, String> redisTemplate;
	private final UserMapper userMapper;

//	@Value("${spring.mail.username}")
//	private String mailSenderId;

	@Transactional
	public ResponseEntity<ResponseDto> signUp(SignUpDto signUpDto) {
		return null;
	}

//	public ResponseEntity<ResponseDto> sendAuthEmail(String email) throws MessagingException {
//
//		String checkToken = UUID.randomUUID().toString().substring(0, 6);
//
//		Context context = new Context();
//		context.setVariable("authCode", checkToken);
//		String htmlString = templateEngine.process("code", context);
//
//		mailHandler.setTo(email);
//		mailHandler.setFrom(mailSenderId);
//		mailHandler.setSubject("이루리 - 이메일 인증을 진행해주세요.");
//		mailHandler.setText(htmlString, true);
//		mailHandler.send();
//
//		ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
//
//		String key = new StringBuilder()
//				.append("auth code : ")
//				.append(email)
//				.toString();
//
//		if (opsForValue.get(key) != null) {
//			redisTemplate.delete(key);
//		}
//
//		opsForValue.set(key, checkToken);
//		redisTemplate.expire(key, 3, MINUTES);
//
//		return null;
//	}
}
