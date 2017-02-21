package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    static Map<String, Double> map = new TreeMap<String, Double>();

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()){
            putData(reader.readLine());
        }

        System.out.println(findMax(map));

        reader.close();
    }

    public static void putData(String line){
        String[] data = line.split(" ");
        if (map.containsKey(data[0])){
            Double value = map.get(data[0]);
            value += Double.valueOf(data[1]);
            map.put(data[0], value);
        }else map.put(data[0], Double.valueOf(data[1]));
    }

   public static String findMax(Map<String,Double> map){
       if (!map.isEmpty())
       {
           Map.Entry<String, Double> fpair = map.entrySet().iterator().next();
           Double maxValue = fpair.getValue();
           String name = fpair.getKey();
           for (Map.Entry<String, Double> pair : map.entrySet())
           {
               if (pair.getValue() > maxValue)
               {
                   maxValue = pair.getValue();
                   name = pair.getKey();
               }
           }
           return name;
       }
       return null;
   }
}
