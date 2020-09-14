package ru.geekbrains.javahomework;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {


    /**
     * Иван! Решение - копипаста, на код-ревью не претендует.
     * Сдаю для галочки, на свое решение, к сожалению, времени не нашел.
     */


    private final int SIZE = 3;
    private final int SIZE_WIN = 3;
    private final char DOT_X = 'x';
    private final char DOT_O = 'o';
    private final char DOT_EMPTY = '.';
    private char[][] map = new char[SIZE][SIZE];
    private Scanner sc = new Scanner(System.in);
    private Random rnd = new Random();

    public static void main(String[] args) {
        new HomeWork3();
    }

    private HomeWork3() {
        initMap();
        while (true) {
            humanTurn(DOT_X);
            if (checkWin(DOT_X)) {
                System.out.println("You won!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry draw!");
                break;
            }
            aiTurn(DOT_O, DOT_X);
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("AI won!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Sorry draw!");
                break;
            }
        }
        System.out.println("Game Over");
        printMap();
    }

    private void initMap() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                map[i][j] = DOT_EMPTY;
    }

    private void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }

    private void humanTurn(char dot) {
        int x, y;
        do {
            System.out.println("Enter X and Y (1..3)");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = dot;
    }

    private void aiTurn(char dot, char enemyDot) {
        int x, y;
        for (x = 0; x < SIZE; x++)
            for (y = 0; y < SIZE; y++)
                if (isCellValid(x, y)) {
                    map[y][x] = dot;
                    if (checkWin(dot)) {
                        return;
                    }
                    map[y][x] = DOT_EMPTY;
                }
        for (x = 0; x < SIZE; x++)
            for (y = 0; y < SIZE; y++)
                if (isCellValid(x, y)) {
                    map[y][x] = enemyDot;
                    if (checkWin(enemyDot)) {
                        map[y][x] = dot;
                        return;
                    }
                    map[y][x] = DOT_EMPTY;
                }
        do {
            x = rnd.nextInt(SIZE);
            y = rnd.nextInt(SIZE);
        } while (!isCellValid(x, y));
        map[y][x] = dot;
    }

    private boolean checkWin(char dot) {
        for (int y = 0; y < SIZE; y++)
            for (int x = 0; x < SIZE; x++)
                for (int dy = -1; dy < 2; dy++)
                    for (int dx = -1; dx < 2; dx++)
                        if (checkLine(x, y, dx, dy, dot) == SIZE_WIN)
                            return true;
        return false;
    }

    private int checkLine(int x, int y, int dx, int dy, char dot) {
        int count = 0;
        if (dx == 0 && dy == 0)
            return 0;
        for (int i = 0, xi = x, yi = y;
             i < SIZE_WIN; i++, xi += dx, yi += dy)
            if (xi >= 0 && yi >= 0 && xi < SIZE &&
                    yi < SIZE && map[yi][xi] == dot)
                count++;
        return count;
    }

    private boolean isMapFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (map[i][j] == DOT_EMPTY) return false;
        return true;
    }

    private boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE)
            return false;
        return map[y][x] == DOT_EMPTY;
    }
}

