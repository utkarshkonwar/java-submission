

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {
    private JTextField userText;
    private JPasswordField passwordText;
    private JLabel messageLabel;
    private int attempts = 0;
    private final int MAX_ATTEMPTS = 3;

    public LoginPage() {
       
        setTitle("Login Page");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        
        JLabel userLabel = new JLabel("User ID:");
        userLabel.setBounds(50, 30, 80, 25);
        add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(150, 30, 165, 25);
        add(userText);

      
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 60, 80, 25);
        add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 60, 165, 25);
        add(passwordText);

        
        messageLabel = new JLabel();
        messageLabel.setBounds(50, 120, 300, 25);
        add(messageLabel);

       
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 90, 80, 25);
        add(loginButton);

      
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validateLogin();
            }
        });
    }

    
    private void validateLogin() {
        String userID = userText.getText();
        String password = new String(passwordText.getPassword());

        
        String validUserID = "Kankan";
        String validPassword = "sai263";

       
        if (attempts < MAX_ATTEMPTS) {
            if (userID.equals(validUserID) && password.equals(validPassword)) {
                messageLabel.setText("Login successful!");
                JOptionPane.showMessageDialog(this, "Welcome, " + userID + "!");
            } else {
                attempts++;
                messageLabel.setText("Incorrect login. Attempts left: " + (MAX_ATTEMPTS - attempts));
                if (attempts == MAX_ATTEMPTS) {
                    JOptionPane.showMessageDialog(this, "Maximum login attempts reached!");
                    System.exit(0);  
                }
            }
        }
    }

    public static void main(String[] args) {
       
        LoginPage frame = new LoginPage();
        frame.setVisible(true);
    }
}
