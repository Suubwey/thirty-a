package thirtya;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameGUIClicker implements ActionListener {
    private int clicks = 0;
    private JLabel label = new JLabel("Clicks Per Second");
    private JFrame frame = new JFrame();
    private int count;
    private long timeOfLastClick = 0;
    private double totalTime;

    public JFrameGUIClicker() {

        // the clickable button
        JButton button = new JButton("Click Me");
        button.addActionListener(this);

        // the panel with the button and text
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
    }

    // process the button clicks
    public void actionPerformed(ActionEvent e) {
        long timeOfClick = System.nanoTime();
        if (timeOfLastClick != 0) {
            count++;
            double timeDiff = (timeOfClick - timeOfLastClick) / (double) 1000000000;
            totalTime += timeDiff;
            label.setText("Clicks Per Second: " + Math.pow(totalTime / count, -1));
        }
        timeOfLastClick = timeOfClick;
    }

    // create one Frame
    public static void main(String[] args) {
        new JFrameGUIClicker();
    }
}