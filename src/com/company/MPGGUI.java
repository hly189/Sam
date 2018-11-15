package com.company;

/******************************************************************************************
Name: Thanh Le
Course:CS125-01 
Lab#: Lab One
Submission Date: 8:00pm, Wed (9/20)
Brief Description: Part 1 - Circle operation class - Declare radius, compute Diameter, 
Area and Circumfence based on the radius. 
********************************************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MPGGUI extends JFrame                  //
{

    private JPanel panel; // Set panel preferences
    private JFrame frame;
    private JLabel mileMessageLabel; // Set Mile Label preference
    private JLabel galloneMessageLabel; // Set Gallon Label preference
    private JTextField mileTextField; // set Miles Text Field preference
    private JTextField gallonTextField;  // Set Gallon Text Field preference
    private JButton submitButton; // set submit Button Text Field
    private JButton exitButton; // set Exit Button Text Field
    private final int WINDOW_WIDTH = 310;
    private final int WINDOW_HEIGHT = 200;

    public MPGGUI() {
        // Set call JFrame Constructor
        super("Calculate Miles per Gallon");

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
        frame = new JFrame();
        mileMessageLabel = new JLabel("Enter Miles");
        mileTextField = new JTextField(40);

        galloneMessageLabel = new JLabel("Enter Gallons");
        gallonTextField = new JTextField(40);

        submitButton = new JButton("Calculate MPG");
        exitButton = new JButton("Exit");

        submitButton.addActionListener(new MPGGUI.submitButtonListioner());
        exitButton.addActionListener(new MPGGUI.exitButtonListioner());
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        panel.setLayout(new GridBagLayout());
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.WEST;

        GridBagConstraints right = new GridBagConstraints();
        right.weightx = 20.0;
        right.anchor = GridBagConstraints.WEST;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;

        panel.add(mileMessageLabel, left);
        panel.add(mileTextField, right);
        panel.add(galloneMessageLabel, left);
        panel.add(gallonTextField, right);
        panel.add(submitButton, left);
        panel.add(exitButton, right);
       // frame.pack();
        //frame.setVisible(true);
        //panel.add(submitButton);
        //panel.add(exitButton);
    }

    private class exitButtonListioner implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    private class submitButtonListioner implements ActionListener {

        public void actionPerformed (ActionEvent e){
            double mile = 0.0;
            double gallon = 0.0;

            boolean inputValidate = false;
            do{
                try {
                    String mileInput = mileTextField.getText();
                    String gallonInput = gallonTextField.getText();
                    if (mileInput.isEmpty() || gallonInput.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Input is empty", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    mile = Double.parseDouble(mileInput);
                    gallon = Double.parseDouble(gallonInput);
                    try{
                        if (mile > 0.0 && gallon > 0.0) {
                            inputValidate = true;
                        } else {
                            throw new NegativeDoubleException();
                        }

                    }catch (NegativeDoubleException negative){
                        mileTextField.setText("");
                        gallonTextField.setText("");
                        JOptionPane.showMessageDialog(null,negative.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                }catch (NumberFormatException error){
                    mileTextField.setText("");
                    gallonTextField.setText("");
                    JOptionPane.showMessageDialog(null,"Input must be positive", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }while (inputValidate == false);

            double milePerGallon = mile / gallon;
            String showMessage = "Mile Per Gallon: " + milePerGallon + "\n";
            JOptionPane.showMessageDialog(null, showMessage, "Radius Information", JOptionPane.INFORMATION_MESSAGE);

        }
    }
      
}