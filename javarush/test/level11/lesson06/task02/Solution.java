package com.javarush.test.level11.lesson06.task02;

/* Домашние животные
Написать три класса: Pet (домашнее животное), Cat(кот) и Dog(собака).
Унаследовать кота и собаку от животного.
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public class Pet
    {
        int weight;
    }

    public class Cat extends Pet
    {
        String puh;
    }

    public class Dog extends Pet
    {
        String roar;
    }
}
