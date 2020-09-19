package ru.geekbrains.javahomework.homework5;

public class Cat extends Animal {


    public static final double CAT_RUN_RESTRICTION = 200;
    public static final double CAT_SWIM_RESTRICTION = 0;
    public static final double CAT_JUMP_RESTRICTION = 2;

    public Cat(String name) {
        super(name,
                CAT_RUN_RESTRICTION,
                CAT_SWIM_RESTRICTION,
                CAT_JUMP_RESTRICTION);
    }
}
