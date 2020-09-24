package ru.geekbrains.javahomework.homework_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WIDTH = 507;
    private static final int HEIGHT = 555;
    private static final int POS_X = 650;
    private static final int POS_Y = 250;

    private Map map;

    public GameWindow() throws HeadlessException {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(POS_X, POS_Y);
        setTitle("TicTacToeGame");
        setResizable(false);
//        setLocationRelativeTo(null);
        SettingsWindow settingsWindow = new SettingsWindow(this);
        JButton buttonStart = new JButton("Start");
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });
//        buttonStart.setPreferredSize(new Dimension(0,200));
        JButton buttonStop = new JButton("Stop");
        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new GridLayout(1, 2));
        panelBottom.add(buttonStart);
        panelBottom.add(buttonStop);
        map = new Map();

        add(map, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void acceptSettings(int gameMode, int fieldSize, int winSize) {
        map.startNewGame(gameMode, fieldSize, fieldSize, winSize);
    }
}
