package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.ArrayList;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(Integer.parseInt(reader.readLine()));
        list.add(Integer.parseInt(reader.readLine()));
        list.add(Integer.parseInt(reader.readLine()));

        int min = list.get(0);
        for (int num : list)
        {
            if (num < min) min = num;
        }
        list.remove(list.indexOf(min));
        if (list.get(0) > list.get(1)) System.out.println(list.get(1));
        else System.out.println(list.get(0));
    }
}
