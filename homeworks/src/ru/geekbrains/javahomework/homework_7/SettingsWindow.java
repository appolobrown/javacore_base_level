package ru.geekbrains.javahomework.homework_7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WIDTH = 350;
    private static final int HEIGHT = 350;
    private static final int MIN_WIN_LEN = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFFIX = "Field size: ";
    private static final String WIN_LEN_PREFFIX = "Win lenght: ";
    private GameWindow gameWindow;
    private JRadioButton humVSAI;
    private JRadioButton humVSHum;
    private JSlider fieldSizeSlider;
    private JSlider winSizeSlider;

    SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(gameWindow);
        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) gameWindowBounds.getCenterX() - WIDTH / 2;
        int posY = (int) gameWindowBounds.getCenterY() - HEIGHT / 2;
        setLocation(posX, posY);
        setResizable(false);
        setTitle("Creating new game");
        setLayout(new GridLayout(10, 1));
        addGameModeControls();
        addFieldControlls();
        JButton buttonStartGame = new JButton("Start game");
        buttonStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectDataFromControllsAndStartGame();
            }
        });
        add(buttonStartGame);
    }

    private void collectDataFromControllsAndStartGame() {
        int gameMode;
        if (humVSAI.isSelected()) {
            gameMode = 0;
        } else if (humVSHum.isSelected()) {
            gameMode = 1;
        } else {
            throw new RuntimeException("unexpected");
        }
        int fieldSize = fieldSizeSlider.getValue();
        int winSize = winSizeSlider.getValue();

        gameWindow.acceptSettings(gameMode, fieldSize, winSize);
        setVisible(false);
    }

    private void addFieldControlls() {
        JLabel fieldSizeLabel = new JLabel(FIELD_SIZE_PREFFIX + MIN_FIELD_SIZE);
        JLabel winSizeLabel = new JLabel(WIN_LEN_PREFFIX + MIN_WIN_LEN);

        fieldSizeSlider = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        winSizeSlider = new JSlider(MIN_WIN_LEN, MIN_FIELD_SIZE, MIN_FIELD_SIZE);

        fieldSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int current = fieldSizeSlider.getValue();
                winSizeSlider.setMaximum(current);
                fieldSizeLabel.setText(FIELD_SIZE_PREFFIX + fieldSizeSlider.getValue());
            }
        });
        winSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                winSizeLabel.setText(WIN_LEN_PREFFIX + winSizeSlider.getValue());
            }
        });
        add(new JLabel("Choose field size"));
        add(fieldSizeLabel);
        add(fieldSizeSlider);
        add(new JLabel("Choose win size"));
        add(winSizeLabel);
        add(winSizeSlider);
    }

    private void addGameModeControls() {
        add(new JLabel("Choose Game mode"));
        humVSAI = new JRadioButton("Human vs AI", true);
        humVSHum = new JRadioButton("Human vs Human");
        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humVSAI);
        gameMode.add(humVSHum);
        add(humVSAI);
        add(humVSHum);
    }
}
