package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import client.PlayerClient;

public class SelectQuizFrame extends JFrame {

	private JPanel contentPane;
	private PlayerClient client;
	private JFrame frame;

	public SelectQuizFrame(PlayerClient client){
		this.client = client;
	}

	/**
	 * Create the frame.
	 */
	public void launch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(41, 33, 285, 336);
		contentPane.add(comboBox);
		
		JButton playQuizButton = new JButton("Play Quiz");
		playQuizButton.setForeground(Color.RED);
		playQuizButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		playQuizButton.setBounds(395, 47, 159, 70);
		contentPane.add(playQuizButton);
		
		JButton deleteQuizButton = new JButton("Delete Quiz");
		deleteQuizButton.setForeground(Color.RED);
		deleteQuizButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deleteQuizButton.setBounds(395, 164, 159, 70);
		contentPane.add(deleteQuizButton);
		
		JButton viewHighScoresButton = new JButton("View High Scores");
		viewHighScoresButton.setForeground(Color.RED);
		viewHighScoresButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewHighScoresButton.setBounds(395, 276, 159, 70);
		contentPane.add(viewHighScoresButton);
		
		frame.setVisible(true);
	}
}
