package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Zerodur on 16.08.2016.
 */
public class Advertisement
{
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = initialAmount / hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
        if (hits <= 0)
            throw new UnsupportedOperationException();
        else {
            hits--;
            initialAmount -= amountPerOneDisplaying;
            amountPerOneDisplaying = (hits == 0) ? 0 : (initialAmount / hits + (initialAmount % hits > 0 ? 1 : 0));
        }
    }
    public int getHits(){
        return this.hits;
    }
    public double getAmountPerSecond() {
        return (double)amountPerOneDisplaying / duration;
    }
}
