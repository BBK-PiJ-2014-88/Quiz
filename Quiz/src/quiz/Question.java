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
	/**
	 * returns the question
	 */
	public String getQuestion(){
		return this.question;
	}
	/**
	 * returns the 4 possible answers
	 */
	public String[] getAnswers(){
		return this.answers;
	}
	/**
	 * returns the correct answer
	 */
	public String getCorrectAnswer(){
		return this.answers[correctAnswerNumber];
	}
	/**
	 * toString method, used for testing purposes
	 */
	public String toString(){
		String answersString = "";
		for (String answer: answers){
			answersString = answersString + " Answer: " +  answer;
		}
		return "Question: " + question + " Answers: " + answersString;
	}
}
