package gui;

import javax.swing.*;

public class InsertQuizNameGui {
	JFrame frame;
	public static void main(String[] args){
		new InsertQuizNameGui().launch();
	}
	public void launch(){
		frame = new JFrame("Naming Quiz");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setVisible(true);;
	}
}
