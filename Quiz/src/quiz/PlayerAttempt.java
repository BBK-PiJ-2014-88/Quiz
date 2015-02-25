package quiz;

import java.io.Serializable;

public class PlayerAttempt implements Comparable, Serializable {
	private String playerName;
	private int score;
	
	public PlayerAttempt(String playerName){
		this.playerName = playerName;
	}

	/**
	 * returns the players score
	 */
	public int getScore(){
		return this.score;
	}
	/**
	 * sets the players score
	 */
	public void setScore(int score){
		this.score = score;
	}
	/**
	 * returns the players name
	 */
	public String getPlayerName(){
		return this.playerName;
	}
	/**
	 * toString method used for testing
	 */
	public String toString(){
		String result = "Playername: " + playerName + " Score: " + score;
		return result;
	}
	/**
	 * Used for storing PlayerAttempts from Highest to Lowest score
	 */
	public int compareTo(Object other){
		PlayerAttempt otherPlayerAttempt = (PlayerAttempt) other;
		return  otherPlayerAttempt.getScore() - this.getScore();
	}
}
