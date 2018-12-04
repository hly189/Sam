package com.company;

import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingBanner extends JApplet                  //
{

    private JPanel panel; // Set panel preferences
    private JLabel messageLabel; // Set Mile Label preference
    private JTextField messageTextField; // set Miles Text Field preference
    private JButton chooseFontColorButton;  // Set Font Color
    private JButton chooseBackgroundColorButton; // Set Background Color
    private JButton submitButton; // set submit Button Text Field
    private Color backgroundColor;
    private Color fontColor;
    private JButton exitButton; // set Exit Button Text Field
    private final int WINDOW_WIDTH = 300;
    private final int WINDOW_HEIGHT = 150;

    public void init() {
        // Set Title
        Frame title = (Frame)this.getParent().getParent();
        title.setTitle("Moving Banner Apps");

        // Set size of Window
        setSize(new Dimension(WINDOW_WIDTH,WINDOW_HEIGHT));

        // Build Panel
        buildPanel();

        // add Panel
        add(panel);

        // Display the window.
        setVisible(true);
    }

    private void buildPanel(){
        messageLabel = new JLabel("Enter Text");
        messageTextField = new JTextField(40);


        submitButton = new JButton("Submit");
        exitButton = new JButton("Exit");
        chooseFontColorButton = new JButton("Choose Font Color");
        chooseBackgroundColorButton = new JButton("Choose Background Color");

        submitButton.addActionListener(new MovingBanner.submitButtonListioner());
        chooseFontColorButton.addActionListener(new MovingBanner.fontColorListioner());
        chooseBackgroundColorButton.addActionListener(new MovingBanner.backgroundColorListener());
        exitButton.addActionListener(new MovingBanner.exitButtonListioner());
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        panel.setLayout(new GridBagLayout());
        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.WEST;

        GridBagConstraints right = new GridBagConstraints();
        right.weightx = 20.0;
        right.anchor = GridBagConstraints.WEST;
        right.fill = GridBagConstraints.HORIZONTAL;
        right.gridwidth = GridBagConstraints.REMAINDER;

        panel.add(messageLabel, left);
        panel.add(messageTextField, right);
        panel.add(submitButton, left);
        panel.add(chooseBackgroundColorButton, right);
        panel.add(chooseFontColorButton, left);
        panel.add(exitButton, right);
    }
    private class backgroundColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            backgroundColor = JColorChooser.showDialog(null,
                    "Choose background Color", Color.white);

        }
    }
    private class fontColorListioner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            fontColor = JColorChooser.showDialog(null,
                    "Choose Font Color", Color.white);

        }
    }
    private class exitButtonListioner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    private class submitButtonListioner implements ActionListener {

        public void actionPerformed (ActionEvent e){
            String input = messageTextField.getText();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setBackground(backgroundColor);
            frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
            frame.add(new movingText(input));
            frame.setVisible(true);
        }
        private class movingText extends JPanel {
            private String message;
            int x = 0, y = 100;
            movingText(String msg){
                message = msg;
            }
            public void paint(Graphics graphics){
                super.paint(graphics);
                Graphics2D gd2d = (Graphics2D)graphics;
                gd2d.setFont(new Font("Bold", Font.BOLD,22));
                graphics.drawString(message, x, y);
                try{
                    Thread.sleep(100);
                    x+=15;
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                if (x > getWidth()){
                    x = 0;
                }
                repaint();
            }
        }
    }

}