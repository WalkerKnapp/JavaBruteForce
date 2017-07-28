package com.walker.bruteforce;

public class WorkerThread extends Thread {
	long attemptsOnThread;
	char[] generator;
	char finalChar;
	
	char[] charset;
	
	boolean stopped;
	
	PasswordChecker checker;
	ResultRunnable result;
	
	/*
	 * Class constructor.
	 * Initializes the {@link PasswordChecker} instance for {@link #bruteForce} instance.
	 * 
	 * @param finalChar The final character to use in this thread's password guesses
	 * @param base The base char array used to generate passwords on.
	 */
	public WorkerThread(char finalChar, char[] base, char[] charset, PasswordChecker checker, ResultRunnable resultRunnable){
		this.generator = base;
		this.finalChar = finalChar;
		this.checker = checker;
		this.result = resultRunnable;
		this.charset = charset;
	}
	
	/*
	 * Runs the brute forcing algorithm.
	 * Returns if password not found.
	 */
	@Override
	public void run(){
		checker.init();
		bruteForce(0);
	}
	
	/*
	 * Runs the brute forcing algorithm based on a starting point.
	 * Will call itself until it reaches the second to last character.
	 * At the second to last character, it will iterate through every combination with the last character specified.
	 * Checks passwords with the {@link PasswordChecker}.
	 * 
	 * @param point The starting point for the iteration of the method.
	 */
	private void bruteForce(int point){
		for(char rainbowChar : charset){
			if(stopped)
				break;
			
			if(point < generator.length - 1){
				generator[point] = rainbowChar;
				bruteForce(point + 1);
			}
			else{
				generator[point] = finalChar;
				attemptsOnThread++;
				if(checker.check(generator))
					result.finish(generator);
				return;
			}
		}
	}
	
	/*
	 * Requests the thread to stop at the next iteration of {@link #bruteForce}
	 * 
	 * @return The attempts to guess the password made by this thread.
	 */
	public long finish(){
		stopped = true;
		return attemptsOnThread;
	}
	
	public void setResult(ResultRunnable result){
		this.result = result;
	}
}
