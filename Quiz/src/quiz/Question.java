package quiz;

public class Question {
	String question;
	String[] answers = new String[4];
	int correctAnswerNumber;
	
	public Question(String question, String[] answers, int correctQuestion){
		this.question = question; 
		this.answers = answers;
		this.correctAnswerNumber = correctQuestion;
	}

}
