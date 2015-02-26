package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import quiz.*;

/**
 * 
 * @author Sergio
 * The remote interface for the QuizServer object which will be placed in the registry for clients to use
 * 
 */
public interface QuizRemoteInterface extends Remote {
	/**
	 * Adds a quiz to the quizList and flushes the new quizList to a file
	 */
	public boolean addQuiz(Quiz quizToAdd, int id) throws RemoteException;
	/**
	 *  Checks whether a quiz is currently being played. If it isn't, it can be deleted and returns true. Otherwise it isn't deleted and returns false
	 *  @param - the id of the quiz to be deleted
	 *  @return - true if the quiz was deleted, false otherwise
	 */
	public boolean deleteQuiz(int id) throws RemoteException;
	 /**
	  *  @param - the id of the requested quiz
	  *  @return - the requested Quiz
	  */
	public Quiz getQuiz(int id) throws RemoteException;
	/**
	 * Creates a unique ID to assign to a new Quiz created by the user. Iterates over the existing
	 * ID's and finds the smallest number which isn't already being used as an ID
	 */
	public int createQuizId() throws RemoteException;
	/**
	 * Creates a String array where each Quiz in the Quiz Server 
	 * is represented by a string consisting of its QuizName and QuizId
	 * It is used by the playerClient to display the available quizzes in a JList
	 */
	public String[] getEachQuizString() throws RemoteException;
	/**
	 * Adds the record of a player Attempt to a quiz
	 * @param - highScore - the data about a Player Attempt to be added
	 * @param id - the id for the quiz that was played
	 */
	public void addHighScore(PlayerAttempt highScore, int id) throws RemoteException;
	/**
	 * Adds the id of a quiz to list of quizzes currently being played
	 */
	public void addCurrentlyBeingPlayedQuiz(Integer id) throws RemoteException;
	/**
	 * removes an id for a quiz from the list of quizzes currently being played once a user has finished playing
	 */
	public void removeCurrentlyBeingPlayedQuiz(Integer id) throws RemoteException;
}
