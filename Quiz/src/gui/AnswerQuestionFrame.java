package gui;

import client.PlayerClient;
import quiz.Question;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class AnswerQuestionFrame {
	private JFrame frame;
	private PlayerClient client;
	private Question questionBeingPlayed;

	public AnswerQuestionFrame(PlayerClient client, Question question) {
		this.client = client;
		this.questionBeingPlayed = question;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void launch() {
		frame = new JFrame();
		frame.setBounds(100, 100, 607, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel questionLabel = new JLabel("Question goes here");
		questionLabel.setBackground(Color.YELLOW);
		questionLabel.setForeground(new Color(0, 0, 0));
		questionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		questionLabel.setBounds(40, 71, 517, 65);
		frame.getContentPane().add(questionLabel);
		
		JLabel questionNumberLabel = new JLabel("QuestionNumber");
		questionNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		questionNumberLabel.setBounds(40, 34, 127, 14);
		frame.getContentPane().add(questionNumberLabel);
		
		JButton answer1Button = new JButton("New button");
		answer1Button.setBackground(Color.YELLOW);
		answer1Button.setForeground(Color.RED);
		answer1Button.setBounds(82, 200, 159, 78);
		frame.getContentPane().add(answer1Button);
		
		JButton answer2Button = new JButton("New button");
		answer2Button.setForeground(Color.RED);
		answer2Button.setBackground(Color.YELLOW);
		answer2Button.setBounds(357, 200, 159, 78);
		frame.getContentPane().add(answer2Button);
		
		JButton answer3Button = new JButton("New button");
		answer3Button.setForeground(Color.RED);
		answer3Button.setBackground(Color.YELLOW);
		answer3Button.setBounds(82, 311, 159, 78);
		frame.getContentPane().add(answer3Button);
		
		JButton answer4Button = new JButton("New button");
		answer4Button.setForeground(Color.RED);
		answer4Button.setBackground(Color.YELLOW);
		answer4Button.setBounds(357, 311, 159, 78);
		frame.getContentPane().add(answer4Button);
		
		JLabel lblPleaseSelectAn = new JLabel("Please select an answer from the options below");
		lblPleaseSelectAn.setBackground(Color.YELLOW);
		lblPleaseSelectAn.setForeground(Color.RED);
		lblPleaseSelectAn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPleaseSelectAn.setBounds(50, 147, 429, 40);
		frame.getContentPane().add(lblPleaseSelectAn);
		
		frame.setVisible(true);
	}
}
