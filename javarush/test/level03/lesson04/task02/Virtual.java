package com.javarush.test.level03.lesson04.task02;

/**
 * Created by Zerodur on 09.11.2016.
 */
public class Virtual
{
    public static void main(String[] args)
    {
        A a = new A();
        a.printLine();
        a = new B();
        a.printLine();
    }
    public static class A{
        public void printLine(){
            System.out.println("methodA");
        }
    }

    public static class B extends A{
        public void printLine(){
            System.out.println("methodB");
        }
    }
}
