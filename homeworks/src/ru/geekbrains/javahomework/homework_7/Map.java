package ru.geekbrains.javahomework.homework_7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {

    public static final int MODE_H_VS_H = 0;
    public static final int MODE_H_VS_AI = 1;

    private static final String TIC = "X";
    private static final String TAC = "O";
    private static boolean turn = false;

    public Map() {
        setBackground(Color.BLACK);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLen) {
        GridLayout gameGrid = new GridLayout(fieldSizeX, fieldSizeY);
        this.setLayout(gameGrid);
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                JButton button = new JButton();
                button.addActionListener(e -> printTicTacOnButton(button));
                this.add(button);
            }
        }
        this.setVisible(false);
        this.setVisible(true);
        System.out.printf("mode:%d size:%d win:%d \n", gameMode, fieldSizeX, winLen);
    }

    private void printTicTacOnButton(JButton button) {
        if (button.getText() == null || "".equals(button.getText())) {
            if (turn) button.setText(TIC);
            else button.setText(TAC);
            turn = !turn;
            button.setEnabled(false);
        }
    }
}
