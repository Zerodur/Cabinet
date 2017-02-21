package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

import java.util.HashSet;

public class Solution {
    public static HashSet<String> listParts = new HashSet<String>();
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String strForRead = reader.readLine();
        String fileName = strForRead.substring(0, strForRead.lastIndexOf("part") - 1);

        while (!strForRead.equals("end")){
            partsToList(strForRead);
            strForRead = reader.readLine();
        }

        FileOutputStream fileWriter = new FileOutputStream(fileName);

        for (int i = 1; i <= listParts.size(); i++){
            FileInputStream fileReader = new FileInputStream(fileName + ".part" + String.valueOf(i));
            while(fileReader.available() > 0){
                byte[] bufer = new byte[100];
                int count = fileReader.read(bufer);
                fileWriter.write(bufer, 0, count);
            }
            fileReader.close();
        }

        reader.close();
        fileWriter.close();
    }

    static void partsToList (String str){
        listParts.add(str.substring(str.lastIndexOf("part")));
    }
}
