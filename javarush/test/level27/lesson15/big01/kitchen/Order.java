package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zerodur on 14.08.2016.
 */
public class Order
{
    private Tablet tablet;
    private List<Dish> dishes;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
        System.out.println(this.toString());
    }

    @Override
    public String toString()
    {

        if (!isEmpty()){
            String builder = Arrays.toString(dishes.toArray());
            builder = String.format("Your order: %s of Tablet{number=%s}", builder, tablet.getNumber());
            return builder;
        }
        return "";
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }


    public int getTotalCookingTime(){
        int totalTime = 0;
        for (Dish dish : dishes){
            totalTime += dish.getDuration();
        }
        return totalTime;
    }
}
