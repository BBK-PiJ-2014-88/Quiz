package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;

import gui.*;

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
			System.out.println("Server set up completed");
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("Remote Exception occured");
		} 
	}

}
