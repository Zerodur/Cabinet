package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Zerodur on 11.10.2016.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}
