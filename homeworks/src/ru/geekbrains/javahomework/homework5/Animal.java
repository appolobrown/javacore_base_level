package ru.geekbrains.javahomework.homework5;

import java.util.Random;

public abstract class Animal {

    private static final double[] randomCoefficients = {0.75, 0.85, 1, 1.15, 1.25};

    private final double runRestriction;
    private final double swimRestriction;
    private final double jumpRestriction;

    private final String name;

    boolean run(double distance) {
        return distance <= runRestriction;
    }

    boolean swim(double distance) {
        return distance <= swimRestriction;
    }

    boolean jump(double height) {
        return height <= jumpRestriction;
    }

    public Animal(String name, double runRestriction, double swimRestriction, double jumpRestriction) {
        this.name = name;
        this.runRestriction = getAmountWIthRandomCoefficient(runRestriction);
        this.swimRestriction = getAmountWIthRandomCoefficient(swimRestriction);
        this.jumpRestriction = getAmountWIthRandomCoefficient(jumpRestriction);
    }

    private double getAmountWIthRandomCoefficient(double amount) {
        Random random = new Random();
        return amount * randomCoefficients[random.nextInt(randomCoefficients.length - 1)];

    }

    public double getRunRestriction() {
        return runRestriction;
    }

    public double getSwimRestriction() {
        return swimRestriction;
    }

    public double getJumpRestriction() {
        return jumpRestriction;
    }

    public String getName() {
        return name;
    }

    public String getAnimalCapabilities() {
        return String.format("Max values for this %s is: run:%.02f m, jump:%.02f m, swim:%.02f m.\n",
                getClass().getSimpleName(),
                getRunRestriction(),
                getJumpRestriction(),
                getSwimRestriction());
    }
}
