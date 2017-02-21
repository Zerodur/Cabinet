package com.javarush.test.level03.lesson04.task02;

/* 4 скобки
Расставить правильно (по другому) скобки, чтобы на экран вывелось число 850
*/

public class Solution
{
    public static void main(String[] args)
    {
        int i = 5;
        i = ++i + ++i;
        System.out.println(i);
    }
}