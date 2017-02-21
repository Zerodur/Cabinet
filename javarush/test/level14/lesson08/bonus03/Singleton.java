package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Zerodur on 04.09.2016.
 */
class Singleton {
    private static Singleton instance;
    private Singleton() {

    }
    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}
