package quiz;

import java.io.Serializable;

public class PlayerAttempt implements Comparable, Serializable {
	private String playerName;
	private int score;
	public PlayerAttempt(String playerName){
		this.playerName = playerName;
	}
	public String printScore(Quiz quiz, int numberOfCorrectAnswers){
		return (numberOfCorrectAnswers + " / " + quiz.getNumberOfQuestions()); 
	}
	public int getScore(){
		return this.score;
	}
	public int compareTo(Object other){
		PlayerAttempt otherPlayerAttempt = (PlayerAttempt) other;
		//Stores PlayerAttempts from Highest to Lowest score
		return  otherPlayerAttempt.getScore() - this.getScore();
	}
	public void setScore(int score){
		this.score = score;
	}
	public String getPlayerName(){
		return this.playerName;
	}
}
