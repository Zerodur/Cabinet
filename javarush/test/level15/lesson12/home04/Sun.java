package com.javarush.test.level15.lesson12.home04;

/**
 * Created by Zerodur on 09.12.2016.
 */
public class Sun implements Planet
{
    private static Sun instance;

    private Sun() {}

    public static Sun getInstance() {
        if(instance == null) {
            instance = new Sun();
        }
        return instance;
    }
}
