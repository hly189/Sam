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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircleGUIApp extends JFrame {
	private JPanel panel; // Set panel preferences
	private JLabel messageLabel; // Set Label preference
	private JTextField radiusTextField; // set Radius Text Field preference
	private JButton submitButton; // set submit Button Text Field
	private JButton clearButton; // set clear Field Button prference
	private JButton exitButton; // set Exit Button Text Field
	private final int WINDOW_WIDTH = 310;
	private final int WINDOW_HEIGHT = 100;

	public CircleGUIApp() {
		// Set call JFrame Constructor
		super("Circle Calculator");

		// Set size of Window
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// Specify what happens when the close button is clicked.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Build Panel
		buildPanel();

		// add Panel
		add(panel);

		// Display the window.
		setVisible(true);
	}
	private void buildPanel(){
		messageLabel = new JLabel("Enter Radius ");
		radiusTextField = new JTextField(10);
		submitButton = new JButton("Submit");
		exitButton = new JButton("Exit");
		clearButton = new JButton("Clear");

		submitButton.addActionListener(new submitButtonListioner());
		exitButton.addActionListener(new exitButtonListioner());
		clearButton.addActionListener(new clearButtonLitioner());
		panel = new JPanel();
		panel.add(messageLabel);
		panel.add(radiusTextField);
		panel.add(submitButton);
		panel.add(clearButton);
		panel.add(exitButton);
	}
	private  class clearButtonLitioner implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			radiusTextField.setText("");
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
			double radiusInput = 0.0;

			boolean radiusValidation = false;
			do{
				try {
					String input = radiusTextField.getText();
					radiusInput = Double.parseDouble(input);
					try{
							if (radiusInput > 0.0) {
								radiusValidation = true;
							}else{
								throw new NegativeDoubleException();
							}
					}catch (NegativeDoubleException negative){
						radiusTextField.setText("");
						JOptionPane.showMessageDialog(null,negative.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}

				}catch (NumberFormatException error){
					radiusTextField.setText("");
					JOptionPane.showMessageDialog(null,"Input must be positive", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}while (radiusValidation == false);

			CircleGUI  thisCircleGUI = new CircleGUI();
			thisCircleGUI.setRadius(radiusInput);
			String showMessage = "Radius: " + thisCircleGUI.getRadius() + "\n"
					+ "Area: " + thisCircleGUI.computeArea() + "\n"
					+ "Diameter: " + thisCircleGUI.computeDiameter() + "\n"
					+ "Circumfence: " + thisCircleGUI.computeCircumference() + "\n";
			JOptionPane.showMessageDialog(null, showMessage, "Radius Information", JOptionPane.INFORMATION_MESSAGE);



		}
	}
	/************************************
	 * Main Class of CircleApp
	 ************************************/
	public static void main(String[] args) {
		new CircleGUIApp();

	}
}