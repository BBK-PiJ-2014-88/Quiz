package quiz;

public class PlayerAttempt implements Comparable {
	private String playerName;
	private int score;
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
}
