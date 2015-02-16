package gui;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import client.*;

public class NamingQuizGui {
	private SetUpClient client;
	private JFrame frame;
	private JTextField textField;
	



	/**
	 * Create the application.
	 */
	public NamingQuizGui(SetUpClient client) {
		this.client = client;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 606, 455);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPleaseEnterA = new JLabel("Please enter a name\r\n for your Quiz: ");
		lblPleaseEnterA.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPleaseEnterA.setForeground(Color.RED);
		lblPleaseEnterA.setBounds(32, 72, 418, 116);
		frame.getContentPane().add(lblPleaseEnterA);
		
		textField = new JTextField();
		textField.setBounds(55, 191, 478, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.setForeground(Color.RED);
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNext.setBounds(336, 303, 200, 50);
		frame.getContentPane().add(btnNext);
		
		frame.setVisible(true);
		
	
	}
}
