package thirtya;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUILogin implements ActionListener {

    private static JLabel label;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;
    private static int attempts;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(100, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        label = new JLabel("User");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(new GUILogin());
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = new String(passwordText.getPassword());
        System.out.println(user + ", " + password);
        if (attempts < 3) {
            if (user.equals("Jun") && password.equals("ILoveMyLittlePony")) {
                success.setText("Login Successful");
            } else {
                success.setText("Login Failed");
                success.setText("You have " + (3 - attempts) + " attempt(s) left to enter the password.");
                attempts++;
            }
        }
        else {
            if (user.equals("Jun") && password.equals("ILoveMyLittlePony")) {
                success.setText("Login Successful");
            } else {
                label.setVisible(false);
                userText.setVisible(false);
                passwordLabel.setVisible(false);
                passwordText.setVisible(false);
                button.setVisible(false);
                success.setBounds(10, 20, 300, 25);
                success.setText("You have ran out of attempts.");
            }
        }
    }
}
