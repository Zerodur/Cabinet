package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/


import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    static Set<Item> set = new HashSet<Item>();
    static int lastId = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
        while (fileIn.ready()){
            set.add(new Item(fileIn.readLine()));
        }
        reader.close();
        fileIn.close();
        if (args[0].equals("-c")){
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            Solution.lastId++;
            String lineOut = String.format("%-8d%-30s%-8.2f%-4d", Solution.lastId, args[1],
                                                Double.valueOf(args[2]), Integer.parseInt(args[3]));
            writer.write(lineOut);
            writer.flush();
            writer.close();
        }
    }
    static class Item {
        private int id;
        private String productName;
        private double  price;
        private int quantity;

        public Item(String line){
            this.id = Integer.valueOf(line.substring(0, 8).trim());
            this.productName = line.substring(8, 38).trim();
            this.price = Double.parseDouble(line.substring(38, 46).trim().replace(',', '.'));
            this.quantity = Integer.parseInt(line.substring(46).trim());
            if (id > Solution.lastId) Solution.lastId = id;
        }
    }
}


