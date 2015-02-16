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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(227, 179, 18, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("New radio button");
		radioButton.setBounds(227, 242, 18, 23);
		contentPane.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("New radio button");
		radioButton_1.setBounds(502, 179, 18, 23);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("New radio button");
		radioButton_2.setBounds(502, 242, 18, 23);
		contentPane.add(radioButton_2);
		
		JLabel lblPleaseSelectThe = new JLabel("Please select the Correct Answer");
		lblPleaseSelectThe.setBounds(45, 115, 226, 31);
		contentPane.add(lblPleaseSelectThe);
		
		JButton btnNextQuestion = new JButton("Next Question");
		btnNextQuestion.setForeground(Color.RED);
		btnNextQuestion.setBounds(431, 337, 118, 47);
		contentPane.add(btnNextQuestion);
	}
}
