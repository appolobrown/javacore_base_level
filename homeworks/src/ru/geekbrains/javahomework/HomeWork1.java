package ru.geekbrains.javahomework;
/*
*
1. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с плавающей точкой,
*  где a, b, c, d – целочисленные входные параметры этого метода;
2. Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
* если да – вернуть true, в противном случае – false;
3. Написать метод, которому в качестве параметра передается целое число,
*  метод должен проверить положительное ли число передали, или отрицательное. Замечание: ноль считаем положительным числом.
* Результат работы метода вывести в консоль
4. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
* метод должен вернуть приветственное сообщение «Привет, переданное_имя!»; Вывести приветствие в консоль.
5. Написать метод, который определяет является ли год високосным. Каждый 4-й год является високосным, кроме каждого 100-го,
* при этом каждый 400-й – високосный. Для проверки работы вывести результаты работы метода в консоль
* */

public class HomeWork1 {

    public static void main(String[] args) {

        //1
        System.out.println(countWithFormula(2, 3, 4, 5));
        //2
        System.out.println(isInRange(10, 11));
        //3
        System.out.println(checkPositive(0));
        //4
        helloName("переданное_имя");
        //5
        int year = 2020;
        String leap = isYearLeap(year) ? "високосный" : "не високосный";
        System.out.println(year + " " + leap + " год");
    }

    // 1
    private static double countWithFormula(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    // 2
    private static boolean isInRange(int a, int b) {
        int minRange = 10;
        int maxRange = 20;
        int sum = a + b;
        return sum >= minRange && sum <= maxRange;
    }

    //3
    private static String checkPositive(int a) {
        return a >= 0 ? "положительное" : "отрицательное";
    }

    //4
    private static void helloName(String name) {
        System.out.println("Привет, " + name + "!");
    }

    //5
    private static boolean isYearLeap(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) return true;
            } else return true;
        }
        return false;


    }
}

