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

		// Display the window.
		setVisible(true);
	}
	private void buildPanel(){
		messageLabel = new JLabel("Enter Radius ");
	}
	/************************************
	 * Main Class of CircleApp
	 ************************************/
	public static void main(String[] args) {
		new CircleGUIApp();
		//boolean inputValidation = false;
		//double radiusInput = 0.0;
		//do {
		//	try {
		//		radiusInput = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Radus:"));
		//		try {
		//			if (radiusInput > 0.0) {
		//				inputValidation = true;
		//			}else{
		//				throw new NegativeDoubleException();
		//			}
		//		} catch (NegativeDoubleException negative) {
		//			System.out.println(negative.getMessage());
		//		}
		//	} catch (NumberFormatException e) {
		//		System.out.println("Input format must be double type");
		//	}
		//} while (inputValidation == false);

		//System.out.println("This is radius: " + radiusInput);
		//Circle thiscircle = new Circle();
		//thiscircle.setRadius(radiusInput);
		//System.out.println("This is Area: " + thiscircle.computeArea());
		//System.out.println("This is Circumefence: " + thiscircle.computeCircumference());
		//System.out.println("This is Diameter: " + thiscircle.computeDiameter());
	}
}