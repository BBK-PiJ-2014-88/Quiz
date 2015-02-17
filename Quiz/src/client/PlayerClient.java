package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.QuizRemoteInterface;
import gui.*;

public class PlayerClient {
	private QuizRemoteInterface remoteServerObject; 
	
	public void launch(){
		connectToServer();
		SelectQuizFrame selectQuizGui = new SelectQuizFrame(this);
		selectQuizGui.launch();
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
