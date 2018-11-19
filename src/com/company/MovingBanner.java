package com.company;

import javax.swing.*;
import java.applet.*;
import java.awt.*;

/******************************************************************************************
Name: Thanh Le
Course:CS125-01 
Lab#: Lab One
Submission Date: 8:00pm, Wed (9/20)
Brief Description: Part 1 - Circle operation class - Declare radius, compute Diameter, 
Area and Circumfence based on the radius. 
********************************************************************************************/
public class MovingBanner extends Applet
{
    private String message = "This is message";

    public void init(){
        showStatus(message);
    }

    public void paint(Graphics graphics){
        graphics.drawString(message, 200, 100);
        try{
            repaint();
            Thread.sleep(200);
            char ch = message.charAt(0);
            message = message.substring(1, message.length());
            message += ch;
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}