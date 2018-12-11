package com.company;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

//52

public class OutOfRangeException extends Exception{
    OutOfRangeException(){
        super("Input must be between 0 and 100");
    }
}

public class example {

    // Question

    public static void main(String[] args){
        // 51
        Scanner keyboard = new Scanner(System.in);
        try{

            Integer input = Integer.parseInt(keyboard.nextLine());
            if (input < 0 || input > 100){
                throw new OutOfRangeException();
            }
        }catch (OutOfRangeException exception){
            System.out.println(exception.getMessage());
        }
        keyboard.close();
    }
}

// 53



class MileToKiloGUI extends JFrame {

    private JLabel mileLabel;
    private JTextField mileTextField;
    private JButton submitButton;
    private JPanel panel;
    private final int WINDOW_WIDTH = 310;
    private final int WINDOW_HEIGHT = 150;

    public MileToKiloGUI(){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        buildPanel();
    }

    private void buildPanel(){
        mileLabel = new JLabel("Enter Mile ");
        mileTextField = new JTextField(10);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new MileToKiloGUI.submitButtonListioner());
        panel = new JPanel();
        panel.add(mileLabel);
        panel.add(mileTextField);
        panel.add(submitButton);
    }

}

// 54
class PoundsToKiloGUI extends JFrame {

    private JLabel poundLabel;
    private JTextField poundTextField;
    private JButton submitButton;
    private JPanel panel;
    private final int WINDOW_WIDTH = 310;
    private final int WINDOW_HEIGHT = 150;

    public PoundsToKiloGUI(){
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        buildPanel();
    }

    private void buildPanel(){
        poundLabel = new JLabel("Enter Mile ");
        poundTextField = new JTextField(10);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new PoundsToKiloGUI.submitButtonListioner());
        panel = new JPanel();
        panel.add(poundLabel);
        panel.add(poundTextField);
        panel.add(submitButton);
    }

    private class submitButtonListioner implements ActionListener {
        public void actionPerformed (ActionEvent e){
            double poundInput = 0.0;
            String input = poundTextField.getText();
            poundInput = Double.parseDouble(input);
            double kiloValue = poundInput * 0.454;
            String showMessage = "Pound per Kilogram: " + kiloValue + "\n";
            JOptionPane.showMessageDialog(null, showMessage, "Pound converted to Kilogram Value: ", JOptionPane.INFORMATION_MESSAGE);

        }
    }

}
