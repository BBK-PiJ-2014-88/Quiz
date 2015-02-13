package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;




import javax.swing.*;

import java.awt.event.*;

public class HomePage {
	private JFrame frame;
	private JButton makeQuizButton;
	private JButton playQuizButton;
	private JPanel panel;
	private JLabel label;
	private MyImagePanel imagePanel;
	
	public static void main(String[] args) {
		new HomePage().launch();
	}
	public void launch(){
		Font bigFont = new Font("serif", Font.BOLD, 28);
		Font mediumFont = new Font("serif", Font.BOLD, 20);
		frame = new JFrame();
		panel = new JPanel();
		imagePanel = new MyImagePanel();
		
		label = new JLabel("Welcome to the Incredible RMI Quiz!");
		label.setFont(bigFont);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		makeQuizButton = new JButton("Click here to make a Quiz");
		playQuizButton = new JButton("Click here to play a Quiz");
		PlayQuizButtonListener playQuizListener = new PlayQuizButtonListener();
		MakeQuizButtonListener makeQuizListener = new MakeQuizButtonListener();
		makeQuizButton.addActionListener(makeQuizListener);
		playQuizButton.addActionListener(playQuizListener);
		makeQuizButton.setFont(mediumFont);
		playQuizButton.setFont(mediumFont);
		
		panel.add(makeQuizButton);
		panel.add(playQuizButton);
		panel.setAlignmentY(SwingConstants.CENTER);
		
		frame.getContentPane().add(BorderLayout.SOUTH,label);
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(imagePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(600,600);
		frame.setVisible(true);
		
		
	}
	
	class PlayQuizButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			playQuizButton.setText("I've been clicked");
		}
	}
	class MakeQuizButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			makeQuizButton.setText("I've been clicked");
		}
	}

	class MyImagePanel extends JPanel {
		public void paintComponent(Graphics g){
			Image image = new ImageIcon(getClass().getResource("quizImage.jpg")).getImage();
			//Image image = new ImageIcon("quizImage.jpg").getImage();
			g.drawImage(image, 3,4, this);
		}
	}
}
