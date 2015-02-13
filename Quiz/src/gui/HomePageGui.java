package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;

public class HomePageGui {
	private JFrame frame;
	private JButton makeQuizButton;
	private JButton playQuizButton;
	private JPanel panel;
	private JLabel label;
	private MyImagePanel imagePanel;
	
	public void launch(){
		Font bigFont = new Font("serif", Font.BOLD, 28);
		Font mediumFont = new Font("serif", Font.BOLD, 20);
		frame = new JFrame("HomePage");
		panel = new JPanel();
		imagePanel = new MyImagePanel();
		
		label = new JLabel("Welcome to the Incredible RMI Quiz!");
		label.setFont(bigFont);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
		label.setForeground(Color.RED);
		
		makeQuizButton = new JButton("Click here to make a Quiz!");
		playQuizButton = new JButton("Click here to play a Quiz!");
		PlayQuizButtonListener playQuizListener = new PlayQuizButtonListener();
		MakeQuizButtonListener makeQuizListener = new MakeQuizButtonListener();
		makeQuizButton.addActionListener(makeQuizListener);
		playQuizButton.addActionListener(playQuizListener);
		makeQuizButton.setFont(mediumFont);
		playQuizButton.setFont(mediumFont);
		makeQuizButton.setForeground(Color.RED);
		playQuizButton.setForeground(Color.RED);
		
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
	
	class PlayQuizButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			playQuizButton.setText("I've been clicked");
			//create playQuiz Client
		}
	}
	class MakeQuizButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			makeQuizButton.setText("I've been clicked");
			//create makeQuiz Client
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
