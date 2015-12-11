package logic;

import com.google.gson.Gson;
import gui.Screen;
import spil.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by johanandersen on 29/11/2015.
 */
public class Logic {
    /**
     * variables used in the class.
     */
    private Screen screen;
    private ServerConnect serverConnect;
    private User currentUser;
    private Api api;
    private Game newGame;


    public Logic()
    {
        /**
         * Initializing the variables.
         */
        screen = new Screen();
        screen.setVisible(true);

        currentUser = new User();
        serverConnect = new ServerConnect();
        api = new Api();
        newGame = new Game();
    }


    public void run()
    {
        /**
         * This Method is used to start the application
         * and adds the ActionListeners from the GUI class.
         */
        screen.getLogin().LogInAL(new LoginActionListener());
        screen.getMenu().MenuAL(new MenuActionListener());
        screen.getNewgame().NewGameAL(new NewGameActionListener());
        screen.getHighscore().HighScoreAL(new HighScoreActionListener());
        screen.getDeletegame().DeleteGameAL(new DeleteGameActionListener());
        screen.getLogin().ExitAL(new ExitActionListener());
        screen.getSignup().SignUpAL(new SignUpActionListener());
        screen.getCreategame().CreateGameAL(new CreateGameActionListener());
    }

    /**
     * the method "deleteGame" is used to delete a game from the Database.
     * When the delete button is pressed the game status chances from open to deleted.
     * To delete a game we a calling the method from the Api class.
     * @return
     */
    public String deleteGame(){
        int gameID = screen.getDeletegame().getGameID();

        String message = api.deleteGame(gameID);
        JOptionPane.showMessageDialog(screen, message, "delete",
                1,new ImageIcon(Logic.class.getResource("/Png/snake2.png")));
        if (message.equals("game was deleted")){
            screen.show(screen.MENU);
        }
        if (message.equals("Failed. game was not deleted")){
            screen.show(screen.DELETE_GAME);
            JOptionPane.showMessageDialog(screen, message, "delete",
                    1, new ImageIcon(Logic.class.getResource("/Png/snake2.png")));
        }

        return message;
    }

    /**
     *This method "createGame is used til add a game to our database.
     *
     */

    public String createGame(){
        if (!screen.getCreategame().getGameName().equals("") &&
                !screen.getCreategame().getGameControls().equals("")){

            Gamer host = new Gamer();
            host.setId(currentUser.getId());
            host.setControls(screen.getCreategame().getGameControls());

            Game game = new Game();
            game.setName(screen.getCreategame().getGameName());
            game.setHost(host);
            game.setMapSize(55);

            String messageParser = api.createGame(game);


                JOptionPane.showMessageDialog(screen, "game was created","create",
                        1,new ImageIcon(Logic.class.getResource("/Png/snake2.png")));
                return messageParser;
        }
        else
            JOptionPane.showMessageDialog(screen, "Something went wrong!","Error",
                    1,new ImageIcon(Logic.class.getResource("/Png/snake2.png")));
        return "";
    }


    /**
     * This method is used when we wish to add a user to our database.
     * for being able to do this, we need to call the post method: serverConnect.users.
     */

