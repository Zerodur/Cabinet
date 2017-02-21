package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        String countb = buf.readLine();
        int count = Integer.parseInt(countb);
        while (count != -1)
        {
            sum += count;
            countb = buf.readLine();
            count = Integer.parseInt(countb);
        }
        System.out.println(sum - 1);
    }
}
