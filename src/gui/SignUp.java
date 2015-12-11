package gui;

import logic.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by johanandersen on 03/12/2015.
 */


public class SignUp extends JPanel {

    private JButton btnBack3;
    private JButton btnCreate;
    private JLabel lbLFirstname;
    private JTextField Firstname;
    private JLabel lblLastname;
    private JTextField Lastname;
    private JLabel lblUsername;
    private JTextField Username;
    private JLabel lblPassword;
    private JPasswordField Password;
    private JLabel lblEmail;
    private JTextField Email;
    private JLabel lblCbs;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;


public  SignUp(){
    setForeground(Color.BLACK);
    setBackground(new Color(74, 105, 168));
    setLayout(null);

    JLabel lblSignUp = new JLabel("Sign Up");
    lblSignUp.setForeground(Color.WHITE);
    lblSignUp.setFont(new Font("Verdana", Font.BOLD, 25));
    lblSignUp.setBounds(175, 20, 200, 50);
    add(lblSignUp);

    JLabel lblLine = new JLabel("__________________________");
    lblLine.setForeground(Color.white);
    lblLine.setFont(new Font("Verdana", Font.BOLD, 25));
    lblLine.setBounds(0, 39, 500, 50);
    add(lblLine);

    lblCbs = new JLabel(new ImageIcon(Logic.class.getResource("/Png/CBS2.gif")));
    lblCbs.setForeground(Color.white);
    lblCbs.setBounds(1, 1, 70, 70);
    add(lblCbs);

    lbLFirstname = new JLabel(" Firsname:");
    lbLFirstname.setForeground(Color.WHITE);
    lbLFirstname.setFont(new Font("Verdana", Font.PLAIN, 15));
    lbLFirstname.setBounds(60, 80, 90, 20);
    add(lbLFirstname);

    Firstname = new JTextField();
    Firstname.setToolTipText("type firstname");
    Firstname.setFont(new Font("Verdana", Font.PLAIN, 13));
    Firstname.setBounds(160, 80, 220, 30);
    add(Firstname);
    Firstname.setColumns(10);

    lblLastname = new JLabel(" Lastname:");
    lblLastname.setForeground(Color.WHITE);
    lblLastname.setFont(new Font("Verdana", Font.PLAIN, 15));
    lblLastname.setBounds(60, 120, 90, 20);
    add(lblLastname);

    Lastname = new JTextField();
    Lastname.setToolTipText("Type lastname");
    Lastname.setFont(new Font("Verdana", Font.PLAIN, 13));
    Lastname.setBounds(160, 120, 220, 30);
    add(Lastname);
    Lastname.setColumns(10);

    lblEmail = new JLabel("       Email:");
    lblEmail.setForeground(Color.WHITE);
    lblEmail.setFont(new Font("Verdana", Font.PLAIN, 15));
    lblEmail.setBounds(60, 160, 90, 20);
    add(lblEmail);

    Email = new JTextField();
    Email.setToolTipText("type Email");
    Email.setFont(new Font("Verdana", Font.PLAIN, 13));
    Email.setBounds(160, 160, 220, 30);
    add(Email);
    Email.setColumns(10);

    lblUsername = new JLabel(" Username:");
    lblUsername.setForeground(Color.WHITE);
    lblUsername.setFont(new Font("Verdana", Font.PLAIN, 15));
    lblUsername.setBounds(60, 200, 90, 20);
    add(lblUsername);

    Username = new JTextField();
    Username.setToolTipText("type Username");
    Username.setFont(new Font("Verdana", Font.PLAIN, 13));
    Username.setBounds(160, 200, 220, 30);
    add(Username);
    Username.setColumns(10);

    lblPassword = new JLabel(" Password:");
    lblPassword.setForeground(Color.WHITE);
    lblPassword.setFont(new Font("Verdana", Font.PLAIN, 15));
    lblPassword.setBounds(60, 240, 90, 20);
    add(lblPassword);

    Password = new JPasswordField();
    Password.setToolTipText("type a Password");
    Password.setFont(new Font("Verdana", Font.PLAIN, 13));
    Password.setBounds(160, 240, 220, 30);
    add(Password);
    Password.setColumns(10);


    btnCreate = new JButton("create");
    btnCreate.setBounds(160, 280, 120, 30);
    btnCreate.setActionCommand("create");
    add(btnCreate);

    btnBack3 = new JButton("Back");
    btnBack3.setBounds(385, 300, 38, 26);
    btnBack3.setActionCommand("Back3");
    add(btnBack3);

}
    /**
     * Sets the ActionListener for the the back button.
     */
    public void SignUpAL(ActionListener e)
    {
        btnBack3.addActionListener(e);
        btnCreate.addActionListener(e);
    }

    /**
     * Get methods for textfields.
     */
    public String getFirstName() {
        firstName = Firstname.getText();
        return firstName;
    }

    public String getLastName() {
        lastName = Lastname.getText();
        return lastName;
    }

    public String getUsername() {
        username = Username.getText();
        return username;
    }

    public String getPassword() {
        password = this.Password.getText();
        return password;
    }

    public String getEmail() {
        email = Email.getText();
        return email;
    }

    /**
     * get methods for the back button and the create button.
     */
    public JButton getBtnBack3() {
        return btnBack3;
    }

    public JButton getBtnCreate() {
        return btnCreate;
    }

    /**
     * method to clear textfields ones the new user is registered in the database.
     */
    public void clearTextFields()
    {
        Firstname.setText("");
        Lastname.setText("");
        Username.setText("");
        Password.setText("");
        Email.setText("");
    }
}
