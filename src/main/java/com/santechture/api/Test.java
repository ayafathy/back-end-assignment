package com.santechture.api;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	 public static void main(String[] args) {
		 BCryptPasswordEncoder BCryptPasswordEncoder  =new BCryptPasswordEncoder ();
		System.out.println(BCryptPasswordEncoder.encode("p@ssw0rd"));
	    }

	

}
