package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList<String>[] array = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
          ArrayList<String> list = new ArrayList<String>();
          list.add("Elem1");
          list.add("Elem2");
          list.add("Elem3");
          list.add("Elem4");
          list.add("Elem5");
          array[i] = list;
        }
        return array;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}