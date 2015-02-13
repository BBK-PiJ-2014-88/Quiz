package server;

import gui.*;

public class QuizLauncher {

	public static void main(String[] args) {
		new QuizLauncher().launch();
	}
	public void launch(){
		HomePageGui homePage = new HomePageGui();
		homePage.launch();
		//set up RMI
	}

}
