package com.javarush.test.level15.lesson12.home05;


public class SubSolution extends Solution {
    public SubSolution() {
    }

    public SubSolution(int x, String string) {
        super(x, string);
    }

    public SubSolution(Double x) {
        super(x);
    }

     SubSolution(int i) {
        super(i);
    }

     SubSolution(Integer integer) {
        super(integer);
    }

     SubSolution(Object o) {
        super(o);
    }


    protected SubSolution(String name) {
        super(name);
    }

    protected SubSolution(int i, int j) {
        super(i, j);
    }

    protected SubSolution(String string, String str) {
        super(string, str);
    }

    private SubSolution (short q){}
    private SubSolution(Integer i, Double d){}
    private SubSolution(long l){}
}
