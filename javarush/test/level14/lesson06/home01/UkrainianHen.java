package com.javarush.test.level14.lesson06.home01;

public class UkrainianHen extends Hen{

    @Override
    protected int getCountOfEggsPerMonth() {
        return 20;
    }

    @Override
    protected String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.UKRAINE
                + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
