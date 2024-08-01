package com.management.HealthCare.AuthenticationConfig.Utilities;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGenarator {
	
	
	public static KeyPair generateKeypair() {
		KeyPair key;
		try {
			KeyPairGenerator gen=KeyPairGenerator.getInstance("RSA");
			gen.initialize(2048);
			key= gen.generateKeyPair();
		}catch (Exception e) {
			throw new IllegalAccessError();
		}
		return key;
		
	}

}
