package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;

public class AnswerQuestionFrame extends JFrame {

	private JPanel contentPane;
	private JTextField possibleAnswer1;
	private JTextField possibleAnswer3;
	private JTextField possibleAnswer2;
	private JTextField possibleAnswer4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnswerQuestionFrame frame = new AnswerQuestionFrame();
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
	public AnswerQuestionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel questionLabel = new JLabel("Question displayed here");
		questionLabel.setForeground(Color.RED);
		questionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		questionLabel.setBounds(45, 28, 524, 76);
		contentPane.add(questionLabel);
		
		possibleAnswer1 = new JTextField();
		possibleAnswer1.setColumns(10);
		possibleAnswer1.setBounds(45, 180, 165, 20);
		contentPane.add(possibleAnswer1);
		
		possibleAnswer3 = new JTextField();
		possibleAnswer3.setColumns(10);
		possibleAnswer3.setBounds(45, 243, 165, 20);
		contentPane.add(possibleAnswer3);
		
		possibleAnswer2 = new JTextField();
		possibleAnswer2.setColumns(10);
		possibleAnswer2.setBounds(314, 180, 165, 20);
		contentPane.add(possibleAnswer2);
		
		possibleAnswer4 = new JTextField();
		possibleAnswer4.setColumns(10);
		possibleAnswer4.setBounds(314, 243, 165, 20);
		contentPane.add(possibleAnswer4);
		
		JRadioButton answer1RadioButton = new JRadioButton("New radio button");
		answer1RadioButton.setBounds(227, 179, 18, 23);
		contentPane.add(answer1RadioButton);
		
		JRadioButton answer3RadioButton = new JRadioButton("New radio button");
		answer3RadioButton.setBounds(227, 242, 18, 23);
		contentPane.add(answer3RadioButton);
		
		JRadioButton answer2RadioButton = new JRadioButton("New radio button");
		answer2RadioButton.setBounds(502, 179, 18, 23);
		contentPane.add(answer2RadioButton);
		
		JRadioButton answer4RadioButton = new JRadioButton("New radio button");
		answer4RadioButton.setBounds(502, 242, 18, 23);
		contentPane.add(answer4RadioButton);
		
		JLabel userInstructionLabel = new JLabel("Please select the Correct Answer from the options below");
		userInstructionLabel.setForeground(Color.RED);
		userInstructionLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		userInstructionLabel.setBounds(45, 115, 361, 31);
		contentPane.add(userInstructionLabel);
		
		JButton nextQuestionButton = new JButton("Next Question");
		nextQuestionButton.setForeground(Color.RED);
		nextQuestionButton.setBounds(431, 337, 118, 47);
		contentPane.add(nextQuestionButton);
	}
}
