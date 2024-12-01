package com.secret;

public class Encryption {
	public static String encrypt(String email) {
		String encrypted="";
		for(int i=0;i<email.length()-1;i++) {
			
			encrypted+=(char)(email.charAt(i)+2);
		}
		
		return encrypted;
	}
	public static String decrypt(String email) {
		String decrypted="";
		for(int i=0;i<email.length()-1;i++) {
			
			decrypted+=(char)(email.charAt(i)-2);
		}
		
		return decrypted;
	}
}
