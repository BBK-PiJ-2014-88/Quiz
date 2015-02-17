package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.QuizRemoteInterface;
import gui.*;
import quiz.*;

public class PlayerClient {
	private QuizRemoteInterface remoteServerObject; 
	private PlayerAttempt newPlayerAttempt;
	
	public void launch(){
		connectToServer();
		SelectQuizFrame selectQuizGui = new SelectQuizFrame(this, getListItems());
		selectQuizGui.launch();
	}
	/*
	 * Gets all the Quizzes stored in the Quiz Server and creates a String array
	 * of Quiz names and their id's to be sent as parameters to the JList in the selectGuizGui
	 * where the user can select a Quiz
	 */
	public String[] getListItems(){
		String[] result = null;
		try {
			result = remoteServerObject.getEachQuizString();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;	
	}
	public boolean deleteQuiz(int id){
		boolean result = false;
		try {
			result = remoteServerObject.deleteQuiz(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
	

	public boolean connectToServer(){
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			remoteServerObject = (QuizRemoteInterface) reg.lookup("quizServer");
			System.out.println(remoteServerObject.createQuizId());
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
