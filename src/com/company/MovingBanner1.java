package com.company;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

/******************************************************************************************
Name: Thanh Le
Course:CS125-01 
Lab#: Lab One
Submission Date: 8:00pm, Wed (9/20)
Brief Description: Part 1 - Circle operation class - Declare radius, compute Diameter, 
Area and Circumfence based on the radius. 
********************************************************************************************/
public class MovingBanner1 extends Applet
{
    private JPanel panel; // Set panel preferences
    private JLabel message; // Set Mile Label preference
    private JTextField messageTextField; // set Miles Text Field preference
    private JButton submitButton; // set submit Button Text Field
    private JButton exitButton; // set Exit Button Text Field
    private final int WINDOW_WIDTH = 300;
    private final int WINDOW_HEIGHT = 150;

    public void paint(Graphics graphics){
        String message = "Hello this is";
        graphics.drawString(message, 200, 100);
        try{
            Thread.sleep(200);
            char ch = message.charAt(0);
            message = message.substring(1, message.length());
            message += ch;
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

 }