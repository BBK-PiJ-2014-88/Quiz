package gui;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;

public class HomePage {
	private JFrame frame;
	private JButton makeQuizButton;
	private JButton playQuizButton;
	private JPanel panel;
	public static void main(String[] args) {
		new HomePage().launch();
	}
	public void launch(){
		 
		frame = new JFrame();
		panel = new JPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		makeQuizButton = new JButton("Click here to make a Quiz");
		playQuizButton = new JButton("Click here to play a Quiz");
		PlayQuizButtonListener playQuizListener = new PlayQuizButtonListener();
		MakeQuizButtonListener makeQuizListener = new MakeQuizButtonListener();
		panel.add(BorderLayout.NORTH, makeQuizButton);
		panel.add(BorderLayout.SOUTH, playQuizButton);
		
		makeQuizButton.addActionListener(makeQuizListener);
		playQuizButton.addActionListener(playQuizListener);
		//frame.getContentPane().add(BorderLayout.NORTH, makeQuizButton);
		//frame.getContentPane().add(BorderLayout.SOUTH, playQuizButton);
		frame.getContentPane().add(panel);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	
	class PlayQuizButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			playQuizButton.setText("I've been clicked");
		}
	}
	class MakeQuizButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			makeQuizButton.setText("I've been clicked");
		}
	}

}
