package com.javarush.test.level14.lesson06.home01;


public class RussianHen extends Hen {

    @Override
    protected int getCountOfEggsPerMonth() {
        return 10;
    }

    @Override
    protected String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.RUSSIA
                + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
