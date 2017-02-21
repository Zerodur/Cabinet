package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileIn = new BufferedReader(new FileReader(reader.readLine()));

        int count = 0;
        while (fileIn.ready()){
            String line = fileIn.readLine();
            String[] words = line.split("[., !?;:-]()");
            for (String word : words){
                if (word.equals("world")) count++;
            }
        }
        System.out.println(count);

        reader.close();
        fileIn.close();
    }
}
