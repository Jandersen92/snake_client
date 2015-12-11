package gui;

import logic.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by sverreostgaard on 27.11.15.
 */
public class DeleteGame extends JPanel {

    private JButton btnBack2;
    private JLabel lbldelete;
    private JTextField GameDelete;
    private JButton btnDeleteGame;
    private JLabel lblCbs;
    private JLabel lblLine;

    private int gameID;

    /**
     * Create the panel.
     */
    public DeleteGame() {

        setForeground(Color.BLACK);
        setBackground(new Color(74, 105, 168));
        setLayout(null);

        JLabel lblDeleteGame = new JLabel("Delete Game");
        lblDeleteGame.setForeground(Color.WHITE);
        lblDeleteGame.setFont(new Font("Verdana", Font.BOLD, 25));
        lblDeleteGame.setBounds(150, 20, 200, 50);
        add(lblDeleteGame);


        lblCbs = new JLabel(new ImageIcon(Logic.class.getResource("/Png/CBS2.gif")));
        lblCbs.setForeground(Color.white);
        lblCbs.setBounds(1, 1, 70, 70);
        add(lblCbs);

        lblLine = new JLabel("__________________________");
        lblLine.setForeground(Color.white);
        lblLine.setFont(new Font("Verdana", Font.BOLD, 25));
        lblLine.setBounds(0, 39, 500, 50);
        add(lblLine);


        lbldelete = new JLabel("Enter Game id");
        lbldelete.setForeground(Color.WHITE);
        lbldelete.setFont(new Font("Verdana", Font.PLAIN, 14));
        lbldelete.setBounds(155, 140, 180, 20);
        add(lbldelete);

        GameDelete = new JTextField();
        GameDelete.setToolTipText("type in the ID of the game you wish to delete");
        GameDelete.setFont(new Font("Verdana", Font.PLAIN, 13));
        GameDelete.setBounds(120, 160, 220, 30);
        add(GameDelete);
        GameDelete.setColumns(10);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setFont(new Font("Verdana", Font.PLAIN, 14));
        btnDeleteGame.setBounds(175, 240, 120, 30);
        btnDeleteGame.setActionCommand("deleteGame");
        add(btnDeleteGame);

        btnBack2 = new JButton("Back");
        btnBack2.setFont(new Font("Verdana", Font.PLAIN, 14));
        btnBack2.setBounds(175, 280, 120, 30);
        btnBack2.setActionCommand("Back2");
        add(btnBack2);
    }


    /**
     * get-methods for the buttons: deleteGame, and Back2.
     */

    public JButton btnDeleteGame()
    {
        return btnDeleteGame;
    }

    public JButton btnBack2()
    {
        return btnBack2;
    }

    /**
     *This method convert GetGameID into a String and later to an int.
     */

    public int getGameID()
    {
        String g = GameDelete.getText();
        gameID = Integer.parseInt(g);
        return gameID;
    }

    /**
     * Sets the ActionListener for the deleteGame and the back button.
     */
    public void DeleteGameAL(ActionListener a)
    {
        btnBack2.addActionListener(a);
        btnDeleteGame.addActionListener(a);
    }
}
