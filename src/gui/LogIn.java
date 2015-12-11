package gui;

import logic.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class LogIn extends JPanel {

    private JLabel lblUsername;
    private JTextField Username;
    private JPasswordField Password;
    private JLabel lblPassword;
    private JButton btnLogIn;
    private JButton btnExit;
    private JButton btnSignUp;
    private JLabel lblWelcome;
    private JLabel lblCbs;
    private JLabel lblLine;

    private String userName;
    private String password;


    /**
     * Creates the Log In panel.
     */
    public LogIn() {

        setForeground(Color.BLACK);
        setBackground(new Color(74, 105, 168));
        setBounds(100, 100, 700, 400);
        setLayout(null);

        lblWelcome = new JLabel("Welcome to Snake");
        lblWelcome.setForeground(Color.white);
        lblWelcome.setFont(new Font("Verdana", Font.BOLD, 25));
        lblWelcome.setBounds(100, 20, 300, 30);
        add(lblWelcome);

        /**
         * lblCbs imports CBS's logo in the upper rigt corner.
         */
        lblCbs = new JLabel(new ImageIcon(Logic.class.getResource("/Png/CBS2.gif")));
        lblCbs.setForeground(Color.white);
        lblCbs.setBounds(1, 1, 70, 70);
        add(lblCbs);

        /**
         * This is just a random line for the looks
         */
        lblLine = new JLabel("__________________________");
        lblLine.setForeground(Color.white);
        lblLine.setFont(new Font("Verdana", Font.BOLD, 25));
        lblLine.setBounds(0, 39, 500, 50);
        add(lblLine);

        lblUsername = new JLabel("Username");
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblUsername.setBounds(160, 100, 90, 20);
        add(lblUsername);


        Username = new JTextField();
        Username.setToolTipText("Insert Username");
        Username.setFont(new Font("Verdana", Font.PLAIN, 13));
        Username.setBounds(160, 120, 140, 30);
        add(Username);
        Username.setColumns(10);

        lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblPassword.setBounds(160, 160, 90, 20);
        add(lblPassword);

        Password = new JPasswordField();
        Password.setToolTipText("Insert Password");
        Password.setBounds(160, 180, 140, 30);
        Password.setColumns(10);
        add(Password);

        /**
         * Creates the Log In button and defines the ActionCommand for it (Log In).
         */
        btnLogIn = new JButton("Log In");
        btnLogIn.setBounds(105, 250, 117, 29);
        btnLogIn.setFont(new Font("Verdana", Font.PLAIN, 15));
        btnLogIn.setActionCommand("Log In");
        add(btnLogIn);

        /**
         * Creates an Exit button and defines the ActionCommand for it (Exit).
         */
        btnExit = new JButton("exit");
        btnExit.setBounds(385, 280, 38, 26);
        btnExit.setFont(new Font("Verdana", Font.PLAIN, 12));
        btnExit.setActionCommand("Exit");
        add(btnExit);


        /**
         * creates a Sign up button and defines the ActionCommand for it (signUp)
         */
        btnSignUp = new JButton("Sign up");
        btnSignUp.setBounds(225, 250, 117, 29);
        btnSignUp.setFont(new Font("Verdana", Font.PLAIN, 12));
        btnSignUp.setActionCommand("Sign Up");
        add(btnSignUp);
    }


    /**
     * Get-methods for username and password.
     */
    public String getUserName() {
        userName = Username.getText();
        return userName;
    }
    public String getPassword() {
        password = Password.getText();
        return password;
    }


    /**
     * Sets the ActionListener for the Log In  and SignUp button.
     */
    public void LogInAL(ActionListener e) {
        btnLogIn.addActionListener(e);
        btnSignUp.addActionListener(e);
    }

    /**
     * Sets the ActionListener for the Exit button.
     */
    public void ExitAL(ActionListener f) {
        btnExit.addActionListener(f);
    }

    public void clearTextFields() {
        Username.setText("");
        Password.setText("");
    }

    /**
     * Get methods for buttons.
     */

    public JButton getBtnSignUp() {
        return btnSignUp;
    }

}


