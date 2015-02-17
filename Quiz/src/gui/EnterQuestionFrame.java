package gui;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import client.*;

public class EnterQuestionFrame {
	private SetUpClient client;
	private JFrame frame;
	private JTextField questionTextField;
	private JTextField answer1TextField;
	private JTextField answer2TextField;
	private JTextField answer3TextField;
	private JTextField answer4TextField;
	private ArrayList<JRadioButton> buttonList;

	/**
	 * Create the application.
	 */
	public EnterQuestionFrame(SetUpClient client) {
		this.client = client;
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void launch() {
		frame = new JFrame();
		frame.setBounds(100, 100, 605, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel enterQuestionLabel = new JLabel("Please Enter a Question:");
		enterQuestionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enterQuestionLabel.setForeground(Color.RED);
		enterQuestionLabel.setBounds(53, 39, 198, 51);
		frame.getContentPane().add(enterQuestionLabel);
		
		questionTextField = new JTextField();
		questionTextField.setBounds(261, 44, 285, 44);
		frame.getContentPane().add(questionTextField);
		questionTextField.setColumns(10);
		
		JLabel instructionLabel = new JLabel("Please enter 4 possible answers and select which one is correct: ");
		instructionLabel.setForeground(Color.RED);
		instructionLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		instructionLabel.setBounds(52, 114, 469, 34);
		frame.getContentPane().add(instructionLabel);
		
		answer1TextField = new JTextField();
		answer1TextField.setColumns(10);
		answer1TextField.setBounds(66, 197, 165, 20);
		frame.getContentPane().add(answer1TextField);
		
		answer2TextField = new JTextField();
		answer2TextField.setColumns(10);
		answer2TextField.setBounds(316, 197, 165, 20);
		frame.getContentPane().add(answer2TextField);
		
		
		answer3TextField = new JTextField();
		answer3TextField.setColumns(10);
		answer3TextField.setBounds(66, 265, 165, 20);
		frame.getContentPane().add(answer3TextField);
		
		answer4TextField = new JTextField();
		answer4TextField.setColumns(10);
		answer4TextField.setBounds(316, 265, 165, 20);
		frame.getContentPane().add(answer4TextField);
		
		JRadioButton answer1RadioButton = new JRadioButton("0");
		answer1RadioButton.setBounds(237, 196, 23, 23);
		frame.getContentPane().add(answer1RadioButton);
		
		JRadioButton answer2RadioButton = new JRadioButton("1");
		answer2RadioButton.setBounds(487, 196, 23, 23);
		frame.getContentPane().add(answer2RadioButton);
		
		JRadioButton answer3RadioButton = new JRadioButton("2");
		answer3RadioButton.setBounds(237, 264, 23, 23);
		frame.getContentPane().add(answer3RadioButton);
		
		JRadioButton answer4RadioButton = new JRadioButton("3");
		answer4RadioButton.setBounds(487, 264, 23, 23);
		frame.getContentPane().add(answer4RadioButton);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(answer1RadioButton);
		buttonGroup.add(answer2RadioButton);
		buttonGroup.add(answer3RadioButton);
		buttonGroup.add(answer4RadioButton);
		buttonList = new ArrayList<JRadioButton>();
		buttonList.add(answer1RadioButton);
		buttonList.add(answer2RadioButton);
		buttonList.add(answer3RadioButton);
		buttonList.add(answer4RadioButton);
		
		
		JButton nextQuestionButton = new JButton("Insert Another Question");
		nextQuestionButton.setBounds(53, 315, 200, 66);
		nextQuestionButton.addActionListener(new nextQuestionButtonActionListener());
		frame.getContentPane().add(nextQuestionButton);
		
		JButton saveQuizButton = new JButton("Save Whole Quiz");
		saveQuizButton.setBounds(321, 315, 200, 66);
		frame.getContentPane().add(saveQuizButton);
		

		
		frame.setVisible(true);
	}
	
	public boolean isInputValid(){
		if (questionTextField.getText().length() == 0){
			JOptionPane.showMessageDialog(null, "Please enter a question");
			return false;
		}
		else if (!answersInsertedCorrectly()){
			JOptionPane.showMessageDialog(null, "Please enter 4 possible answers");
			return false;
		}
		else if (!correctAnswerButtonSelected()){
			JOptionPane.showMessageDialog(null, "Please select a correct answer");
		}
		return true;
	}
	
	public boolean answersInsertedCorrectly(){
		JTextField[] answerFields = {answer1TextField, answer2TextField, answer3TextField,answer4TextField};
		for (JTextField answerBox: answerFields){
			if (answerBox.getText().length() == 0){
				return false;
			}
		}
		return true;
	}
	public boolean correctAnswerButtonSelected(){
		for (JRadioButton button: buttonList){
			if (button.isSelected()){
				return true;
			}
		}
		return false;
	}
	public void saveQuestion(){
		String question = questionTextField.getText();
		String[] answers = {answer1TextField.getText(), answer2TextField.getText(),
				answer3TextField.getText(), answer4TextField.getText()};
		int correctAnswer = getCorrectAnswerNumber();
		client.addQuestionToQuiz(question, answers, correctAnswer);
	}
	class nextQuestionButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (isInputValid()){
				saveQuestion();
				frame.setVisible(false);
				frame.dispose();
				JOptionPane.showMessageDialog(null, "Successfully entered question");
				client.getQuizQuestions();
			}
		}
	}
	class saveQuizButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			if (isInputValid()){
				saveQuestion();
				frame.setVisible(false);
				frame.dispose();
				JOptionPane.showMessageDialog(null, "Successfully entered question");
				client.addQuizToServer();
				JOptionPane.showMessageDialog(null, "Successfully saved Quiz to Server");
			}
		}
	}
	public int getCorrectAnswerNumber(){
		for (JRadioButton button: buttonList){
			if (button.isSelected()){
				return Integer.parseInt(button.getText());
			}
		}
		return Integer.MAX_VALUE; 
		
	}
	
	

	

	
}
