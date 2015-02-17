package gui;


import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import client.*;

public class EnterQuestionFrame {
	private SetUpClient client;  //the setUpClient that invoked this frame
	private JFrame frame;		//the main JFrame
	private JTextField questionTextField; // The TextField for entering a question
	private JTextField answer1TextField; //The textFields for entering answers
	private JTextField answer2TextField;
	private JTextField answer3TextField;
	private JTextField answer4TextField;
	private ArrayList<JRadioButton> buttonList; //ArrayList containing 4 JRadioButtons

	public EnterQuestionFrame(SetUpClient client) {
		this.client = client;
	}

	/**
	 * Sets up the frame and its contents
	 * Includes 2 JLabels instructing the user what to do, 
	 * 1 JTextField for entering a question, 4 JTextfields for entering possible answers,
	 * 4 JRadioButtons for selecting the correct answer and
	 * 2 Jbutton's for adding another Question or adding a question and Saving the quiz
	 * 
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

		//add JRadioButtons to buttonGroup so only 1 can be selected at a time
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(answer1RadioButton);
		buttonGroup.add(answer2RadioButton);
		buttonGroup.add(answer3RadioButton);
		buttonGroup.add(answer4RadioButton);
		//add JRadioButtons to ArrayList. The ArrayList will be used for verifying which 
		//JRadioButton has been selected
		buttonList = new ArrayList<JRadioButton>();
		buttonList.add(answer1RadioButton);
		buttonList.add(answer2RadioButton);
		buttonList.add(answer3RadioButton);
		buttonList.add(answer4RadioButton);
		
		
		JButton nextQuestionButton = new JButton("Insert Another Question");
		nextQuestionButton.setBounds(53, 315, 200, 66);
		nextQuestionButton.addActionListener(new NextQuestionButtonActionListener());
		frame.getContentPane().add(nextQuestionButton);
		
		JButton saveQuizButton = new JButton("Save Whole Quiz");
		saveQuizButton.setBounds(321, 315, 200, 66);
		saveQuizButton.addActionListener(new SaveQuizButtonActionListener());
		frame.getContentPane().add(saveQuizButton);
		
		frame.setVisible(true);
	}
	
	/**
	 * Method for checking that the user has correctly filled in the question form
	 * @return boolean : true if input is valid, false otherwise
	 */
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
			return false;
		}
		return true;
	}
	
	/*
	 * Method that makes sure 4 possible answers have been inserted
	 * @return boolean : true if answers have been inserted, false otherwise
	 */
	public boolean answersInsertedCorrectly(){
		JTextField[] answerFields = {answer1TextField, answer2TextField, answer3TextField,answer4TextField};
		for (JTextField answerBox: answerFields){
			if (answerBox.getText().length() == 0){
				return false;
			}
		}
		return true;
	}
	/**
	 * 
	 * @return boolean : returns true if 1 JRadtioButton has been selected
	 */
	public boolean correctAnswerButtonSelected(){
		for (JRadioButton button: buttonList){
			if (button.isSelected()){
				return true;
			}
		}
		return false;
	}
	
	/*
	 * Gets the question, answers and correct answer number entered by the user
	 * and sends it to the SetUpClient to make into a question
	 */
	public void saveQuestion(){
		String question = questionTextField.getText();
		String[] answers = {answer1TextField.getText(), answer2TextField.getText(),
				answer3TextField.getText(), answer4TextField.getText()};
		int correctAnswer = getCorrectAnswerNumber();
		client.addQuestionToQuiz(question, answers, correctAnswer);
	}
	
	/**
	 * Checks which JRadioButton has been selected
	 * @return the int representing the correct answer inserted by the user
	 */
	public int getCorrectAnswerNumber(){
		for (JRadioButton button: buttonList){
			if (button.isSelected()){
				return Integer.parseInt(button.getText());
			}
		}
		return Integer.MAX_VALUE; 
	}
	/*
	 * If the user selects the Next Question button, the method checks whether the user
	 * has filled in the form correctly. If so, a question object based on the user input is 
	 * created by the SetUpClient. This method then calls on the SetUpClient to relaunch
	 * the GUI for a user to enter another question.
	 */
	class NextQuestionButtonActionListener implements ActionListener{
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
	/**
	 * If the user selects the SaveQuiz button, if the user has entered the input correctly,
	 * the SetUpClient makes a question Object based on the user input
	 * and then sends the whole Quiz to the Quiz Server to save
	 */
	class SaveQuizButtonActionListener implements ActionListener{
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
	
}
