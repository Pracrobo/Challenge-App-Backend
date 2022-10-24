package com.whale.challenge.module.validation.validator;

import com.whale.challenge.dto.SignUpDto;
import com.whale.challenge.module.encrypt.AES256Util;
import com.whale.challenge.module.validation.annotation.UserPassword;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UserPasswordValidator implements ConstraintValidator<UserPassword, SignUpDto> {

	private final AES256Util aes256Util;

	@SneakyThrows
	@Override
	public boolean isValid(SignUpDto value, ConstraintValidatorContext context) {
		String plainUserPass = aes256Util.decryptAES("", value.getUserPass());
		String plainUserPassConfirm = aes256Util.decryptAES("", value.getUserPassConfirm());

		return plainUserPass.equals(plainUserPassConfirm);
	}
}
