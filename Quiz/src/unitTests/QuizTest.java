package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import quiz.*;

import org.junit.*;

public class QuizTest {
	private Quiz testerQuiz;
	private Question question1;
	private Question question2;
	private Question question3;
	
	@Before
	public void buildUp(){
		testerQuiz = new Quiz("Politics Quiz", 1);
		question1 = new Question("Who's the president?", new String[] {"Obama", "Kennedy","Thatcher", "Blair"} ,0);
		question2 = new Question("Who's the priminister?", new String[] {"Obama", "Cameron","Thatcher", "Blair"} ,1);
		question3 = new Question("Who's the queen?", new String[] {"Obama", "Kennedy","Thatcher", "Elizabeth"} ,3);
	}

	@Test
	public void testAddQuestion() {
		testerQuiz.addQuestion(question1);
		testerQuiz.addQuestion(question2);
		testerQuiz.addQuestion(question3);
		ArrayList<Question> answer = new ArrayList<Question>();
		answer.add(question1);
		answer.add(question2);
		answer.add(question3);
		assertEquals(answer, testerQuiz.getQuestions());
	}
	
	@Test
	public void testGetNumberOfQuestions(){
		testerQuiz.addQuestion(question1);
		testerQuiz.addQuestion(question2);
		testerQuiz.addQuestion(question3);
		assertEquals(3, testerQuiz.getNumberOfQuestions());
	}
	
	@Test
	public void testGetId(){
		assertEquals(1, testerQuiz.getQuizId());
	}

}
