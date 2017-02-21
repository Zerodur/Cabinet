package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileIn = new FileInputStream(reader.readLine());
        FileOutputStream fileOut = new FileOutputStream(reader.readLine());

        byte[] data = new byte[fileIn.available()];
        fileIn.read(data);

        for(int i = data.length - 1; i >= 0; i--){
            fileOut.write(data[i]);
        }

        reader.close();
        fileIn.close();
        fileOut.close();
    }
}
