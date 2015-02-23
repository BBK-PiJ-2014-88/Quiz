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
	private PlayerClient client;
	private String[] availableQuizzes;
	private JList list;
	
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
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
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
	 * Gets the id of the quiz the user wants to play or delete
	 * In the JList quiz information is displayed as 
	 * "[Quiz id]: " + id + " [Quiz name]: " + quizName"
	 * Therefore the id number starts is at position 11 to before [Quiz name]
	 */
	public int getQuizId(){
		String quizInfo = (String) list.getSelectedValue();
		int positionAfterId = quizInfo.indexOf(" [Quiz name]:");
		int result = Integer.parseInt(quizInfo.substring(11, positionAfterId));
		System.out.println(" got id: " + result);
		return result;
	}
	class DeleteButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (isSelectionValid()){
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Quiz?");
				if (result == JOptionPane.YES_OPTION){
					if (client.deleteQuiz(getQuizId())){
						JOptionPane.showMessageDialog(null, "Quiz successfully deleted");
						frame.setVisible(false);
						frame.dispose();
						client.launch();
					}
				}
			}
		}
	}
	class PlayQuizButtonActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(isSelectionValid()){
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
		}
	}
	class ViewHighScoresActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(isSelectionValid()){
				client.displayHighScore(getQuizId());
			}
		}
	}
}
