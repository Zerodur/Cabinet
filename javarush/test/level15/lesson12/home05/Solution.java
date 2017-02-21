package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution (){}
    public Solution(int x, String string){}
    public Solution(Double x){}

     Solution (int i){}
     Solution(Integer integer){}
     Solution(Object o){}

    protected Solution(String name){}
    protected Solution(int i, int j){}
    protected Solution(String string,String str){}

    private Solution (short q){}
    private Solution(Integer i, Double d){}
    private Solution(long l){}

}

