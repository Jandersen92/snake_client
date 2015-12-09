package gui;

import logic.Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NewGame extends JPanel {

    private JButton btnBack;
    private  JButton btnStart;
    private JComboBox combPendning;
    private JTextField pendningGames;
    private JTextField opponentControls;
    private JLabel lblopponentControls;
    private JLabel lblgameId;
    private JLabel lblCbs;


    /**
     * Create the panel.
     */
    public NewGame() {

        setForeground(Color.BLACK);
        setBackground(new Color(74, 105, 168));
        setLayout(null);

        JLabel lblNewGame = new JLabel("New Game");
        lblNewGame.setForeground(Color.WHITE);
        lblNewGame.setFont(new Font("Verdana", Font.BOLD, 25));
        lblNewGame.setBounds(150, 20, 200, 30);
        add(lblNewGame);


        lblCbs = new JLabel(new ImageIcon(Logic.class.getResource("/Png/CBS2.gif")));
        lblCbs.setForeground(Color.white);
        lblCbs.setBounds(1, 1, 70, 70);
        add(lblCbs);

        JLabel lblLine = new JLabel("__________________________");
        lblLine.setForeground(Color.white);
        lblLine.setFont(new Font("Verdana", Font.BOLD, 25));
        lblLine.setBounds(0, 39, 500, 50);
        add(lblLine);


        btnStart = new JButton("Start");
        btnStart.setBounds(160, 220, 120, 30);
        btnStart.setActionCommand("Start");
        add(btnStart);

        lblgameId = new JLabel("Type in the Game Id");
        lblgameId.setForeground(Color.WHITE);
        lblgameId.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblgameId.setBounds(140, 100, 300, 20);
        add(lblgameId);

        pendningGames = new JTextField();
        pendningGames.setToolTipText("type in game ID");
        pendningGames.setBounds(110, 120, 231, 30);
        add(pendningGames);
        pendningGames.setColumns(10);


        lblopponentControls = new JLabel("type in controlbutton for opponent");
        lblopponentControls.setForeground(Color.WHITE);
        lblopponentControls.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblopponentControls.setBounds(100, 170, 300, 20);
        add(lblopponentControls);


        opponentControls = new JTextField();
        opponentControls.setToolTipText("type in opponents control");
        opponentControls.setBounds(110, 190, 231, 30);
        add(opponentControls);
        opponentControls.setColumns(10);


        btnBack = new JButton("Back");
        btnBack.setBounds(160, 260, 120, 30);
        btnBack.setActionCommand("Back");
        add(btnBack);

    }


    public  String getopponentControls(){
        return opponentControls.getText();
    }

    public String getPendingGames(){
        return(String) combPendning.getSelectedItem();
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnStart() {
        return btnStart;
    }

    public void NewGameAL(ActionListener a)
    {
        btnStart.addActionListener(a);
        btnBack.addActionListener(a);
    }
}
