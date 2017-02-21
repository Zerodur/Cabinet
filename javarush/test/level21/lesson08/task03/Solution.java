package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException
    {
        A a = new A(1, 1);
        B b = new B(2, 2, "this B");
        C c = new C(3, 3, "this C");
        //B bClone = b.clone();
        A aClone = a.clone();
        C cClone = c.clone();
    }
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
        public A clone() throws CloneNotSupportedException
        {
            return (A) super.clone();
        }

    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public B clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B implements Cloneable{
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        public C clone(){
            return new C(super.getI(), super.getJ(), super.getName());
        }
    }
}
