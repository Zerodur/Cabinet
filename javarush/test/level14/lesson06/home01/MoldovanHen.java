package com.javarush.test.level14.lesson06.home01;


public class MoldovanHen extends Hen{

    @Override
    protected int getCountOfEggsPerMonth() {
        return 5;
    }

    @Override
    protected String getDescription(){
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA
                + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
