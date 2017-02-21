package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<String>();

        //напишите тут ваш код
        int n, m;
        n = Integer.valueOf(reader.readLine());
        m = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++){
            list.add(reader.readLine());
        }

        String buf;
        for (int i = 0; i < m; i++){
            buf = list.get(0);
            list.remove(0);
            list.add(buf);
        }

        for (String str : list){
            System.out.println(str);
        }
    }
}
