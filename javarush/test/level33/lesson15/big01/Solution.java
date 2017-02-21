package com.javarush.test.level33.lesson15.big01;

import com.javarush.test.level33.lesson15.big01.strategies.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Date;
/**
 * Created by Zerodur on 19.11.2016.
 */
public class Solution
{
    public static void main(String[] args)
    {

        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
        testStrategy(new HashMapStorageStrategy(), 10000);
        testStrategy(new FileStorageStrategy(), 100);
        testStrategy(new HashBiMapStorageStrategy(),10000);
        testStrategy(new OurHashBiMapStorageStrategy(),10000);
    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings){
        Set<Long> set = new HashSet<>();
        for (String str : strings){
            set.add(shortener.getId(str));
        }
        return set;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys){
        Set<String> set = new HashSet<>();
        for (Long key : keys){
            set.add(shortener.getString(key));
        }
        return set;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber){
        Shortener shortener = new Shortener(strategy);
        Helper.printMessage(strategy.getClass().getSimpleName());
        Set<String> strings = new HashSet<>();
        for(int i = 0; i < elementsNumber; i++){
            strings.add(Helper.generateRandomString());
        }
        Date startTime = new Date();
        Set<Long> iDs = getIds(shortener, strings);
        Date finishTime = new Date();
        Long result = new Long(finishTime.getTime() - startTime.getTime());
        Helper.printMessage(result.toString());
        startTime = new Date();
        Set<String> newStrings = getStrings(shortener, iDs);
        finishTime = new Date();
        result = new Long(finishTime.getTime() - startTime.getTime());
        Helper.printMessage(result.toString());

        if (newStrings.equals(strings)){
            Helper.printMessage("Тест пройден.");
        }else Helper.printMessage("Тест не пройден.");
    }
}
