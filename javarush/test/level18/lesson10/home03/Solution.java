package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        FileInputStream inputStreamOne = new FileInputStream(reader.readLine());
        FileInputStream inputStreamTwo = new FileInputStream(reader.readLine());



        while (inputStreamOne.available() > 0){
            outputStream.write(inputStreamOne.read());
        }

        while (inputStreamTwo.available() > 0){
            outputStream.write(inputStreamTwo.read());
        }

        reader.close();
        inputStreamOne.close();
        inputStreamTwo.close();
        outputStream.close();

    }
}
