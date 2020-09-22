package ru.geekbrains.javahomework.homework6;

import java.io.*;

import static java.lang.Character.LINE_SEPARATOR;

public class FileGenerator {

    public static final int LINES = 10;
    public static final int WORDS_IN_LINE = 5;

    public File generateFile(String path, String filename) {

        File file = new File(path, filename);

        WordGenerator wordGenerator = new WordGenerator();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < LINES; i++) {
                for (int j = 0; j < WORDS_IN_LINE; j++) {
                    bufferedWriter.write(wordGenerator.getRandomWord() + " ");
                }
                bufferedWriter.write(LINE_SEPARATOR);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}

