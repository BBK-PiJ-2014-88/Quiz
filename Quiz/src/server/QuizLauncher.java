package server;

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
			reg.bind("quizServer", new QuizServer());
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//set up RMI
	}

}
