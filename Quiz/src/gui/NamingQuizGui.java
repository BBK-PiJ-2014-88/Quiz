package gui;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import client.*;

public class NamingQuizGui {
	private SetUpClient client;
	private JFrame frame;
	private JTextField textField;
	private String userEnteredQuizName;
	
	public String getUserEnteredQuizName(){
		return this.userEnteredQuizName;
	}

	
	/**
	 * Create the application.
	 */
	public NamingQuizGui(SetUpClient client) {
		this.client = client;
	}

	/**
	 * Initialize the contents of the frame.
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
	

	
	class NextButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if ((textField.getText()).length() > 0 ){
				userEnteredQuizName = textField.getText();
				client.createQuiz(userEnteredQuizName);
			}
			else{
				JOptionPane.showMessageDialog(null, "Please enter a Quiz Name");
			}
		}
	}

	
}