    public boolean createUser() {

        String firstName = screen.getSignup().getFirstName();
        String lasName = screen.getSignup().getLastName();
        String email = screen.getSignup().getEmail();
        String username = screen.getSignup().getUsername();
        String password = screen.getSignup().getPassword();
        int type = 1;

        if (!firstName.equals("") && !lasName.equals("") && !username.equals("") &&
                !password.equals("") && !email.equals("")) {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lasName);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setType(type);

            String json = new Gson().toJson(user);

            String message = serverConnect.messageParser(serverConnect.post(json, "users/"));
            System.out.println(message);
            JOptionPane.showMessageDialog(screen, message,"signup",
                    1,new ImageIcon(Logic.class.getResource("/Png/snake2.png")));
            if (message.equals("user was created")) {
                return true;
            } else if (message.equals("Username or email already exsits")) {
                JOptionPane.showMessageDialog(screen, message, "signup",
                        1, new ImageIcon(Logic.class.getResource("/Png/snake2.png")));

            } else if (message.equals("Error in JSON")) {
                JOptionPane.showMessageDialog(screen, message, "signup",
                        1, new ImageIcon(Logic.class.getResource("/Png/snake2.png")));

            }

        } else JOptionPane.showMessageDialog(screen,"missing information");
        return false;
    }

    /**
     * this class is used to handle the EXIT Button at the logIn screen.
     * When the button is pressed it runs a system.exit() which kills the program.
     */
    public class ExitActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent f) {
            String action = f.getActionCommand();
            JOptionPane.showMessageDialog(screen, "bye and have a good day!", "Exit",
                    1,new ImageIcon(Logic.class.getResource("/Png/snake2.png")));
            if (action.equals("Exit")) {
                System.exit(0);
            }
        }
    }

    /**
     * This class handle al the ActionListeners at the LOG_IN screen,  except the Exit button
     * If Login is pressed it show the MENU an sets the user as currentUser.
     * If signUp is pressed the program wil show the SignUp window.
     */
    public class LoginActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            currentUser.setUsername(screen.getLogin().getUserName());
            currentUser.setPassword(screen.getLogin().getPassword());

            String message = api.login(currentUser);
            if (message.equals("Login successful")) {
                screen.show(screen.MENU);
                screen.getLogin().clearTextFields();
                JOptionPane.showMessageDialog(screen, message, "Login",
                        1,new ImageIcon(Logic.class.getResource("/Png/snake2.png")));
            }
            else if( message.equals("Wrong username or password")){
                JOptionPane.showMessageDialog(screen, message, "Login",
                        1,new ImageIcon(Logic.class.getResource("/Png/snake2.png")));
            }
            else if (message.equals("Unknown error. Please contact Henrik Thorn at: henrik@itkartellet.dk")){
                JOptionPane.showMessageDialog(screen, message, "Login",
                        1,new ImageIcon(Logic.class.getResource("/Png/snake2.png")));
            }
            else if (e.getSource() == screen.getLogin().getBtnSignUp()) {
                screen.show(screen.SIGN_UP);
            }
        }
    }

    /**
     * This Class handle all the ActionListeners from the MENU.
     * For instance if "new Game" is pressed user will be sent to the NEW_GAME screen and so on.
     */

    public class MenuActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            switch (action) {
                case "High Score":
                    screen.getCl().show(screen.getContentPane(), screen.HIGH_SCORE);
                    break;
                case "New Game":
                    screen.getCl().show(screen.getContentPane(), screen.NEW_GAME);
                    break;
                case "Delete Game":
                    screen.getCl().show(screen.getContentPane(), screen.DELETE_GAME);
                    break;
                case "Create Game":
                    screen.getCl().show(screen.getContentPane(), screen.CREATE_GAME);
                    break;
                case "Log Out":
                    screen.getCl().show(screen.getContentPane(), screen.LOG_IN);
                    break;
                default:
                    screen.getCl().show(screen.getContentPane(), screen.MENU);
                    break;
            }
        }
    }


    /**
     * class to handle the ActionListeners from the New Game screen.
     */
    public class NewGameActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
          if (e.getSource() == screen.getNewgame().getBtnStart()){
                screen.show(screen.MENU);
                Game startGame = null;

                for (Game g  : api.getOpenGames()){
                    if (screen.getNewgame().getPendingGames().equals(g.getName())){
                        startGame = g;
                    }
                }
                startGame.getOpponent().setControls(screen.getNewgame().getopponentControls());
                api.joinGame(startGame);
                api.startGame(startGame);
                for (User u : api.getUsers()){
                    if (u.getId() == startGame.getWinner().getId()) {

                        startGame.getWinner().setUsername(u.getUsername());
                    }
                }
            }
            else if (e.getSource() == screen.getNewgame().getBtnBack()){
                screen.getCl().show(screen.getContentPane(), screen.MENU);
            }
        }
    }

    /**
     * class to handle the ActionListeners from the HighScore screen.
     */
    public class HighScoreActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            if (action.equals("Back1")) {
                screen.getCl().show(screen.getContentPane(), screen.MENU);
            }
        }
    }

    /**
     * class to handle the ActionListeners from the Delete Game screen.
     */
    public class DeleteGameActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                if (e.getSource() == screen.getDeletegame().btnDeleteGame()){
                    deleteGame();
                }
                if (e.getSource() == screen.getDeletegame().btnBack2()){
                    screen.show(screen.MENU);
                }
            }
        }


    /**
     * class to handle the ActionListeners from the Sign Up screen.
     */
    public class SignUpActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == screen.getSignup().getBtnCreate()) {
                createUser();
            }
            if (e.getSource() == screen.getSignup().getBtnBack3()) {
                screen.show(screen.LOG_IN);
                screen.getSignup().clearTextFields();
            }
        }
    }

    /**
     * class to handle the ActionListeners from the Create Game screen.
     */
    public class CreateGameActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == screen.getCreategame().getBtnCreateGame()){
                createGame();
                screen.show(screen.MENU);

            }
            if (e.getSource()== screen.getCreategame().getBtnBack4()){
                screen.show(screen.MENU);
            }
        }
    }

}
