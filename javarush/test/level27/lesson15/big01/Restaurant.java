package com.javarush.test.level27.lesson15.big01;


import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.io.IOException;

/**
 * Created by Zerodur on 14.08.2016.
 */
public class Restaurant
{
    public static void main(String[] args) throws IOException
    {
        Waitor waitor = new Waitor();
        Cook cook = new Cook("Amigo");
        cook.addObserver(waitor);

        Tablet tablet = new Tablet(5);
        tablet.addObserver(cook);
        tablet.createOrder();

    }
}
