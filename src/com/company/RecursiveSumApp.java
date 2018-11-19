package com.company;
/******************************************************************************
Name: Thanh Le
Course:CS125-01 
Lab#: Lab One
Submission Date: 8:00pm, Wed (9/20)
Brief Description: Part 1 - Circle driver class - Take user input
create a object, call the methods and display the the result.
********************************************************************************/

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class RecusiveSumGUI extends JFrame
{

	private JPanel panel; // Set panel preferences
	private JLabel messageLabel; // Set Label preference
	private JTextField integerTextField; // set Radius Text Field preference
	private JButton submitButton; // set submit Button Text Field
	private JButton clearButton; // set clear Field Button prference
	private JButton exitButton; // set Exit Button Text Field
	private final int WINDOW_WIDTH = 310;
	private final int WINDOW_HEIGHT = 100;

	public RecusiveSumGUI() {
		// Set call JFrame Constructor
		super("Recursive Sum Calculator");

		// Set size of Window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify what happens when the close button is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build Panel
		buildPanel();

		// add Panel
		add(panel);

		//add to center
		setLocationRelativeTo(null);

		// Display the window.
		setVisible(true);
	}
	private void buildPanel(){
		messageLabel = new JLabel("Enter Integer ");
		integerTextField = new JTextField(15);
		submitButton = new JButton("OK");
		exitButton = new JButton("Exit");
		clearButton = new JButton("Clear");

		submitButton.addActionListener(new RecusiveSumGUI.submitButtonListioner());
		exitButton.addActionListener(new RecusiveSumGUI.exitButtonListioner());
		clearButton.addActionListener(new RecusiveSumGUI.clearButtonLitioner());
		panel = new JPanel();
		panel.add(messageLabel);
		panel.add(integerTextField);
		panel.add(submitButton);
		panel.add(clearButton);
		panel.add(exitButton);
	}
	private  class clearButtonLitioner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			integerTextField.setText("");
		}
	}
	private class exitButtonListioner implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	private class submitButtonListioner implements ActionListener {
		public void actionPerformed (ActionEvent e){
			int integerInput = 0;
			String input;

			boolean inputValidation = false;
			do{
				try {
					input = integerTextField.getText();
					if (input.isEmpty()){
						JOptionPane.showMessageDialog(null,"Input is empty", "Warning", JOptionPane.WARNING_MESSAGE);
						return;
					}
					integerInput = Integer.parseInt(input);
					try{
						if (integerInput >= 0) {
							inputValidation = true;
						} else {
							throw new NegativeIntegerException();
						}

					}catch (NegativeIntegerException negative){
						integerTextField.setText("");
						JOptionPane.showMessageDialog(null,negative.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}

				}catch (NumberFormatException error){
					integerTextField.setText("");
					JOptionPane.showMessageDialog(null,"Input must be positive", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}while (inputValidation == false);

			RecursiveSum  thisRecusiveSum = new RecursiveSum();
			String showMessage = "Input Integer: " + integerInput + "\n"
					+ "Recursive Sum: " + thisRecusiveSum.calculateRecursiveSum(integerInput) + "\n";
			JOptionPane.showMessageDialog(null, showMessage, "Sum Information", JOptionPane.INFORMATION_MESSAGE);

		}
	}

}

public class RecursiveSumApp {

	/************************************
	 * Main Class of RecusiveSumApp
	 ************************************/
	public static void main(String[] args) {
		new RecusiveSumGUI();

	}
}