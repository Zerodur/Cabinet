package com.javarush.test.level05.lesson05.task02;

public class EpicFight
{
    public static void main(String[] args) throws NoSuchMethodError
    {
        Cat cat1 = new Cat("Kuzya", 3, 5, 5);
        Cat cat2 = new Cat("Lysyi", 7, 3, 4);

        if (cat1.fight(cat2))System.out.println ("WIN!!!");
        else System.out.println("LOOSE:((");

    }
}