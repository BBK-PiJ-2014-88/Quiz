package gui;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;

import client.PlayerClient;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;



public class HighScoresGui {

	private JFrame frame;
	private PlayerClient client;
	private String[] scoresToDisplay;
	private JComboBox comboBox;
	
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
		titleLabel.setBounds(41, 32, 401, 56);
		titleLabel.setForeground(Color.RED);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		titleLabel.setBackground(Color.YELLOW);
		frame.getContentPane().add(titleLabel);
		
		comboBox = new JComboBox(scoresToDisplay);
		comboBox.setBounds(41, 99, 381, 224);
		frame.getContentPane().add(comboBox);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{titleLabel}));
		

	
		frame.setVisible(true);
	}
}
