package client;

import gui.HomePageGui;

/**
 * @ author Sergio Lamela
 * This is the class that launches the HomePageGui from where users can select to launch a PlayerClient or SetUpClient
 *  Multiple SetUpClients and PlayerClients can be launched and operate concurrently 
 */
public class ClientLauncher {

	public static void main(String[] args) {
		new ClientLauncher().launch();
	}
	public void launch(){
		new HomePageGui().launch();
	}
}
