package com.walker.bruteforce;

public class BruteForcerResult {
	private String answer;
	private long attempts;
	private long timeTaken;
	
	public BruteForcerResult(String result, long attempts, long timeTaken){
		this.answer = result;
		this.attempts = attempts;
		this.timeTaken = timeTaken;
	}
	
	public long getRate(){
		try{
		return this.attempts / (this.timeTaken / 1000l);
		}
		catch(ArithmeticException e){
			//e.printStackTrace();
			return 0;
		}
	}
	
	public String getAnswer(){
		return this.answer;
	}
	
	public long getAttempts(){
		return this.attempts;
	}
	
	public long getTimeTaken(){
		return this.timeTaken;
	}
}
