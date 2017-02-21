package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter extends FileWriter{

    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    @Override
    public void write(int i)throws IOException{
        super.write(i);
        System.out.println(i);
    }

    @Override
    public void write(char [] buf, int off, int len)throws IOException{
        super.write(buf, off, len);
        System.out.println(buf);
    }
}
