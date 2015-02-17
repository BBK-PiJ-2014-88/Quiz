package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import client.PlayerClient;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class SelectQuizFrame {

	private JFrame frame;
	private PlayerClient client;
	private String[] availableQuizzes;
	
	public SelectQuizFrame(PlayerClient client, String[] availableQuizzes) {
		this.client = client;
		if (availableQuizzes.length != 0){
			this.availableQuizzes = availableQuizzes;
		}
		else{
			this.availableQuizzes = new String[1];
			this.availableQuizzes[0] = "There are no available Quizzes";
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void launch() {
		frame = new JFrame();
		frame.setBounds(100, 100, 605, 472);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton playQuizButton = new JButton("PLAY");
		playQuizButton.setBackground(Color.YELLOW);
		playQuizButton.setForeground(Color.RED);
		playQuizButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		playQuizButton.setBounds(358, 76, 175, 72);
		frame.getContentPane().add(playQuizButton);
		
		JButton viewScoresButton = new JButton("View High Scores");
		viewScoresButton.setForeground(Color.RED);
		viewScoresButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewScoresButton.setBackground(Color.YELLOW);
		viewScoresButton.setBounds(358, 200, 175, 72);
		frame.getContentPane().add(viewScoresButton);
		
		JButton deleteButton = new JButton("DELETE");
		deleteButton.setForeground(Color.RED);
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deleteButton.setBackground(Color.YELLOW);
		deleteButton.setBounds(358, 320, 175, 72);
		frame.getContentPane().add(deleteButton);
		
		JLabel instructionToUserLabel = new JLabel("SELECT A QUIZ");
		instructionToUserLabel.setBackground(Color.YELLOW);
		instructionToUserLabel.setForeground(Color.RED);
		instructionToUserLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		instructionToUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		instructionToUserLabel.setBounds(44, 27, 268, 25);
		frame.getContentPane().add(instructionToUserLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 75, 298, 317);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList(availableQuizzes);
		scrollPane.setViewportView(list);
		
		frame.setVisible(true);
	}
}
