package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int[] nums = new int[4];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(reader.readLine());
        }
        int max = nums[0];
        for (int num : nums){
            if (num > max) max = num;
        }
        System.out.println(max);
    }
}
