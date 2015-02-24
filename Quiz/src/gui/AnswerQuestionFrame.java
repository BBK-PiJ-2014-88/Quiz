package gui;

import client.PlayerClient;
import quiz.Question;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


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
	 * Sets up the GUI. Includes 4 JButtons for the 4 possible answers, a JLabel instructing what the user should do and a JLabel displaying
	 * the current question in the Quiz
	 */
	public void launch() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.setBounds(100, 100, 607, 464);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JLabel selectAnswerLabel = new JLabel("Please select an answer from the options below");
		selectAnswerLabel.setBackground(Color.YELLOW);
		selectAnswerLabel.setForeground(Color.RED);
		selectAnswerLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		selectAnswerLabel.setBounds(50, 147, 429, 40);
		frame.getContentPane().add(selectAnswerLabel);
		
		//set the CorrectAnswerButtonActionListener and WrongAnswerActionListener depending on the correct Answer Number
		setActionListeners(questionBeingPlayed.getCorrectAnswer());
		frame.setVisible(true);
	}
	/**
	 * Sets the CorrectAnswerButtonActionListener to the button with the correct answer and 
	 * WrongAnswerButtonActionListener to the rest
	 */
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
	
	/**
	 *Tells the user their answer was incorrect and displays the next Question
	 */
	class WrongAnswerButtonActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			if (JOptionPane.showConfirmDialog(null, "Is this your final answer?") == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, "Too bad, Your answer was incorrect");
				frame.setVisible(false);
				frame.dispose();
				client.playNextQuestion();
			}
		}
	}
	/**
	 * Increases playerScore and displays the next question
	 */
	class CorrectAnswerButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (JOptionPane.showConfirmDialog(null, "Is this your final answer?") == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, "Well done. Your answer was Correct");
				frame.setVisible(false);
				frame.dispose();
				client.increasePlayerScore();
				client.playNextQuestion();
			}			
		}
	}
}
