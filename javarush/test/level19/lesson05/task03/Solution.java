package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(new FileReader(reader.readLine()));
        FileWriter fileOut = new FileWriter(reader.readLine());


        while(scanner.hasNext()){
            String str = scanner.next();
            if (isDigit(str)) fileOut.write(str + " ");
        }

        reader.close();
        scanner.close();
        fileOut.close();
    }
    public static boolean isDigit(String str){
        char[] chars = str.toCharArray();
        for (char ch : chars){
            if (ch < 48 || ch > 57){
                return false;
            }
        }
        return true;
    }
}
