package com.javarush.test.level18.lesson10.bonus02;

/* ������
CrUD ��� ������� ������ �����
������� � ������� ��� ����� ��� �������� CrUD
��������� ����������� �� ��������� ������� ����������:
-c productName price quantity
�������� ����������:
��� id - 8 ��������
productName - �������� ������, 30 chars (60 bytes)
price - ����, 8 ��������
quantity - ����������, 4 �������
-c  - ��������� ����� � ��������� ����������� � ����� �����, ���������� id ��������������, ������������� ������������ id, ��������� � �����

� ����� ������ �������� � ��������� ������������������ (��� ����������� ��������):
id productName price quantity
������ ��������� ��������� �� �� �����

������:
19846   ����� ������� �����           159.00  12
198478  ����� ������� ������ � �������173.00  17
19847983������ ��� �������������, ����10173.991234
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


