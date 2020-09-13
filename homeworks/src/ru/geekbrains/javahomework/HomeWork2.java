package ru.geekbrains.javahomework;
/*
1 Задать целочисленный массив, состоящий из элементов 0 и 1.
Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
2 Задать пустой целочисленный массив размером 8. Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
заполнить его диагональные элементы единицами, используя цикл(ы);
6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
checkBalance ([10, || 1, 2, 3, 4]) → true. Абстрактная граница показана символами ||, эти символы в массив не входят.
7 *** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным),
при этом метод должен циклически сместить все элементы массива на n позиций.
8 **** Не пользоваться вспомогательным массивом при решении задачи 7.
* */

import java.util.Arrays;
import java.util.Random;

public class HomeWork2 {

    public static void main(String[] args) {
        //1
        int[] randromArray = generateRandomOneZeroArray(10);
        System.out.println("Generated array " + Arrays.toString(randromArray));
        System.out.println("Replaced array " + Arrays.toString(
                replaceElements(randromArray)));
        //2
        int size = 8;
        int[] generatedArray = generateArray(size);
        System.out.println(Arrays.toString(generatedArray));
        //3
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(
                task3(array)));
        //4
        int[][] matrix = generateMatrix(5);
        printMatrix(matrix);
        //5
        int[] randArray = generateRandomArray(10, 100);
        System.out.println("generated " + Arrays.toString(randArray));
        int max = getMax(randArray);
        int min = getMin(randArray);
        System.out.println("Min is " + min + " Max is " + max);
        //6
        int[] ar = {1, 1, 2, 3, 4, 1, 2};
        if (isArrayHasSumDelimiter(ar))
            System.out.println(Arrays.toString(ar) + " has halfsum delimiter");
        //7
        System.out.println("Array is " + Arrays.toString(randArray));
        int n = 3;
        System.out.println("Shifted 3 to the right " + Arrays.toString(moveElements(randArray, n)));
        n = -4;
        System.out.println("Shifted 4 to the left " + Arrays.toString(moveElements(randArray, n)));

    }

    //1
    private static int[] generateRandomOneZeroArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextBoolean() ? 1 : 0;
        }
        return array;
    }


    private static int[] replaceElements(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
        return array;
    }

    //2
    private static int[] generateArray(int size) {
        final int MAGIC_NUMBER = 3;

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = MAGIC_NUMBER * i + 1;
        }
        return array;
    }

    //3
    private static int[] task3(int[] array) {
        final int ANOTHER_MAGIC_NUMBER = 6;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < ANOTHER_MAGIC_NUMBER) array[i] *= 2;
        }
        return array;
    }

    //4
    private static int[] generateRandomArray(int size, int bound) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }

    private static int getMin(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) min = array[i];
        }
        return min;
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }

    //5
    private static int[][] generateMatrix(int size) {
        int[][] matrix = new int[size][size];
        int j = size - 1;
        for (int i = 0; i < size; i++, j--) {
            matrix[i][i] = 1;
            matrix[i][j] = 1;
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //6
    private static boolean isArrayHasSumDelimiter(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        int halfSum = 0;
        for (int j : array) {
            halfSum += j;
            if (halfSum == sum - halfSum) {
                return true;
            }
        }
        return false;
    }

    //7
    //8
    private static int[] moveElements(int[] ints, int iterations) {
        if (iterations > 0) {
            for (int i = 0; i < iterations; i++) {
                int last = ints[ints.length - 1];
                for (int j = ints.length - 1; j > 0; j--) {
                    ints[j] = ints[j - 1];
                }
                ints[0] = last;
            }
        } else {
            for (int i = 0; i > iterations; i--) {
                int first = ints[0];
                for (int j = 0; j <= ints.length - 2; j++) {
                    ints[j] = ints[j + 1];

                }
                ints[ints.length - 1] = first;
            }
        }
        return ints;
    }
}
