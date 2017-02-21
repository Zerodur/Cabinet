package com.javarush.test.level14.lesson06.home01;

public class BelarusianHen extends Hen{

    @Override
    protected int getCountOfEggsPerMonth() {
        return 100;
    }

    @Override
    protected String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.BELARUS
                + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
