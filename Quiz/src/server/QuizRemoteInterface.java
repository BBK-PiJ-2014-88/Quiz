package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import quiz.*;

/**
 * 
 * @author Sergio
 * The remote interface for the QuizServer object which will be placed in the registry for clients to use
 * 
 */
public interface QuizRemoteInterface extends Remote {
	public boolean addQuiz(Quiz quizToAdd, int id) throws RemoteException;
	public boolean deleteQuiz(int id) throws RemoteException;
	public Quiz getQuiz(int id) throws RemoteException;
	public int createQuizId() throws RemoteException;
	public String[] getEachQuizString() throws RemoteException;
	public void addHighScore(PlayerAttempt highScore, int id) throws RemoteException;
	public void addCurrentlyBeingPlayedQuiz(Integer id);
	public void removeCurrentlyBeingPlayedQuiz(Integer id);
	public ArrayList<Integer> getCurrentlyBeingPlayedQuizList();
}
