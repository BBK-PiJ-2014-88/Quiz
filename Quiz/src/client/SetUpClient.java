package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.util.Arrays;
import gui.*;
import server.*;
import quiz.*;

public class SetUpClient {
	private Quiz newQuiz; //the new Quiz being created by the user
	private QuizRemoteInterface remoteServerObject; //the remote server object in the registry
	
	/**
	 * Makes a connection with the remote QuizServer object on the registry
	 * and then launches the GUI for a user to enter a Quiz name
	 */
	public void launch(){
		connectToServer();
		new NamingQuizGui(this).launch();
	}
	/**
	 * Creates a Quiz Object with a user supplied name
	 * Involves invoking createQuizId() method on the QuizServer
	 */
	public void createQuiz(String quizName){
			newQuiz = new Quiz(quizName);
			System.out.println("Successfully created a quiz with the name: " + quizName);
	}
	/**
	 * Adds a Quiz to the Quiz Server so a PlayerClient can play the quiz
	 */
	public void addQuizToServer(){
		try {
			newQuiz.setId(remoteServerObject.createQuizId());
			remoteServerObject.addQuiz(newQuiz, newQuiz.getQuizId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
	 * launches the GUI for a user to enter a  Question
	 */
	public void getQuizQuestions(){
		new EnterQuestionFrame(this).launch();
	}
	/**
	 * @param the question
	 * @param the answers 
	 * @param the correctAnswer int
	 * adds a Question Object to the Quiz
	 */
	public void addQuestionToQuiz(String question, String[] answers, int correctAnswer){
		this.newQuiz.addQuestion(new Question(question, answers, correctAnswer));
		System.out.println("Successfully added a Question with question: " + question + " Answers: + " + Arrays.toString(answers) + " Correct answer: " + correctAnswer);
	}
	/**
	 * Locates the Quiz Server object on the registry so methods can be invoked on it
	 */
	public void connectToServer(){
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			remoteServerObject = (QuizRemoteInterface) reg.lookup("quizServer");
			System.out.println("SetupClient Successfully connected to server");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
