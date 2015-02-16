package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class SelectQuizFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectQuizFrame frame = new SelectQuizFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelectQuizFrame() {
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
	}
}
