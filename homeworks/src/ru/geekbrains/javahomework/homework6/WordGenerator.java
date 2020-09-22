package ru.geekbrains.javahomework.homework6;

import java.util.Random;

public class WordGenerator {

    private static final String[] words = {
            "this", "is", "words",
            "used", "in", "homework",
            "to", "generate", "file",
            "cat", "dog", "duck"
    };

    public String getRandomWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}
