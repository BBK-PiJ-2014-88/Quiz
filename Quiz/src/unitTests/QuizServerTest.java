package unitTests;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import server.QuizServer;
import quiz.*;

public class QuizServerTest {
	private Quiz testerQuiz1;
	private Quiz testerQuiz2;
	private QuizServer serverTester;

	@Before
	public void buildUp(){
		try {
			serverTester = new QuizServer();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		testerQuiz1 = new Quiz("TestQuiz1");
		testerQuiz2 = new Quiz("TestQuiz2");
		Question question1 = new Question("Who's the president?", new String[] {"Obama", "Kennedy","Thatcher", "Blair"} ,0);
		Question question2 = new Question("Who's the priminister?", new String[] {"Obama", "Cameron","Thatcher", "Blair"} ,1);
		Question question3 = new Question("Who's the queen?", new String[] {"Obama", "Kennedy","Thatcher", "Elizabeth"} ,3);
		Question question4 = new Question("Whats manzana in Spanish?", new String[] {"banana", "apple","orange", "bread"} ,1);
		testerQuiz1.addQuestion(question1);
		testerQuiz1.addQuestion(question2);
		testerQuiz2.addQuestion(question3);
		testerQuiz2.addQuestion(question4);
	}
	
	@Test
	public void testAddGetDeleteQuiz() {
		int x = serverTester.createQuizId();
		serverTester.addQuiz(testerQuiz1, x);
		assertEquals(testerQuiz1, serverTester.getQuiz(x));
		assertEquals(serverTester.deleteQuiz(x), true);
	}
	
	@Test
	public void testDeleteCurrentlyBeingPlayedQuiz(){
		serverTester.addQuiz(testerQuiz1, 100);
		serverTester.addCurrentlyBeingPlayedQuiz(100);
		assertEquals(false, serverTester.deleteQuiz(100));
		serverTester.removeCurrentlyBeingPlayedQuiz(100);
		assertEquals(true, serverTester.deleteQuiz(100));
	}

}
