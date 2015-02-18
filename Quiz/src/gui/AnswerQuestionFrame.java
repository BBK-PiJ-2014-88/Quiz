package gui;

import client.PlayerClient;
import quiz.Question;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class AnswerQuestionFrame {
	private JFrame frame;
	private PlayerClient client;
	private Question questionBeingPlayed;
	private int questionNumber;
	private JButton answer1Button;
	private JButton answer2Button;
	private JButton answer3Button;
	private JButton answer4Button;

	public AnswerQuestionFrame(PlayerClient client, Question question, int questionNumber) {
		this.client = client;
		this.questionBeingPlayed = question;
		this.questionNumber = questionNumber;
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void launch() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.setBounds(100, 100, 607, 464);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel questionLabel = new JLabel(questionBeingPlayed.getQuestion());
		questionLabel.setBackground(Color.YELLOW);
		questionLabel.setForeground(new Color(0, 0, 0));
		questionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		questionLabel.setBounds(40, 71, 517, 65);
		frame.getContentPane().add(questionLabel);
		
		JLabel questionNumberLabel = new JLabel("Question Number: " + questionNumber);
		questionNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		questionNumberLabel.setBounds(40, 34, 247, 14);
		frame.getContentPane().add(questionNumberLabel);
		
		answer1Button = new JButton(questionBeingPlayed.getAnswers()[0]);
		answer1Button.setBackground(Color.YELLOW);
		answer1Button.setForeground(Color.RED);
		answer1Button.setBounds(82, 200, 159, 78);
		frame.getContentPane().add(answer1Button);
		
		answer2Button = new JButton(questionBeingPlayed.getAnswers()[1]);
		answer2Button.setForeground(Color.RED);
		answer2Button.setBackground(Color.YELLOW);
		answer2Button.setBounds(357, 200, 159, 78);
		frame.getContentPane().add(answer2Button);
		
		answer3Button = new JButton(questionBeingPlayed.getAnswers()[2]);
		answer3Button.setForeground(Color.RED);
		answer3Button.setBackground(Color.YELLOW);
		answer3Button.setBounds(82, 311, 159, 78);
		frame.getContentPane().add(answer3Button);
		
		answer4Button = new JButton(questionBeingPlayed.getAnswers()[3]);
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
		setActionListeners(questionBeingPlayed.getCorrectAnswer());
		frame.setVisible(true);
	}
	public void setActionListeners(String correctAnswer){
		ArrayList<JButton> buttonList = new ArrayList<JButton>();
		buttonList.add(answer1Button);
		buttonList.add(answer2Button);
		buttonList.add(answer3Button);
		buttonList.add(answer4Button);
		for (JButton button: buttonList){
			if (button.getText().equals(correctAnswer)){
				button.addActionListener(new CorrectAnswerButtonActionListener());
			}
			else{
				button.addActionListener(new WrongAnswerButtonActionListener());
			}
		}
	}
	
	class WrongAnswerButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (JOptionPane.showConfirmDialog(null, "Is this your final answer?") == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, "Answer submitted");
				frame.setVisible(false);
				frame.dispose();
				client.playNextQuestion();
			}
		}
	}
	class CorrectAnswerButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (JOptionPane.showConfirmDialog(null, "Is this your final answer?") == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, "Answer submitted");
				frame.setVisible(false);
				frame.dispose();
				client.playNextQuestion();
				client.increasePlayerScore();
			}		
			
		}
		
	}
}
