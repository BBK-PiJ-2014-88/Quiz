package gui;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;

import client.PlayerClient;



public class HighScoresGui {

	private JFrame frame;
	private PlayerClient client;
	private String[] scoresToDisplay;
	
	public HighScoresGui(PlayerClient client, String[] scoresToDisplay) {
		this.client = client;
		this.scoresToDisplay = scoresToDisplay;
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void launch() {
		frame = new JFrame();
		frame.setBounds(100, 100, 494, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("High Scores");
		titleLabel.setForeground(Color.RED);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleLabel.setBackground(Color.YELLOW);
		titleLabel.setBounds(41, 32, 401, 56);
		frame.getContentPane().add(titleLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(394, 120, -312, 183);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList(scoresToDisplay);
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.BOLD, 12));
		list.setForeground(Color.RED);
		list.setBackground(Color.YELLOW);
		

	
		frame.setVisible(true);
	}
}
