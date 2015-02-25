package unitTests;

import static org.junit.Assert.*;
import java.lang.reflect.Field;
import org.junit.*;
import client.PlayerClient;
import client.SetUpClient;
import server.ServerLauncher;
import quiz.*;

public class SetUpClientPlayerClientTest {
	ServerLauncher launcher;
	SetUpClient setUpClient;
	PlayerClient playerClient;
	
	@Before
	public void buildUp(){
		launcher = new ServerLauncher();
		launcher.launch(); //launch the server on the registry
		setUpClient = new SetUpClient();
		setUpClient.connectToServer(); 
		playerClient = new PlayerClient();
		playerClient.connectToServer();
	}
	
	@Test
	public void test() throws IllegalArgumentException, IllegalAccessException {
		//create a quiz
		Quiz testerQuiz = new Quiz("test quiz");
		Question question1 = new Question("what is 2+2", new String[]{"1","2","3","4"},3);
		testerQuiz.addQuestion(question1);
		
		setUpClient.createQuiz("test quiz");
		setUpClient.addQuestionToQuiz("what is 2+2", new String[]{"1","2","3","4"},3);
		setUpClient.addQuizToServer(); //setUpClient adds a quiz to the server
		//using playerClients doesQuizExist method to check whether the setUpClient successfully added
		//a quiz to the server. Need the id of the Quiz to check if it exists. This is a private field
		//in Quiz so i use reflection to obtain it
		int quizId = 0;
		 try { 
			Field field = SetUpClient.class.getDeclaredField("newQuiz");
			field.setAccessible(true);
			Quiz value = (Quiz) field.get(setUpClient);
			quizId = value.getQuizId();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		assertEquals(true, playerClient.doesQuizExist(quizId));
		//test that the playerClient can successfully delete a quiz from the server
		assertEquals(true, playerClient.deleteQuiz(quizId));
		//playerClients doesQuizExist method should not return false
		assertEquals(false, playerClient.doesQuizExist(quizId));
		
	}

}
