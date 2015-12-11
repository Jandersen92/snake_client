package gui;

import logic.Logic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by sverreostgaard on 27.11.15.
 */
public class HighScore extends JPanel {

    private JButton btnBack1;
    private JButton btnshow;
    private JTable table;
    private JLabel lblCbs;

    /**
     * Create the panel.
     */
    public HighScore() {

        setForeground(Color.BLACK);
        setBackground(new Color(74, 105, 168));
        setLayout(null);

        JLabel lblHighScore = new JLabel("High Score");
        lblHighScore.setForeground(Color.WHITE);
        lblHighScore.setFont(new Font("Verdana", Font.BOLD, 25));
        lblHighScore.setBounds(165, 20, 200, 50);
        add(lblHighScore);

        lblCbs = new JLabel(new ImageIcon(Logic.class.getResource("/Png/CBS2.gif")));
        lblCbs.setForeground(Color.white);
        lblCbs.setBounds(1, 1, 70, 70);
        add(lblCbs);

        JLabel lblLine = new JLabel("__________________________");
        lblLine.setForeground(Color.white);
        lblLine.setFont(new Font("Verdana", Font.BOLD, 25));
        lblLine.setBounds(0, 39, 500, 50);
        add(lblLine);

        btnshow = new JButton("load highscore");
        btnshow.setBounds(160, 270, 120, 30);
        btnshow.setActionCommand("Back1");
        add(btnshow);

        btnBack1 = new JButton("Back");
        btnBack1.setBounds(160, 300, 120, 30);
        btnBack1.setActionCommand("Back1");
        add(btnBack1);

        table = new JTable(new DefaultTableModel(new Object[]{"username", "score"}, 0));
        table.setBounds(40, 100, 367, 170);
        add(table);

    }
    /**
     * Sets the ActionListener for the the back button.
     */

    public void HighScoreAL(ActionListener a)
    {
        btnBack1.addActionListener(a);
        btnshow.addActionListener(a);
    }

}
