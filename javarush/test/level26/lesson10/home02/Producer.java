package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

/**
 * Created by Zerodur on 27.07.2016.
 */
public class Producer implements Runnable
{
    protected ConcurrentHashMap map;

    public Producer(ConcurrentHashMap map) {
        this.map = map;
    }

    @Override
    public void run() {
        int count = 1;

        Thread thread = Thread.currentThread();
        try
        {
            while (map.isEmpty())
            {
                System.out.printf("Some text for %d", count++);
                System.out.println();
                Thread.sleep(500);
            }
        }catch(InterruptedException e)
        {
            System.out.printf("[%s] thread was terminated]", thread.getName());
        }

    }
}
