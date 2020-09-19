package ru.geekbrains.javahomework.homework5;

public class Dog extends Animal {

    public static final double DOG_RUN_RESTRICTION = 500;
    public static final double DOG_SWIM_RESTRICTION = 10;
    public static final double DOG_JUMP_RESTRICTION = 0.5;

    public Dog(String name) {
        super(name,
                DOG_RUN_RESTRICTION,
                DOG_SWIM_RESTRICTION,
                DOG_JUMP_RESTRICTION);
    }
}
