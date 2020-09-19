package ru.geekbrains.javahomework.homework5;

/*
Создать классы Собака и Кот с наследованием от класса Животное.
Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
В качестве параметра каждому методу передается величина, означающая или длину препятствия
(для бега и плавания), или высоту (для прыжков).
У каждого животного есть ограничения на действия (
бег: кот 200 м., собака 500 м.;
прыжок: кот 2 м., собака 0.5 м.;
плавание: кот не умеет плавать, собака 10 м.).
При попытке животного выполнить одно из этих действий, оно должно сообщить результат.
(Например, dog1.run(150); -> результат: 'Пёсик пробежал!')
Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
*/

public class Main {

    public static final int RUN_DISTANCE = 200;
    public static final double JUMP_HEIGHT = 0.4;
    public static final double SWIM_DISTANCE = 5.3;

    public static void main(String[] args) {

        Animal[] animals = getAnimals();

        for (Animal animal : animals) {
            if (animal.run(RUN_DISTANCE))
                printResults(animal, "runned", RUN_DISTANCE);
            if (animal.jump(JUMP_HEIGHT))
                printResults(animal, "jumped", JUMP_HEIGHT);
            if (animal.swim(SWIM_DISTANCE))
                printResults(animal, "swimmed", SWIM_DISTANCE);
            System.out.println(animal.getAnimalCapabilities());
        }
    }

    private static void printResults(Animal animal, String competition, double distance) {
        System.out.printf("%s %s has %s %.02f m\n",
                animal.getClass().getSimpleName(), animal.getName(), competition, distance);
    }

    private static Animal[] getAnimals() {
        return new Animal[]{
                new Dog("Vulkan"),
                new Dog("Polkan"),
                new Dog("Druzhok"),
                new Cat("Tishka"),
                new Cat("Murzik"),
                new Cat("Vasiliy")};
    }
}
