package gui;

import logic.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by johanandersen on 04/12/2015.
 */
public class CreateGame extends JPanel {

    private JButton btnBack4;
    private JLabel lblGameName;
    private JTextField GameName;
    private JLabel lblGameControls;
    private JTextField GameControls;
    private JButton btnCreateGame;
    private JLabel lblCbs;

    private String gameName;
    private String gameControls;


    /**
     * Create the panel.
     */
    public CreateGame(){

        setForeground(Color.BLACK);
        setBackground(new Color(74, 105, 168));
        setLayout(null);

        JLabel lblNewGame = new JLabel("Create Game");
        lblNewGame.setForeground(Color.WHITE);
        lblNewGame.setFont(new Font("Verdana", Font.BOLD, 25));
        lblNewGame.setBounds(155, 20, 200, 50);
        add(lblNewGame);

        btnBack4 = new JButton("Back");
        btnBack4.setBounds(175, 280, 120, 30);
        btnBack4.setActionCommand("Back4");
        add(btnBack4);

        lblCbs = new JLabel(new ImageIcon(Logic.class.getResource("/Png/CBS2.gif")));
        lblCbs.setForeground(Color.white);
        lblCbs.setBounds(1, 1, 70, 70);
        add(lblCbs);

        JLabel lblLine = new JLabel("__________________________");
        lblLine.setForeground(Color.white);
        lblLine.setFont(new Font("Verdana", Font.BOLD, 25));
        lblLine.setBounds(0, 39, 500, 50);
        add(lblLine);

        lblGameName = new JLabel("Enter Game Name");
        lblGameName.setForeground(Color.WHITE);
        lblGameName.setFont(new Font("Verdana", Font.PLAIN, 14));
        lblGameName.setBounds(155, 105, 180, 20);
        add(lblGameName);


        GameName = new JTextField();
        GameName.setToolTipText("type the name of the game");
        GameName.setFont(new Font("Verdana", Font.PLAIN, 13));
        GameName.setBounds(120, 120, 220, 30);
        add(GameName);
        GameName.setColumns(10);

        lblGameControls = new JLabel("Enter Game Controls:");
        lblGameControls.setForeground(Color.WHITE);
        lblGameControls.setFont(new Font("Verdana", Font.PLAIN, 14));
        lblGameControls.setBounds(155, 175, 180, 20);
        add(lblGameControls);

        GameControls = new JTextField();
        GameControls.setToolTipText("type the game controls");
        GameControls.setFont(new Font("Verdana", Font.PLAIN, 13));
        GameControls.setBounds(120, 190, 220, 30);
        add(GameControls);
        GameControls.setColumns(10);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setFont(new Font("Verdana", Font.PLAIN, 14));
        btnCreateGame.setBounds(175, 240, 120, 30);
        add(btnCreateGame);

    }

    /**
     * Get-methods for gameControls and gameName.
     */
    public String getGameControls() {
        gameControls = GameControls.getText();
        return gameControls;
    }
    public String getGameName() {
        gameName = GameName.getText();
        return gameName;
    }
    public JButton getBtnCreateGame() {
        return btnCreateGame;
    }

    public JButton getBtnBack4() {
        return btnBack4;
    }

    /**
     * Sets the ActionListener for the "create game"  and back button.
     */
    public void CreateGameAL(ActionListener a)
    {
        btnCreateGame.addActionListener(a);
        btnBack4.addActionListener(a);
    }
}
