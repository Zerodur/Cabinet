package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileIn = new FileInputStream(reader.readLine());
        FileOutputStream fileOut = new FileOutputStream(reader.readLine());

        while (fileIn.available() > 0){
            byte[] buffer = new byte[100];
            int count = fileIn.read(buffer);
            for (int i = 1; i <= count; i += 2){
                fileOut.write(buffer[i]);
            }
        }

        reader.close();
        fileIn.close();
        fileOut.close();

    }
}
