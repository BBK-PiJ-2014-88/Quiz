package gui;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import client.*;

/**
 * 
 * @author Sergio
 * The GUI for the Quiz Homepage
 */
public class HomePageGui {
	private JFrame frame;
	private JButton makeQuizButton;
	private JButton playQuizButton;
	private JPanel panel;
	private JLabel label;
	private MyImagePanel imagePanel;
	
	/**
	 * Sets up the main JFrame and its components
	 * Consists of two buttons: playQuizButton and makeQuizButton, an image and a label title
	 */
	public void launch(){
		Font bigFont = new Font("serif", Font.BOLD, 28);
		Font mediumFont = new Font("serif", Font.BOLD, 20);
		frame = new JFrame("HomePage");
		panel = new JPanel();
		imagePanel = new MyImagePanel();
		
		label = new JLabel("Welcome to the Incredible RMI Quiz!");
		label.setFont(bigFont);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(BorderFactory.createEmptyBorder(60,60,60,60));
		label.setForeground(Color.RED);

		
		makeQuizButton = new JButton("Click here to make a Quiz!");
		playQuizButton = new JButton("Click here to play a Quiz!");
		makeQuizButton.addActionListener(new MakeQuizButtonListener());
		playQuizButton.addActionListener(new PlayQuizButtonListener());
		makeQuizButton.setFont(mediumFont);
		playQuizButton.setFont(mediumFont);
		makeQuizButton.setForeground(Color.RED);
		playQuizButton.setForeground(Color.RED);
		makeQuizButton.setBackground(Color.YELLOW);
		playQuizButton.setBackground(Color.YELLOW);
		
		panel.add(makeQuizButton);
		panel.add(playQuizButton);
		panel.setAlignmentY(SwingConstants.CENTER);
		panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		
		imagePanel.setAlignmentY(200);
		
		frame.getContentPane().add(BorderLayout.SOUTH,label);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(BorderLayout.CENTER, imagePanel);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setVisible(true);
	}
	
	/**
	 * Launches a playerClient if the playQuizButton is clicked
	 */
	class PlayQuizButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			PlayerClient playQuizClient = new PlayerClient();
			playQuizClient.launch();
			
		}
	}
	/**
	 * Launches a setUpClient if the makeQuizButton is clicked
	 */
	class MakeQuizButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			SetUpClient makeQuizClient = new SetUpClient();
			makeQuizClient.launch();
		}
	}

	class MyImagePanel extends JPanel {
		public void paintComponent(Graphics g){
			Image image = new ImageIcon(getClass().getResource("quizImage.jpg")).getImage();
			//2 int variables used for aligning image to the centre of the JPanel
		    int x = (this.getWidth() - image.getWidth(null)) / 2;
		    int y = (this.getHeight() - image.getHeight(null)) / 2;			
			g.drawImage(image, x,y, this);
		}
	}
}
