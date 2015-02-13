package gui;

import javax.swing.*;

public class HomePage {

	public static void main(String[] args) {
		new HomePage().launch();
	}
	public void launch(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setVisible(true);
	}

}
