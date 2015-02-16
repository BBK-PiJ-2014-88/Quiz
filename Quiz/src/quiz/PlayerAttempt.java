package quiz;

public class PlayerAttempt {
	private String playerName;
	private int score;
	public String printScore(Quiz quiz, int numberOfCorrectAnswers){
		return (numberOfCorrectAnswers + " / " + quiz.getNumberOfQuestions()); 
	}
}
