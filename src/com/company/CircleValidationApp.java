/******************************************************************************
Name: Thanh Le
Course:CS125-01 
Lab#: Lab One
Submission Date: 8:00pm, Wed (9/20)
Brief Description: Part 1 - Circle driver class - Take user input
create a object, call the methods and display the the result.
********************************************************************************/
package com.company;
import javax.swing.JOptionPane;

public class CircleValidationApp // Driver class
{
	/************************************
	 * Main Class of CircleApp
	 ************************************/
	public static void main(String[] args) {
		boolean inputValidation = false;
		double radiusInput = 0.0;
		do {
			try {
				radiusInput = Double.parseDouble(JOptionPane.showInputDialog("Please Enter Radus:"));
				try {
					if (radiusInput > 0.0) {
						inputValidation = true;
					}else{
						throw new NegativeDoubleException();
					}
				} catch (NegativeDoubleException negative) {
					System.out.println(negative.getMessage());
				}
			} catch (NumberFormatException e) {
				System.out.println("Input format must be double type");
			}
		} while (inputValidation == false);

		System.out.println("This is radius: " + radiusInput);
		Circle thiscircle = new Circle();
		thiscircle.setRadius(radiusInput);
		System.out.println("This is Area: " + thiscircle.computeArea());
		System.out.println("This is Circumefence: " + thiscircle.computeCircumference());
		System.out.println("This is Diameter: " + thiscircle.computeDiameter());
	}
}