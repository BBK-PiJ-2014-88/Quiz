package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

import server.*;


public class SetUpClient {

	public static void main(String[] args) {
		new SetUpClient().launch();
		// TODO Auto-generated method stub
		//will connect to Server object on registry. 
		//after making a quiz, will call ServerObject.saveQuiz()
	}
	public void launch(){
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
			QuizRemoteInterface remoteServerObject = (QuizRemoteInterface) reg.lookup("quizServer");
			System.out.println(remoteServerObject.createQuizId());
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
