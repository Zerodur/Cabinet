package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grDadName = reader.readLine();
        Cat grandDad = new Cat(grDadName);

        String grandMomName = reader.readLine();
        Cat grandMom = new Cat(grandMomName);

        String dadName = reader.readLine();
        Cat dad = new Cat(dadName, grandDad, null);

        String momName = reader.readLine();
        Cat mom = new Cat(momName,null, grandMom);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, dad, mom, grandDad, grandMom);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, dad, mom, grandDad, grandMom);

        System.out.println(grandDad);
        System.out.println(grandMom);
        System.out.println(dad);
        System.out.println(mom);
        System.out.println(catSon);
        System.out.println(catDaughter);
    }

    public static class Cat
    {
        private String name;
        private Cat grandDad, grandMom, dad, mom;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat grandDad, Cat grandMom)
        {
            this.name = name;
            this.dad = grandDad;
            this.mom = grandMom;
        }

        Cat(String name, Cat dad, Cat mom, Cat grandDad, Cat grandMom)
        {
            this.name = name;
            this.dad = dad;
            this.mom = mom;
            this.grandDad = grandDad;
            this.grandMom = grandMom;
        }

        @Override
        public String toString()
        {
            if (dad == null & mom == null)
                return "Cat name is " + name + ", no mother, no father";
            if (mom == null)
                return "Cat name is " + name + ", no mother, father is " + dad.name;
            else if (dad == null)
                return "Cat name is " + name + ", mother is " + mom.name + ", no father";
            else
                return "Cat name is " + name + ", mother is " + mom.name + ", father is " + dad.name;
        }
    }

}
