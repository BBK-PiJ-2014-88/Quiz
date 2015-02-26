package unitTests;

import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.rmi.RemoteException;
import org.junit.*;
import client.PlayerClient;
import client.SetUpClient;
import quiz.*;
import server.*;

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
	public void testBothClientsAddAndDelete() throws IllegalArgumentException, IllegalAccessException {
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
		 //setUpClient should have successfully added a quiz to the server
		assertEquals(true, playerClient.doesQuizExist(quizId));
		//test that the playerClient can successfully delete a quiz from the server
		assertEquals(true, playerClient.deleteQuiz(quizId));
		//playerClients doesQuizExist method should now return false
		assertEquals(false, playerClient.doesQuizExist(quizId));
	}
	
	@Test
	public void testCurrentlyBeingPlayedQuizList(){
		setUpClient.createQuiz("test quiz");
		setUpClient.addQuestionToQuiz("what is 2+2", new String[]{"1","2","3","4"},3);
		
		 try { //using reflection to get access to private field in playerClient - the remote server object
			Field field = PlayerClient.class.getDeclaredField("remoteServerObject");
			field.setAccessible(true);
			QuizRemoteInterface serverObject = (QuizRemoteInterface) field.get(playerClient);
			// use the remoteServerObject to see what the id for the next Quiz will be
			int idOfNewQuiz = serverObject.createQuizId(); 
			setUpClient.addQuizToServer(); //add the quiz to the server. The id will be idOfNewQuiz
			//add the quiz to currentlyBeingPlayedList
			serverObject.addCurrentlyBeingPlayedQuiz(idOfNewQuiz);
			//as the quiz is currently being played, it should not be possible to delete it
			assertEquals(false, playerClient.deleteQuiz(idOfNewQuiz));
			//remove the quiz from the currentlyBeingPlayed list
			serverObject.removeCurrentlyBeingPlayedQuiz(idOfNewQuiz);
			//now it should be possible to delete the quiz
			assertEquals(true, playerClient.deleteQuiz(idOfNewQuiz));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
