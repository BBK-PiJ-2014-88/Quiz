package gui;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import client.PlayerClient;

public class SelectQuizFrame {
	private JFrame frame;
	private PlayerClient client; //the PlayerClient that launches this GUI
	private String[] availableQuizzes; //the available Quizzes on the server that can be played
	private JList list; //The JList for displaying the available quizzes
	
	/**
	 * Adds the availableQuizzes to the JList to display. If there are none, displays a message
	 */
	public SelectQuizFrame(PlayerClient client, String[] availableQuizzes) {
		this.client = client;
		if (availableQuizzes.length != 0){
			this.availableQuizzes = availableQuizzes;
		}
		else{
			this.availableQuizzes = new String[1];
			this.availableQuizzes[0] = "There are no available Quizzes";
		}
	}

	/**
	 * Launches the main JFrame and its components. 
	 * Includes 3 buttons, 1 for playing as Quiz, 1 for deleting a Quiz and 1 for viewing a Quizzes high Scores
	 * Includes a JList in a ScrollPane that displays all the available Quizzes.  
	 * Includes a JLabel instructing the user what to do. 
	 */
	public void launch() {
		frame = new JFrame();
		frame.setBounds(100, 100, 605, 472);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton playQuizButton = new JButton("PLAY");
		playQuizButton.setBackground(Color.YELLOW);
		playQuizButton.setForeground(Color.RED);
		playQuizButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		playQuizButton.setBounds(358, 76, 175, 72);
		playQuizButton.addActionListener(new PlayQuizButtonActionListener());
		frame.getContentPane().add(playQuizButton);
		
		JButton viewScoresButton = new JButton("View High Scores");
		viewScoresButton.setForeground(Color.RED);
		viewScoresButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewScoresButton.setBackground(Color.YELLOW);
		viewScoresButton.setBounds(358, 200, 175, 72);
		viewScoresButton.addActionListener(new ViewHighScoresActionListener());
		frame.getContentPane().add(viewScoresButton);
		
		JButton deleteButton = new JButton("DELETE");
		deleteButton.setForeground(Color.RED);
		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deleteButton.setBackground(Color.YELLOW);
		deleteButton.setBounds(358, 320, 175, 72);
		deleteButton.addActionListener(new DeleteButtonActionListener());
		frame.getContentPane().add(deleteButton);
		
		JLabel instructionToUserLabel = new JLabel("SELECT A QUIZ");
		instructionToUserLabel.setBackground(Color.YELLOW);
		instructionToUserLabel.setForeground(Color.RED);
		instructionToUserLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		instructionToUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
		instructionToUserLabel.setBounds(44, 27, 268, 25);
		frame.getContentPane().add(instructionToUserLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 75, 298, 317);
		frame.getContentPane().add(scrollPane);
		
		list = new JList(availableQuizzes);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		frame.setVisible(true);
	}
	
	/**
	 * Checks the user has correctly selected a Quiz 
	 */
	public boolean isSelectionValid(){
		if (list.isSelectionEmpty()){
			JOptionPane.showMessageDialog(null, "Please select a Quiz");
			return false;
		}
		else if (availableQuizzes[0].equals("There are no available Quizzes")){
			JOptionPane.showMessageDialog(null, "No Quiz selected");
			return false;
		}
		return true;
	}

	/*
	 * Gets the id of the quiz the user wants to play, delete or view the high scores of
	 * In the JList quiz information is displayed as 
	 * "[Quiz id]: " + id + " [Quiz name]: " + quizName"
	 * Therefore the id number starts is at position 11 to before [Quiz name]
	 */
	public int getQuizId(){
		String quizInfo = (String) list.getSelectedValue();
		int positionAfterId = quizInfo.indexOf(" [Quiz name]:");
		int result = Integer.parseInt(quizInfo.substring(11, positionAfterId));
		return result;
	}
	
	/**
	 * ActionListener for DeleteButton. If user confirms they want to delete a quiz and the quiz hasn't already been deleted,
	 * the quiz is deleted. The user is also given the option of viewing a Quizzes high scores before deleting it
	 */
	class DeleteButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (isSelectionValid()){
				if(client.doesQuizExist(getQuizId())){ //checks a concurrent client hasn't deleted the quiz
					int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Quiz?");
					if (result == JOptionPane.YES_OPTION){
						if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Would you like to view the high scores before deleting the quiz")){
							client.displayHighScore(getQuizId());
						}
						if (client.deleteQuiz(getQuizId())){
							JOptionPane.showMessageDialog(null, "Quiz successfully deleted.");
							frame.setVisible(false);
							frame.dispose();
						}
						else{
							JOptionPane.showMessageDialog(null, "Somebody else is currently playing this quiz so it cannot be deleted at the moment");
						}
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "This quiz has been deleted by another client");
				}
			}
		}
	}
	/**
	 * If the user has correctly selected a quiz, this button launches the GUI for a player to answer the Quiz questions
	 */
	class PlayQuizButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(isSelectionValid()){
				if(client.doesQuizExist(getQuizId())){
					String name = JOptionPane.showInputDialog("Insert Player name: ");
					if (name.length() == 0){
						JOptionPane.showMessageDialog(null, "Please enter a name");
					}
					else{
						frame.setVisible(false);
						frame.dispose();
						client.createPlayerAttempt(name, getQuizId()); 
					}
				}
				else{
					JOptionPane.showMessageDialog(null,  "This quiz has been deleted by another client");
				}
			}
		}
	}
	/**
	 *If the user has correctly selected a quiz and the Quiz hasn't been deleted, this button launches the GUI for viewing high scores
	 */
	class ViewHighScoresActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) { //checks a concurrent client hasn't deleted the quiz
			if(isSelectionValid()){
				if (client.doesQuizExist(getQuizId())){
					client.displayHighScore(getQuizId());
				}
				else{
					JOptionPane.showMessageDialog(null,  "This quiz has been deleted by another client");
				}
			}
		}
	}
}
