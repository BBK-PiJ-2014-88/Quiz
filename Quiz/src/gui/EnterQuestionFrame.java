package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class EnterQuestionFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterQuestionFrame window = new EnterQuestionFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EnterQuestionFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 605, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPleaseEnterA = new JLabel("Please Enter a Question:");
		lblPleaseEnterA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseEnterA.setForeground(Color.RED);
		lblPleaseEnterA.setBounds(53, 39, 198, 51);
		frame.getContentPane().add(lblPleaseEnterA);
		
		textField = new JTextField();
		textField.setBounds(261, 44, 285, 44);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPleaseEnter = new JLabel("Please enter 4 possible answers and select which one is correct: ");
		lblPleaseEnter.setForeground(Color.RED);
		lblPleaseEnter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPleaseEnter.setBounds(52, 114, 469, 34);
		frame.getContentPane().add(lblPleaseEnter);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 197, 165, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(316, 197, 165, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(66, 265, 165, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(316, 265, 165, 20);
		frame.getContentPane().add(textField_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(237, 196, 23, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("New radio button");
		radioButton.setBounds(237, 264, 23, 23);
		frame.getContentPane().add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("New radio button");
		radioButton_1.setBounds(487, 196, 23, 23);
		frame.getContentPane().add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("New radio button");
		radioButton_2.setBounds(487, 264, 23, 23);
		frame.getContentPane().add(radioButton_2);
		
		JButton btnSaveQuestionAnd = new JButton("Insert Another Question");
		btnSaveQuestionAnd.setBounds(66, 315, 200, 66);
		frame.getContentPane().add(btnSaveQuestionAnd);
		
		JButton btnSaveWholeQuiz = new JButton("Save Whole Quiz");
		btnSaveWholeQuiz.setBounds(316, 315, 200, 66);
		frame.getContentPane().add(btnSaveWholeQuiz);
	}
}
