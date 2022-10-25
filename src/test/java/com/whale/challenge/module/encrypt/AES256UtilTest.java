package com.whale.challenge.module.encrypt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Base64;

@SpringBootTest
@ActiveProfiles("develop")
class AES256UtilTest {

	@Autowired
	private AES256Util aes256Util;

	private static final String SECRET_KEY = "hVmYq3t6w9y$B&E)H@McQfTjWnZr4u7x";

	@Test
	void decryptAES() throws InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException,
			IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, NoSuchProviderException {
		String decryptedText = "a5qbi+9zIG1bfWLIN7HGLt91e25KtZ9hiJipsm+eZO8BSz/zvIDzrmQRdCFIO/yyQU1/s3LG0+SuT4NqLCLFMg==";
		String plainText = aes256Util.decryptAES(SECRET_KEY, decryptedText);
		Assertions.assertEquals("7YWM7Iqk7Yq4IOyVlO2YuO2ZlCDsp4TtlonsnoXri4jri6Qu", plainText);

		byte[] decodedBytes = Base64.getDecoder().decode(plainText);
		Assertions.assertEquals("테스트 암호화 진행입니다.", new String(decodedBytes));

	}
}