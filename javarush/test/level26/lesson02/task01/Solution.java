package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        final double mediana;
        if (array.length % 2 == 0){
            mediana = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
        }else mediana = array[(int)Math.round(array.length / 2)];

        Comparator<Integer> integerComparator = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double a = Math.abs(o1 - mediana), b = Math.abs(o2 - mediana);
                if (a == b){
                    return a > b ? -1 : 1;
                }
                if (a > b) return 1;
                return -1;

            }
        };

        Arrays.sort(array, integerComparator);
        return array;
    }
}
