package quiz;

import java.io.Serializable;

public class PlayerAttempt implements Comparable, Serializable {
	private String playerName;
	private int score;
	
	public PlayerAttempt(String playerName){
		this.playerName = playerName;
	}
	/**
	 * toString method used for testing
	 */
	public String toString(){
		String result = "Playername: " + playerName + " Score: " + score;
		return result;
	}
	public String printScore(Quiz quiz, int numberOfCorrectAnswers){
		return (numberOfCorrectAnswers + " / " + quiz.getNumberOfQuestions()); 
	}
	public int getScore(){
		return this.score;
	}
	/**
	 * Used for storing PlayerAttempts from Highest to Lowest score
	 */
	public int compareTo(Object other){
		PlayerAttempt otherPlayerAttempt = (PlayerAttempt) other;
		return  otherPlayerAttempt.getScore() - this.getScore();
	}
	public void setScore(int score){
		this.score = score;
	}
	public String getPlayerName(){
		return this.playerName;
	}
}
