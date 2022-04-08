package com.deborateste.gerenciadorLivros.security;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Cripto {

	public static String encrypt(String original) throws Exception{
		
		String chaveStr = "t3st4nd0 c0m um4 ch4v3 a4l34t0r1";
		Key minhaChave = new SecretKeySpec(chaveStr.getBytes(), "AES");
		
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, minhaChave);
		cipher.update(original.getBytes());
		return new String(cipher.doFinal(), "UTF-8");
	}
}
