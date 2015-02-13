package client;

import java.rmi.RemoteException;
import java.rmi.registry.*;


public class SetUpClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//will connect to Server object on registry. 
		//after making a quiz, will call ServerObject.saveQuiz()
	}
	public void launch(){
		try {
			Registry reg = LocateRegistry.getRegistry("localhost", 1099);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
