package com.walker.bruteforce;

import java.util.Arrays;

public class BruteForcerDefaults {
	public static PasswordChecker getDefaultChecker(final char[] passchecking){
		return new PasswordChecker(){
			
			public boolean check(char[] string) {
				if(Arrays.equals(string, passchecking))
					return true;
				return false;
			}
			
		};
	}
	
	public static String getLowestCharset(final String examplePassword){
		boolean containsSymbols = containsAny(examplePassword, "{}+/@");
		boolean containsNumbers = containsAny(examplePassword, "0123456789");
		boolean containsUppercase = !examplePassword.toLowerCase().equals(examplePassword);
		if(containsSymbols)
			return Charsets.LOWERCASE_UPPERCASE_NUMBERS_SYMBOLS;
		else if(containsNumbers && containsUppercase)
			return Charsets.LOWERCASE_UPPERCASE_NUMBERS;
		else if(containsUppercase)
			return Charsets.LOWERCASE_UPPERCASE;
		else if(containsNumbers)
			return Charsets.LOWERCASE_NUMBERS;
		else
			return Charsets.LOWERCASE;
	}
	
	private static boolean containsAny(String ref, String contains){
		for(char chara : contains.toCharArray())
			for(char chara2 : ref.toCharArray())
				if(chara == chara2)
					return true;
		return false;
	}
}
