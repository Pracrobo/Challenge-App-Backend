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

@SpringBootTest
@ActiveProfiles("develop")
class AES256UtilTest {

	@Autowired
	private AES256Util aes256Util;

	private static final String SECRET_KEY = "hVmYq3t6w9y$B&E)H@McQfTjWnZr4u7x";

	@Test
	void decryptAES() throws InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException,
			IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, NoSuchProviderException {
		String decryptedText = "w3d4vCQs4xn8qnxmAHGf7w==";

		String plainText = aes256Util.decryptAES(SECRET_KEY, decryptedText);
		Assertions.assertEquals("dGVzdA==", plainText);

	}
}