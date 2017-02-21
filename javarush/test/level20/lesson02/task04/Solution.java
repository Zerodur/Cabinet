package com.javarush.test.level20.lesson02.task04;

import java.io.*;
import java.util.Properties;

/* Читаем и пишем в файл статики
Реализуйте логику записи в файл и чтения из файла для класса ClassWithStatic
Метод load должен инициализировать объект включая статические поля данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

           // File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("e:\\prop.properties");
            InputStream inputStream = new FileInputStream("e:\\prop.properties");

            ClassWithStatic classWithStatic = new ClassWithStatic();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();

            ClassWithStatic loadedObject = new ClassWithStatic();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            //check here that classWithStatic object equals to loadedObject object - проверьте тут, что classWithStatic и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class ClassWithStatic {
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            Properties config = new Properties();
            config.setProperty("staticString", staticString);
            config.setProperty("i", String.valueOf(this.i));
            config.setProperty("j", String.valueOf(this.j));
            config.store(outputStream, "NO COMMENTS");
            outputStream.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            Properties config = new Properties();
            config.load(inputStream);
            staticString = config.getProperty("staticString");
            this.i = Integer.valueOf(config.getProperty("i"));
            this.j = Integer.valueOf(config.getProperty("j"));
        }
    }
}
