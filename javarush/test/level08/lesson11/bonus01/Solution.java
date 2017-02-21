package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, String> month = new HashMap<Integer, String>();
        month.put(0, "January"); month.put(1, "February"); month.put(2, "March");
        month.put(3, "April"); month.put(4, "May"); month.put(5, "June");
        month.put(6, "July"); month.put(7, "August"); month.put(8, "September");
        month.put(9, "October"); month.put(10, "November"); month.put(11, "December");

        String str = reader.readLine();
        for (Map.Entry<Integer, String> map : month.entrySet())
        {
            if (map.getValue().equals(str))
            {
                System.out.println(str + " is " + (map.getKey() + 1) + " month");
                break;
            }
        }
    }

}
