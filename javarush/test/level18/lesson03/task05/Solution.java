package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileIn = new FileInputStream(reader.readLine());
        reader.close();

        HashSet<Integer> set = new HashSet<Integer>();

        while (fileIn.available() > 0){
            set.add(fileIn.read());
        }

        while (!set.isEmpty()){
            int minCount = set.iterator().next();
            for (Integer i : set){
                if (i < minCount){
                    minCount = i;
                }
            }
            System.out.print(minCount + " ");
            set.remove(minCount);
        }
    }
}
