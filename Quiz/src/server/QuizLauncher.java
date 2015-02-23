package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import gui.*;

/**
 * @ author Sergio Lamela
 * This is the class that launches the entire Quiz. It sets up a Quiz Server object on the 
 * registry for clients to call methods on and launches a HomePage GUI which enables the user
 * to either play a Quiz or make a Quiz
 */
public class QuizLauncher {

	public static void main(String[] args) {
		new QuizLauncher().launch();
	}
	public void launch(){
		HomePageGui homePage = new HomePageGui();
		homePage.launch();

		try {
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("quizServer", new QuizServer());
			System.out.println("Server set up completed. Do not close the homepage");
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("Remote Exception occured");
		} 
	}
}
