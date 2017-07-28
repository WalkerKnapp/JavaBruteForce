package com.walker.example;

import java.security.NoSuchAlgorithmException;

import com.walker.bruteforce.BruteForcer;
import com.walker.bruteforce.BruteForcerResult;
import com.walker.bruteforce.Charsets;

public class Example {
		
	public static void main(String[] args) throws InterruptedException, NoSuchAlgorithmException{
		if(args.length < 1){
			System.err.println("Syntax: java -jar bruteforce.jar <password>");
		}
			
		BruteForcer bruteForcer = new BruteForcer(3, 10, Charsets.LOWERCASE_UPPERCASE_NUMBERS, new HashChecker(args[0], "MD5"));
		
		BruteForcerResult result = bruteForcer.run();
		
		System.out.println("The password was found! It was: " + result.getAnswer() + " after " + String.valueOf(result.getAttempts()) + " attempts and " + String.valueOf(result.getTimeTaken()) + " milliseonds at an average rate " + String.valueOf(result.getRate()) + " passwords per second.");
	}
}
