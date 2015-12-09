package gui;

import logic.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Menu extends JPanel {

    private JLabel lblMenu;
    private JButton btnNewGame;
    private JButton btnHighScore;
    private JButton btnCreateGame;
    private JButton btnDeleteGame;
    private JButton btnLogOut;
    private JLabel lblCbs;

    /**
     * Creates the Menu panel.
     */
    public Menu() {

        setForeground(Color.BLACK);
        setBackground(new Color(74, 105, 168));
        setBounds(100, 100, 668, 395);
        setLayout(null);


        lblCbs = new JLabel(new ImageIcon(Logic.class.getResource("/Png/CBS2.gif")));
        lblCbs.setForeground(Color.white);
        lblCbs.setBounds(1, 1, 70, 70);
        add(lblCbs);

        lblMenu = new JLabel("Menu");
        lblMenu.setForeground(Color.WHITE);
        lblMenu.setFont(new Font("Verdana", Font.BOLD, 25));
        lblMenu.setBounds(185, 20, 85, 50);
        add(lblMenu);

        JLabel lblLine = new JLabel("__________________________");
        lblLine.setForeground(Color.white);
        lblLine.setFont(new Font("Verdana", Font.BOLD, 25));
        lblLine.setBounds(0, 39, 500, 50);
        add(lblLine);

        /**
         * Creates all the buttons on the Menu panel and defines a specific action command to each.
         */
        btnNewGame = new JButton("New Game");
        btnNewGame.setFont(new Font("Verdana", Font.PLAIN, 15));
        btnNewGame.setForeground(Color.BLACK);
        btnNewGame.setBounds(0, 100, 112, 100);
        btnNewGame.setActionCommand("New Game");
        add(btnNewGame);

        btnHighScore = new JButton("High Score");
        btnHighScore.setFont(new Font("Verdana", Font.PLAIN, 15));
        btnHighScore.setBounds(113, 100, 112, 100);
        btnHighScore.setActionCommand("High Score");
        add(btnHighScore);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setFont(new Font("Verdana", Font.PLAIN, 15));
        btnCreateGame.setBounds(226, 100, 112, 100);
        btnCreateGame.setActionCommand("Create Game");
        add(btnCreateGame);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setFont(new Font("Verdana", Font.PLAIN, 15));
        btnDeleteGame.setBounds(337, 100, 112, 100);
        btnDeleteGame.setActionCommand("Delete Game");
        add(btnDeleteGame);

        btnLogOut = new JButton("Log Out");
        btnLogOut.setFont(new Font("Verdana", Font.PLAIN, 15));
        btnLogOut.setBounds(165, 230, 120, 50);
        btnLogOut.setActionCommand("Log Out");
        add(btnLogOut);

    }

    /**
     * Adds ActionListener to each of the buttons.
     */
    public void MenuAL(ActionListener a)
    {
        btnNewGame.addActionListener(a);
        btnHighScore.addActionListener(a);
        btnDeleteGame.addActionListener(a);
        btnLogOut.addActionListener(a);
        btnCreateGame.addActionListener(a);
    }

}
