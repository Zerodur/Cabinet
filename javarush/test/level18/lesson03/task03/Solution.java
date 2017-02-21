package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
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

        int maxCount = 0;
        for (Map.Entry pair : mapList.entrySet()){
            if ((int)pair.getValue() > maxCount){
                maxCount =(int) pair.getValue();
            }
        }
        for (Map.Entry pair: mapList.entrySet()){
            if((int)pair.getValue() == maxCount){
                System.out.println(pair.getKey());
            }
        }
        file.close();
    }

}
