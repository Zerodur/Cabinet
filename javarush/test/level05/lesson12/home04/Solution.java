package com.javarush.test.level05.lesson12.home04;

/* Вывести на экран сегодняшнюю дату
Вывести на экран текущую дату в аналогичном виде "21 02 2014".
*/

import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        SimpleDateFormat curDate = new SimpleDateFormat();
        curDate.applyPattern("dd MM yyyy");
        System.out.println(curDate.format(new Date()));
    }
}