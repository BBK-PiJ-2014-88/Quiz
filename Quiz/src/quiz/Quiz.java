package quiz;

import java.util.ArrayList;

public class Quiz {
	String quizName;
	int quizId;
	ArrayList<Question> quizQuestions = new ArrayList<Question>();
	
	public Quiz(String name){
		this.quizName = name;
	}
	public void addQuestion(Question newQuestion){
		this.quizQuestions.add(newQuestion);
	}
	
	public int getNumberOfQuestions(){
		return this.quizQuestions.size();
	}
	
	
}
