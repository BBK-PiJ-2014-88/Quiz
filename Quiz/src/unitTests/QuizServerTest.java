package unitTests;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import server.QuizServer;
import quiz.*;

public class QuizServerTest {

	@Before
	public void buildUp(){
		try {
			QuizServer serverTester = new QuizServer();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		Quiz testerQuiz1 = new Quiz("TestQuiz1");
		testerQuiz1.setId(1);
		Quiz testerQuiz2 = new Quiz("TestQuiz2");
		testerQuiz2.setId(2);
		Question question1 = new Question("Who's the president?", new String[] {"Obama", "Kennedy","Thatcher", "Blair"} ,0);
		Question question2 = new Question("Who's the priminister?", new String[] {"Obama", "Cameron","Thatcher", "Blair"} ,1);
		Question question3 = new Question("Who's the queen?", new String[] {"Obama", "Kennedy","Thatcher", "Elizabeth"} ,3);
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
