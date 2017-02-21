package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] ar = new int[3];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ar[0] = Integer.valueOf(reader.readLine());
        ar[1] = Integer.valueOf(reader.readLine());
        ar[2] = Integer.valueOf(reader.readLine());
        int buf;
        for (int i = 0; i < ar.length - 1; i++){
            for (int j = i + 1; j < ar.length; j++){
                if (ar[i] < ar[j]){
                    buf = ar[i];
                    ar[i] = ar[j];
                    ar[j] = buf;
                }
            }
        }

        for (int elem : ar){
            System.out.println(elem);
        }

    }
}
