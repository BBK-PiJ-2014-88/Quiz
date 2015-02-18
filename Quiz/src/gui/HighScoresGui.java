package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class HighScoresGui {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public HighScoresGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 494, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("High Scores");
		titleLabel.setForeground(Color.RED);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleLabel.setBackground(Color.YELLOW);
		titleLabel.setBounds(41, 32, 401, 56);
		frame.getContentPane().add(titleLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 300, 359, -186);
		frame.getContentPane().add(scrollPane);
		
		JList list = new JList();
		list.setBounds(79, 275, 340, -149);
		frame.getContentPane().add(list);
		
		JScrollPane listScrollPane = new JScrollPane();
		listScrollPane.setBounds(41, 99, 401, 220);
		frame.getContentPane().add(listScrollPane);
		
		JList highScoresList = new JList();
		listScrollPane.setViewportView(highScoresList);
		highScoresList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		highScoresList.setForeground(Color.BLACK);
		frame.setVisible(true);
	}
}
