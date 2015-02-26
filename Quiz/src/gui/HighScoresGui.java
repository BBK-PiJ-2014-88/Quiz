package gui;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import client.PlayerClient;

public class HighScoresGui {

	private JFrame frame;
	private PlayerClient client;
	private String[] scoresToDisplay;
	private JList list;
	
	public HighScoresGui(PlayerClient client, String[] scoresToDisplay) {
		this.client = client;
		this.scoresToDisplay = scoresToDisplay;
	}

	/**
	 * Sets up the GUI. Includes a JList that displays all the scores, a Scrollpane for scrolling through the scores and a JLabel title
	 */
	public void launch() {
		frame = new JFrame();
		frame.setBounds(100, 100, 605, 472);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("High Scores");
		titleLabel.setBounds(41, 32, 401, 56);
		titleLabel.setForeground(Color.RED);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleLabel.setBackground(Color.YELLOW);
		frame.getContentPane().add(titleLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 75, 298, 317);
		frame.getContentPane().add(scrollPane);
		
		list = new JList(scoresToDisplay);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		frame.setVisible(true);
		
	}
}
