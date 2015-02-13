package gui;

import java.awt.BorderLayout;
import javax.swing.*;

public class HomePage {
	public static void main(String[] args) {
		new HomePage().launch();
	}
	public void launch(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton makeQuizButton = new JButton("Click here to make a Quiz");
		JButton playQuizButton = new JButton("Click here to play a Quiz");
		frame.getContentPane().add(BorderLayout.NORTH, makeQuizButton);
		frame.getContentPane().add(BorderLayout.SOUTH, playQuizButton);
		frame.setSize(500,500);
		frame.setVisible(true);
	}

}
