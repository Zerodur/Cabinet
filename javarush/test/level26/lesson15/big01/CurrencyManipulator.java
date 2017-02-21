package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Zerodur on 27.07.2016.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations;
    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        this.denominations = new HashMap<Integer, Integer>();
    }
    public void addAmount(int denomination, int count){
        if(denominations.containsKey(denomination)){
            denominations.put(denomination, denominations.get(denomination) + count);
        }
        else{
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount(){
        try
        {
            int sum = 0;
            Iterator <Map.Entry<Integer, Integer>> manipulatorIterator = denominations.entrySet().iterator();
            while (manipulatorIterator.hasNext())
            {
                Map.Entry<Integer, Integer> pair = manipulatorIterator.next();
                sum += pair.getKey() * pair.getValue();
            }
            return sum;
        }catch (Exception e){
            ConsoleHelper.writeMessage("No money");
        }
        return 0;
    }
    public boolean  hasMoney()
    {
        boolean result=true;
        if (denominations.isEmpty()) result = false;
        else {
            int zerosCount=0;
            for (Map.Entry<Integer,Integer> pair : denominations.entrySet()){
                if (pair.getValue()==0) zerosCount++;
            }
            if (zerosCount==denominations.size()) result=false;
        }
        return result;
    }
    public boolean isAmountAvailable(int expectedAmount){
        if (expectedAmount <= getTotalAmount()){
            return true;
        }
        return false;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount)throws NotEnoughMoneyException
    {
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
        sortedMap.putAll(denominations);

        HashMap<Integer, Integer> resMap = new HashMap<>();


        for (Integer i : sortedMap.descendingKeySet())
        {
            int denom = i;

            if (denom <= expectedAmount)
            {
                int count = expectedAmount / denom;
                expectedAmount -= denom * count;
                resMap.put(denom, count);
                if (expectedAmount == 0)
                {
                    break;
                }
                if (expectedAmount < 0)
                    throw new  NotEnoughMoneyException();
            }
        }
        if (expectedAmount > 0)
            throw new NotEnoughMoneyException();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet())
        {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (resMap.containsKey(key))
            {
                if (value - resMap.get(key) != 0)
                    map.put(key, value - resMap.get(key));

            }
            else
                map.put(key, value);
        }
        denominations = map;
        return resMap;
    }
}
