package com.whale.challenge.dto;

import com.whale.challenge.entity.enums.Gender;
import com.whale.challenge.module.validation.annotation.UserPassword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@UserPassword
public class SignUpDto {

	private String userId;

	@Size(message = "닉네임은 10자 제한입니다.", max = 20)
	private String nickname;

	private String userPass;

	private String userPassConfirm;


	private String birthDate;

	private Gender gender;

	private String emailAuthCode;

	private String email;

}
