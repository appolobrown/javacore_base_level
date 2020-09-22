package ru.geekbrains.javahomework.homework6;

import java.io.*;
import java.util.Scanner;


public class Main {

    public static final String LINE_SEPARATOR = "\n";

    public static final String FIRST_TXT = "first.txt";
    public static final String SECOND_TXT = "second.txt";
    public static final String CONCATENATED_TXT = "concatenated.txt";
    public static final String WORDSDIR = "wordsdir";

    public static void main(String[] args) {

        File workdir = createWorkDir();

        FileGenerator fileGenerator = new FileGenerator();
        File file1 = fileGenerator.generateFile(WORDSDIR, FIRST_TXT);
        File file2 = fileGenerator.generateFile(WORDSDIR, SECOND_TXT);
        //1
        File concatenated = concatenateFiles(file1, file2);
        //2
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        if (isWordExistsInFile(word, concatenated)) {
            System.out.printf("Word %s exists in file %s \n", word, concatenated.getPath());
        }
        //3
        if (isWordExistsInFile(word, workdir)) {
            System.out.printf("Word %s exists in directory %s \n", word, workdir.getPath());
        }

    }

    private static File createWorkDir() {
        File directory = new File(WORDSDIR);
        if (!directory.exists()) directory.mkdir();
        return directory;
    }

    private static File concatenateFiles(File first, File second) {
        File concatenated = new File(WORDSDIR, CONCATENATED_TXT);
        if (!concatenated.exists()) {
            try {
                concatenated.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        copyText(first, concatenated);
        copyText(second, concatenated);
        return concatenated;
    }

    private static void copyText(File from, File to) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(from));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(to, true))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.write(LINE_SEPARATOR);

            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isWordExistsInFile(String word, File file) {

        if (file.isDirectory()) for (File listFile : file.listFiles()) {
            if (isWordExistsInFile(word, listFile)) return true;
        }
        else {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.contains(word)) return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
