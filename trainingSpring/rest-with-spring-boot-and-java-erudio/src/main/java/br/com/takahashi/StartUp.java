package br.com.takahashi;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm;

@SpringBootApplication
public class StartUp {

	public static void main(String[] args) {
		SpringApplication.run(StartUp.class, args);
		
//		Map<String, PasswordEncoder> encoders = new HashedMap();
//		encoders.put("pbkdf2", new Pbkdf2PasswordEncoder("", 8, 185000, SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256));
//		DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
//		passwordEncoder.setDefaultPasswordEncoderForMatches(new Pbkdf2PasswordEncoder("", 8, 185000, SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256));
//		String result = passwordEncoder.encode("admin1234");
//		System.out.println("mY HASH "+ result);
	}

}
