package com.walker.bruteforce;

public abstract class PasswordChecker implements Cloneable {
	
	public void init() {
	}
	
	/*
	 * Checks a char array for a password.
	 * 
	 * @param attempt The guessed char array.
	 * @return If the guess was correct;
	 */
	public abstract boolean check(char[] attempt);
	
	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
