package com.javarush.test.level08.lesson08.task02;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.StreamHandler;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        HashSet<Integer> setRoot = createSet();

        removeAllNumbersMoreThan10(setRoot);

    }
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(2); set.add(3); set.add(5); set.add(6); set.add(7); set.add(8); set.add(9); set.add(10);
        set.add(11); set.add(12); set.add(13); set.add(14); set.add(15); set.add(16); set.add(17); set.add(0);
        set.add(1); set.add(21); set.add(22); set.add(23);
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext())
        {
            if (iterator.next() > 10)
            {
                iterator.remove();
            }
        }
        return set;
    }
}
