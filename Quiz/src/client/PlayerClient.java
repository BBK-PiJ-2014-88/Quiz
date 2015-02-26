package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

import server.QuizRemoteInterface;
import gui.*;
import quiz.*;

public class PlayerClient {
	private QuizRemoteInterface remoteServerObject; //the remote server Object on the registry
	private PlayerAttempt newPlayerAttempt; 
	private Quiz quizBeingPlayed;
	private int playerScore;
	private int questionNumber = 0;
	
	
	/**
	 * Connects with the server object on the registry and launches the GUI for selecting a Quiz to play
	 */
	public void launch(){
		connectToServer();
		new SelectQuizFrame(this, getAvailableQuizzes()).launch();
	}
	/*
	 * Gets all the Quizzes stored in the Quiz Server and creates a String array
	 * of Quiz names and their id's to be sent as parameters to the JList in the selectGuizGui
	 * where the user can select a Quiz
	 */
	public String[] getAvailableQuizzes(){
		String[] result = null;
		try {
			result = remoteServerObject.getEachQuizString();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;	
	}
	
	/**
	 * @param id - the id of the quiz to delete
	 * @return - boolean, true if the operation was successful
	 */
	public boolean deleteQuiz(int id){
		boolean result = false;
		try {
			result = remoteServerObject.deleteQuiz(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * @param name - the name of the player
	 * @param quizId - the id of the quiz the player wants to play
	 * creates a new playerAttempt for the player and their selected quiz. 
	 */
	public void createPlayerAttempt(String name, int quizId){
		newPlayerAttempt = new PlayerAttempt(name);
		try {
			quizBeingPlayed = remoteServerObject.getQuiz(quizId);
			remoteServerObject.addCurrentlyBeingPlayedQuiz(quizId);
			playNextQuestion();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Launches the GUI for a user to answer a question
	 * Once all questions in a Quiz have been answered, displays a final message with the player score and saves the results to the server
	 */
	public void playNextQuestion(){
		if (questionNumber < quizBeingPlayed.getNumberOfQuestions()){
			Question question = quizBeingPlayed.getQuestions().get(questionNumber);
			new AnswerQuestionFrame(this, question, questionNumber +1).launch();
			questionNumber++;
		}
		else{
			displayFinalMessage();
			addPlayerAttemptToServer();
			removeQuizFromCurrentlyBeingPlayedQuizList();
		}
	}
	/**
	 * removes the Quiz from the list of currentlyBeingPlayedQuizzes
	 */
	public void removeQuizFromCurrentlyBeingPlayedQuizList(){
		try{
			remoteServerObject.removeCurrentlyBeingPlayedQuiz(quizBeingPlayed.getQuizId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
	 * adds a new PlayerAttempt to the server
	 */
	public void addPlayerAttemptToServer(){
		newPlayerAttempt.setScore(playerScore);
		try {
			remoteServerObject.addHighScore(newPlayerAttempt, quizBeingPlayed.getQuizId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
	 * displays a JOptionPane to the user showing their final score
	 */
	public void displayFinalMessage(){
		JOptionPane.showMessageDialog(null, "Congratulations, your score was: " + playerScore + " out of " + quizBeingPlayed.getNumberOfQuestions());
	}
	
	/**
	 * increases the playerScore by 1
	 */
	public void increasePlayerScore(){
		playerScore++;
	}
	/**
	 * returns true if the quiz with the supplied id exists, false otherwise
	 * This method is used by the action Listeners of the 3 buttons for playing, deleting or viewing the high scores of a quiz
	 * One client could be viewing a list of available quizzes, whilst another concurrent client may delete a quiz on that list
	 * Therefore, this method is called by the actionListeners first to make sure one of the available quizzes being displayed
	 * hasn't been deleted by a concurrent client
	 */
	public boolean doesQuizExist(int id){
		try {
			if (remoteServerObject.getQuiz(id) == null){
				return false;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return true;
	}
	/**
	 * @param - the id for the quiz the user wants to see the high scores of
	 * Launches the GUI for viewing high scores. Involves creating a String array of high Scores as parameter for a JList 
	 */
	public void displayHighScore(int id){
		Quiz quizWithScores;
		try {
			quizWithScores = remoteServerObject.getQuiz(id);
			String[] scoresToDisplay = new String[quizWithScores.getPlayerAttempts().size()];
			int position = 0;
			for (PlayerAttempt attempt: quizWithScores.getPlayerAttempts()){
				scoresToDisplay[position] = "Player name: " + attempt.getPlayerName() + " Score: " + attempt.getScore() + " / " + quizWithScores.getNumberOfQuestions();
				position++;
			}
			new HighScoresGui(this, scoresToDisplay).launch();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * connects to the QuizServer on the registry
	 */
	public void connectToServer(){
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			remoteServerObject = (QuizRemoteInterface) reg.lookup("quizServer");
			System.out.println("PlayerClient successfully connected to server");
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("PlayerClient Connection failed. Please set up the server first");
		} catch (NotBoundException e) {
			e.printStackTrace();
			System.out.println("PlayerClient Connection failed. Please set up the server first");
		}
	}
}