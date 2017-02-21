package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);

        int countLit = 0;
        while (inputStream.available() > 0){
            int data = inputStream.read();
            if ((data > 64 & data < 91) || (data > 96 & data < 123)){
                countLit++;
            }
        }
        inputStream.close();
        System.out.println(countLit);

    }
}
