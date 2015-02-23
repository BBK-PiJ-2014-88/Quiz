package quiz;

import java.io.Serializable;

public class Question implements Serializable{
	private String question;
	private String[] answers;
	private int correctAnswerNumber;
	
	public Question(String question, String[] answers, int correctQuestion){
		this.question = question; 
		this.answers = answers;
		this.correctAnswerNumber = correctQuestion;
	}
	public String getQuestion(){
		return this.question;
	}
	public String[] getAnswers(){
		return this.answers;
	}
	public String getCorrectAnswer(){
		return this.answers[correctAnswerNumber];
	}
	public String toString(){
		String answersString = "";
		for (String answer: answers){
			answersString = answersString + " Answer: " +  answer;
		}
		return "Question: " + question + " Answers: " + answersString;
	}
}
