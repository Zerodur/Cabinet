package com.javarush.test.level08.lesson08.task01;


import java.util.HashSet;


/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
       HashSet<String> hs = new HashSet<String>();
        hs.add("Лить"); hs.add("Лужа"); hs.add("Лейка"); hs.add("Лапать"); hs.add("Лысый"); hs.add("Линолеум");
        hs.add("Луна"); hs.add("Лес"); hs.add("Лен"); hs.add("Лопасть"); hs.add("Луг"); hs.add("Лут"); hs.add("Лупа");
        hs.add("Лото"); hs.add("Лерка"); hs.add("Лоза"); hs.add("Лаг"); hs.add("Лето"); hs.add("Лом"); hs.add("Лог");

       return hs;
    }
}
