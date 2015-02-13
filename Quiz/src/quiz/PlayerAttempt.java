package quiz;

public class PlayerAttempt {
	private String playerName;
	private int score;
	public String calculateScore(Quiz quiz, int numberOfCorrectAnswers){
		return (numberOfCorrectAnswers + " / " + quiz.getNumberOfQuestions()); 
	}
}
