package gui;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import client.*;

/*
 * A GUI which allows the user to enter the name of a new Quiz
 */
public class NamingQuizGui {
	private SetUpClient client;
	private JFrame frame;
	private JTextField textField;
	
	public NamingQuizGui(SetUpClient client) {
		this.client = client;
	}

	/**
	 * Creates the main JFrame and its components. Includes a JTextField for the user
	 * to enter the QuizName, a button for the user to click once they've finished and a 
	 * JLabel containing instructions for the user
	 */
	public void launch() {
		frame = new JFrame();
		frame.setBounds(100, 100, 606, 455);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel enterNameLabel = new JLabel("Please enter a name\r\n for your Quiz: ");
		enterNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		enterNameLabel.setForeground(Color.RED);
		enterNameLabel.setBounds(32, 72, 418, 116);
		frame.getContentPane().add(enterNameLabel);
		
		textField = new JTextField();
		textField.setBounds(55, 191, 478, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.setForeground(Color.RED);
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNext.setBounds(336, 303, 200, 50);
		btnNext.addActionListener(new NextButtonActionListener());
		frame.getContentPane().add(btnNext);
		
		frame.setVisible(true);
	}
	

	/**
	 * If the user clicks the nextButton, first the actionListener checks that the user
	 * has actually entered some input, then invokes the SetUpClient method for 
	 * creating a new Quiz object with the name entered by the user. Disposes this frame
	 * and invokes the SetUpClient to launch the GUI for getting questions for the Quiz
	 */
	class NextButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if ((textField.getText()).length() > 0 ){
				client.createQuiz(textField.getText());
				frame.setVisible(false);
				frame.dispose();
				client.getQuizQuestions();
			}
			else{
				JOptionPane.showMessageDialog(null, "Please enter a Quiz Name");
			}
		}
	}

	
}
