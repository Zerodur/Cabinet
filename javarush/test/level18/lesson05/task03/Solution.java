package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileIn = new FileInputStream(reader.readLine());
        FileOutputStream fileOut = new FileOutputStream(reader.readLine());

        int dataSize = fileIn.available();
        byte[] data;
        if (dataSize % 2 == 0){
            data = new byte[dataSize / 2];
        }else data = new byte[dataSize / 2 + 1];

        fileIn.read(data);
        fileOut.write(data);

        data = new byte[fileIn.available()];
        fileIn.read(data);
        fileOut = new FileOutputStream(reader.readLine());
        fileOut.write(data);

        reader.close();
        fileIn.close();
        fileOut.close();

    }
}
