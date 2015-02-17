package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import client.PlayerClient;

public class SelectQuizFrame {

	private JFrame frame;
	private PlayerClient client;
	
	public SelectQuizFrame(PlayerClient client) {
		this.client = client;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void launch() {
		frame = new JFrame();
		frame.setBounds(100, 100, 605, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(44, 49, 268, 330);
		frame.getContentPane().add(comboBox);
		
		JButton playQuizButton = new JButton("PLAY");
		playQuizButton.setBackground(Color.YELLOW);
		playQuizButton.setForeground(Color.RED);
		playQuizButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		playQuizButton.setBounds(358, 56, 175, 72);
		frame.getContentPane().add(playQuizButton);
		
		JButton viewScoresButton = new JButton("View High Scores");
		viewScoresButton.setForeground(Color.RED);
		viewScoresButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewScoresButton.setBackground(Color.YELLOW);
		viewScoresButton.setBounds(358, 177, 175, 72);
		frame.getContentPane().add(viewScoresButton);
		
		JButton deleteButton = new JButton("DELETE");
		deleteButton.setForeground(Color.RED);
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deleteButton.setBackground(Color.YELLOW);
		deleteButton.setBounds(358, 294, 175, 72);
		frame.getContentPane().add(deleteButton);
		
		frame.setVisible(true);
	}
}
