package quiz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Quiz implements Serializable {
	private String quizName;
	private int quizId;
	private ArrayList<Question> quizQuestions = new ArrayList<Question>();
	private ArrayList<PlayerAttempt> highScores = new ArrayList<PlayerAttempt>();
	
	public Quiz(String name, int Id){
		this.quizName = name;
		this.quizId = Id;
	}
	public void addQuestion(Question newQuestion){
		this.quizQuestions.add(newQuestion);
	}
	public ArrayList<Question> getQuestions(){
		return this.quizQuestions;
	}	
	public int getNumberOfQuestions(){
		return this.quizQuestions.size();
	}
	public int getQuizId(){
		return this.quizId;
	}
	public void addPlayerAttempt(PlayerAttempt playerAttempt){
		this.highScores.add(playerAttempt);
		Collections.sort(highScores);
	}
	public String getName(){
		return this.quizName;
	}
	public ArrayList<PlayerAttempt>getPlayerAttempts(){
		return highScores;
	}
	
}
