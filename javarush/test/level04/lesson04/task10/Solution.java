package com.javarush.test.level04.lesson04.task10;

/* Три числа
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
Пример для чисел 1 2 2:
2 2
Пример для чисел 2 2 2:
2 2 2
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String x1 = reader.readLine();
        String x2 = reader.readLine();
        String x3 = reader.readLine();
        int n1 = Integer.parseInt(x1);
        int n2 = Integer.parseInt(x2);
        int n3 = Integer.parseInt(x3);
        if (n1 == n2 && n2 == n3) {
            System.out.print(n1 + " " + n2 + " " + n3);
        } else if (n1 == n2) {
            System.out.print(n1 + " " + n2);
        } else if (n2 == n3) {
            System.out.print(n2 + " " + n3);
        } else  if (n1 == n3)
            System.out.println(n1 + " " + n3);
    }
 }
