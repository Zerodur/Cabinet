package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.*;
import java.util.*;

public class Solution {
    static Map<String, Double> map = new TreeMap<String, Double>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()){
           putData(reader.readLine());
        }

        System.out.println(toString(map));

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

    public static String toString(Map<String, Double> map){
        String str ="";
        for (Map.Entry<String, Double> pair : map.entrySet()){
            str += pair.getKey() + " " + pair.getValue() + "\n";
        }
        return str;
    }
}
