package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Zerodur on 18.04.2016.
 */
public class Mouse implements CompItem {
    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
