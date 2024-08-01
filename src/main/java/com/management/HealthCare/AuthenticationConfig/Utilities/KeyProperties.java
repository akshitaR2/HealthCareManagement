package com.management.HealthCare.AuthenticationConfig.Utilities;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.stereotype.Component;

@Component
public class KeyProperties {

	private RSAPrivateKey privateKey;
	private RSAPublicKey publickey;
	
	
	public KeyProperties() {
		KeyPair pair = KeyGenarator.generateKeypair(); 
		this.privateKey = (RSAPrivateKey) pair.getPrivate();
		this.publickey = (RSAPublicKey) pair.getPublic();
	}


	public RSAPrivateKey getPrivateKey() {
		return privateKey;
	}


	public void setPrivateKey(RSAPrivateKey privateKey) {
		this.privateKey = privateKey;
	}


	public RSAPublicKey getPublickey() {
		return publickey;
	}


	public void setPublickey(RSAPublicKey publickey) {
		this.publickey = publickey;
	}
	
	
	
}
