package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        reader.close();

        Map<Integer, Integer> mapList = new HashMap<Integer, Integer>();

        while (file.available() > 0){
            int data = file.read();
            if (mapList.containsKey(data)){
                int count = mapList.get(data);
                count++;
                mapList.put(data, count);
            }else mapList.put(data, 1);
        }
        file.close();

        int minCount = mapList.entrySet().iterator().next().getValue();

        for (Map.Entry<Integer, Integer> pair :mapList.entrySet()){
            if (pair.getValue() < minCount){
                minCount = pair.getValue();
            }
        }


        for (Map.Entry<Integer, Integer> pair : mapList.entrySet()){
            if (pair.getValue() == minCount){
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}
