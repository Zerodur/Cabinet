package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileIn = new FileReader(reader.readLine());
        FileWriter fileOut = new FileWriter(reader.readLine());

        while (fileIn.ready()){
            int data = fileIn.read();
            if (data == '.') fileOut.write('!');
            else fileOut.write(data);
        }

        reader.close();
        fileIn.close();
        fileOut.close();
    }
}
