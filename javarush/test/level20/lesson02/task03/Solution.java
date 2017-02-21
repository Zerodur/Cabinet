package com.javarush.test.level20.lesson02.task03;


import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();


    public void fillInPropertiesMap() throws Exception{
        //implement this method - реализуйте этот метод
        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
        InputStream propRead = new FileInputStream(fileName.readLine());

        load(propRead);

        fileName.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties conf = new Properties();
        for (Map.Entry<String, String> pair : properties.entrySet()){
            conf.setProperty(pair.getKey(), pair.getValue());
        }

        conf.store(outputStream,"NO COMMENTS");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод

        Properties conf = new Properties();
        conf.load(inputStream);

        for (Map.Entry pair : conf.entrySet()){
            properties.put((String)pair.getKey(), (String)pair.getValue());
        }

        inputStream.close();
    }
}
