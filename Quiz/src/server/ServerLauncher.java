package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

/**
 * @ author Sergio Lamela
 * This is the class that launches the Quiz Server. It sets up a Quiz Server object on the 
 * registry for clients to call methods on. 
 */
public class ServerLauncher {

	public static void main(String[] args) {
		new ServerLauncher().launch();
	}
	public void launch(){

		try {
			Registry reg = LocateRegistry.createRegistry(1099);
			reg.rebind("quizServer", new QuizServer());
			System.out.println("Server set up completed.");
		} 
		catch (RemoteException e) {
	        Registry reg;
			try {
				reg = LocateRegistry.getRegistry(1099);
				reg.rebind("quizServer", new QuizServer());
				System.out.println("Server has already been set up. Port 1099 already in use");
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		} 
	}
}
