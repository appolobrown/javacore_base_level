package ru.geekbrains.javahomework.homework_7;

import javax.swing.*;
import java.awt.*;

public class Map extends JPanel {

    public static final int MODE_H_VS_H = 0;
    public static final int MODE_H_VS_AI = 1;

    public Map() {
        setBackground(Color.BLACK);
    }

    void startNewGame(int gameMode, int fieldSizeX, int fieldSizeY, int winLen) {
        System.out.printf("mode:%d size:%d win:%d \n", gameMode, fieldSizeX, winLen);
    }
}
