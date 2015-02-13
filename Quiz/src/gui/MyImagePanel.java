package gui;


import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyImagePanel extends JPanel {

	public void paintComponent(Graphics g){
		Image image = new ImageIcon(getClass().getResource("quizImage.jpg")).getImage();
		//Image image = new ImageIcon("quizImage.jpg").getImage();
		g.drawImage(image, 3,4, this);

	}

}
