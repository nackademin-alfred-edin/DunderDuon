import javax.swing.JOptionPane;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
class login {

    static String goodPassword = new String();

    static String username;
    static String email;
    static String number;

    static boolean checkPasswordLength(String pass) {
        if (pass.length() < 8) {
            System.out.println("Password is too short, min 8 täcken");
            return false;
        } else {
            return true;
        }
    }

    static boolean checkPasswordStrength(String pass) {
        char letter;
        boolean upperFlag = false;
        boolean lowerFlag = false;
        boolean numberFlag = false;

        for(int i=0; i < pass.length(); i++) {
            letter = pass.charAt(i);
            if(Character.isDigit(letter)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(letter)) {
                upperFlag = true;
            }
            else if (Character.isLowerCase(letter)) {
                lowerFlag = true;
            }
            if (upperFlag && lowerFlag && numberFlag) {
                return true;
            }
        }
        System.out.println("Password must contain uppercase, lowercase and number");
        return false;
    }

    static String getPasswordInput() {
        String pass = new String();
        pass = JOptionPane.showInputDialog(null , "Enter password", "Password", JOptionPane.QUESTION_MESSAGE);

        return pass;
    }




    // public void actionPerformed(ActionEvent e) {
    //     getUserInfo();
    // }

    
    static void startWindow() {

        JFrame loginWindow = new JFrame("Hello");

        JLabel userLbl = new JLabel("Username: ");
        JTextField userTf = new JTextField(15);
        userLbl.setLabelFor(userTf);

        JLabel passwordLbl = new JLabel("Password: ");
        JPasswordField passwordTf = new JPasswordField(15);
        passwordLbl.setLabelFor(passwordTf);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(50, 40, 95, 30);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(50, 100, 95, 30);
        
        registerButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                getUserInfo();  
        }});

        JPanel panel = new JPanel();

        panel.add(userLbl);
        panel.add(userTf);
        panel.add(passwordLbl);
        panel.add(passwordTf);
        panel.add(loginButton);
        panel.add(registerButton);

        loginWindow.add(panel);
        loginWindow.setSize(200, 200);
        loginWindow.setVisible(true);
        loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static List<String> getUserInfo() {

        JTextField usernameField = new JTextField(10);
        JTextField emailField = new JTextField(10);
        JTextField numberField = new JTextField(10);

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Username: "));
        myPanel.add(usernameField);
        myPanel.add(new JLabel("E-mail: "));
        myPanel.add(emailField);
        myPanel.add(new JLabel("Phonenumber: "));
        myPanel.add(numberField);

        int result = JOptionPane.showConfirmDialog(null, myPanel, "GIMMIE", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            username = usernameField.getText();
            email = emailField.getText();
            number = numberField.getText();
            passwordLoop();
            hashPass();
        }
        List<String> userInfo = List.of(username, email, number);
        return userInfo;

    }

    static String passwordLoop() {
        while (true) {
            String pass;
            pass = getPasswordInput();
            if (checkPasswordLength(pass) == true) {
                if (checkPasswordStrength(pass) == true) {

                    goodPassword = pass;
                    System.out.println("password is good");

                    break;
                }
            }
        }
        return goodPassword;
    }
    static String hashPass(){
        String hashedPassword = hash.getMd5(goodPassword);
        System.out.println(hashedPassword);
        return hashedPassword;
        
    }


    public static void main(String[] args) {
        startWindow();
        
    }

}
