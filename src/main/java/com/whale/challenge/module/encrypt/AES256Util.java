package com.whale.challenge.module.encrypt;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

@Component
public class AES256Util {

	private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";

	@PostConstruct
	public void init() {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
	}

	public String decryptAES(String key, String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException,
			InvalidAlgorithmParameterException, InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException {
		String plainText = "";

		if ((key == null) || key.length() == 0 || (cipherText == null) || cipherText.length() == 0) {
			return plainText;
		}

		if ((key.length() != 16) && (key.length() != 24) && (key.length() != 32)) {
			return plainText;
		}

		byte[] keyBytes = key.getBytes(UTF_8);
		byte[] cipherTextBytes = Base64.decodeBase64(cipherText.getBytes(UTF_8));
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
//		int blockSize = cipher.getBlockSize();
//		IvParameterSpec ivParamSpec = new IvParameterSpec(Arrays.copyOfRange(keyBytes, 0, blockSize));
//
		SecretKeySpec secureKey = new SecretKeySpec(keyBytes, "AES");
//		cipher.init(Cipher.DECRYPT_MODE, secureKey, ivParamSpec);
		cipher.init(Cipher.DECRYPT_MODE, secureKey);
		byte[] decrypted = cipher.doFinal(cipherTextBytes);

		plainText = new String(decrypted, UTF_8);
		return plainText;
	}

	public String encryptAES(String key, String plainText) throws NoSuchPaddingException, NoSuchAlgorithmException,
			InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException {
		String cipherText = "";

		if ((key == null) || key.length() == 0 || (plainText == null) || plainText.length() == 0) {
			return cipherText;
		}

		// 키의 길이는 16, 24, 32 만 지원
		if ((key.length() != 16) && (key.length() != 24) && (key.length() != 32)) {
			return cipherText;
		}

		byte[] keyBytes = key.getBytes(UTF_8);
		byte[] plainTextBytes = plainText.getBytes(UTF_8);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM, "BC");
		int blockSize = cipher.getBlockSize();
		IvParameterSpec ivParamSpec = new IvParameterSpec(Arrays.copyOfRange(keyBytes, 0, blockSize));

		SecretKeySpec secureKey = new SecretKeySpec(keyBytes, "AES");
		cipher.init(Cipher.ENCRYPT_MODE, secureKey, ivParamSpec);
		byte[] encrypted = cipher.doFinal(plainTextBytes);

		cipherText = Base64.encodeBase64URLSafeString(encrypted);
		return cipherText;
	}

}
