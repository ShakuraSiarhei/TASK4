package ru.itransition.task4;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HmacGenerator {
	private final String ALGORITHM = "HmacSHA3-256";
		
	public Key getKey() throws NoSuchAlgorithmException {
		KeyGenerator gameKeyGenerator = KeyGenerator.getInstance(ALGORITHM);
		SecureRandom random = new SecureRandom();
		gameKeyGenerator.init(random);
		SecretKeySpec gameKey = new SecretKeySpec (gameKeyGenerator.generateKey().getEncoded(), ALGORITHM);
		return gameKey;
	}
	public byte[] getHmac(Key key, String computerMove) throws NoSuchAlgorithmException, InvalidKeyException {
		Mac mac = Mac.getInstance(ALGORITHM);
		mac.init(key);
		byte[] hmacSha256 = mac.doFinal(computerMove.getBytes(StandardCharsets.UTF_8));
		return hmacSha256;
	}

}
