package com.walker.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.walker.bruteforce.PasswordChecker;

public class HashChecker extends PasswordChecker {
	
	byte[] hashArray;
	MessageDigest digest;
	
	String encoding;
	
	public HashChecker(String hash, String encoding){
		hashArray = hexStringToByteArray(hash);
		this.encoding = encoding;
	}
	
	@Override
	public void init(){
		try {
			digest = MessageDigest.getInstance(encoding);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean check(char[] string){
		if(Arrays.equals(hashArray, digest.digest(new String(string).getBytes())))
			return true;
		return false;
	}
	
	private static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
}
