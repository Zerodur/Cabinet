package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int p = 0, o = 0;
        //напишите тут ваш код
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++){
            int current = Integer.parseInt(scanner.readLine());
            if (current > 0 && current != 0) p++;
            else if (current < 0 && current != 0) o++;
        }

        System.out.println("количество отрицательных чисел: " + o);
        System.out.println("количество положительных чисел: " + p);
    }
}
