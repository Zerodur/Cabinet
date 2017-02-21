package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Zerodur on 15.08.2016.
 */
public class Cook extends Observable implements Observer
{
    public String name;
    public List<Observer> listWaitors = new ArrayList<Observer>();

    public Cook(String name)
    {
        this.name = name;
    }

    public String toString(){
        return this.name;
    }

    @Override
    public void update(Observable observable, Object arg)
    {
        Order order = (Order)arg;
        int cookingTime = order.getTotalCookingTime();
        System.out.println("Start cooking - " + arg + ", cooking time " + cookingTime
                + "min");
        setChanged();
        notifyObservers(arg);
    }
}
