package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {

        int spaces = 1; // кол-во пробелов в строке
        StringBuilder sb = new StringBuilder(); // здесь будем собирать подстроку
        if (string == null) // проверка входной строки на null
            throw new TooShortStringException();
        int begin = string.indexOf(" ") + 1; // индекс первого символа после первого пробела
        // если строка из одного слова - begin = 0, далее выбрасывается исключение
        // проходим по строке в поисках четвертого пробела
        for (int i = begin; i < string.length(); i++){
            if (string.charAt(i) == ' ') spaces++;
            sb.append(string.charAt(i));
            if (spaces == 4) { begin = i + 1; break; }
        }

        if (spaces < 4)
            throw new TooShortStringException();

        for (int i = begin; i < string.length(); i++){
            if (string.charAt(i) == ' ') sb.append(string.charAt(i));
            else { begin = i; break; }
        }

        for (int i = begin; i < string.length(); i++) {
            if (string.charAt(i) != ' ') sb.append(string.charAt(i));
            else break;
        }
        return sb.toString();
    }

    public static void main(String[] args)throws TooShortStringException{
        String toCut = "JavaRush -  лучшийсервис обученияJava.";
        //String toCut = "JavaRush - лучший из лучших сервис обучения";
        String cutted = getPartOfString(toCut);
        System.out.println(cutted);
    }

    public static class TooShortStringException extends Exception{

    }
}
