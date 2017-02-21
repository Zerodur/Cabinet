package com.javarush.test.level14.lesson06.home01;


public abstract class Hen {
    protected abstract int getCountOfEggsPerMonth();
    protected String getDescription(){
        return "Я курица.";
    }
}
