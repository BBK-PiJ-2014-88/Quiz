package quiz;

import java.util.ArrayList;

public class Quiz {
	String quizName;
	int quizId;
	ArrayList<Question> quizQuestions = new ArrayList<Question>();
	
	
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
	
}
