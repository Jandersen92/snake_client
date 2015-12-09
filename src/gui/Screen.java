package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Creates the JFrame in which all the panels (LogIn, Menu) will be arranged in.
 */
public class Screen extends JFrame {


    /**
     * Creates final strings which wil be the names of the different panel components.
     */
    public static final String LOG_IN = "Log In";
    public static final String MENU = "Menu";
    public static final String NEW_GAME = "New Game";
    public static final String HIGH_SCORE = "High Score";
    public static final String DELETE_GAME = "Delete Game";
    public static final String SIGN_UP = "sign up";
    public static final String CREATE_GAME = "create game";

    private JPanel contentPane;
    private LogIn login;
    private Menu menu;
    private NewGame newgame;
    private HighScore highscore;
    private DeleteGame deletegame;
    private SignUp signup;
    private CreateGame creategame;
    private CardLayout cl;



    public Screen() {
        JFrame jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setBounds(400, 200, 500, 400);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout(20, 20));

        /**
         * Creates an object og LogIn and Menu and then adds them to the contentPane (the main panel).
         */
        login = new LogIn();
        contentPane.add(login, LOG_IN);
        menu = new Menu();
        contentPane.add(menu, MENU);
        newgame = new NewGame();
        contentPane.add(newgame, NEW_GAME);
        highscore = new HighScore();
        contentPane.add(highscore, HIGH_SCORE);
        deletegame = new DeleteGame();
        contentPane.add(deletegame, DELETE_GAME);
        signup = new SignUp();
        contentPane.add(signup, SIGN_UP);
        creategame = new CreateGame();
        contentPane.add(creategame, CREATE_GAME);


        cl = (CardLayout) contentPane.getLayout();



        /**
         * Adds the main panel to the JFrame and makes it visible.
         */
        jframe.add(contentPane);
        jframe.setVisible(true);

    }

    /**
     * Get-methods for the main panel, the CardLayout (the layout of our JFrame) and all the other panels.
     */
    public JPanel getContentPane() {
        return contentPane;
    }

    public CardLayout getCl() {
        return cl;
    }

    public LogIn getLogin() {
        return login;
    }

    public Menu getMenu() {
        return menu;
    }

    public NewGame getNewgame() {
        return newgame;
    }

    public HighScore getHighscore() {
        return highscore;
    }

    public DeleteGame getDeletegame() {
        return deletegame;
    }

    public SignUp getSignup(){return signup;}

    public CreateGame getCreategame(){return creategame;}

    public void show(String card) {
        cl.show(this.getContentPane(), card);
    }
}

