package com.javarush.test.level21.lesson16.big01;


import java.util.ArrayList;

public class Hippodrome {

    public static Hippodrome game;

    ArrayList<Horse> horses = new ArrayList<Horse>();


    public ArrayList<Horse> getHorses(){
        return this.horses;
    }

    public static void main(String[] args)
    {
        game = new Hippodrome();
        game.getHorses().add(new Horse("Fast", 3, 0));
        game.getHorses().add(new Horse("Black", 3, 0));
        game.getHorses().add(new Horse("White", 3, 0));
        game.run();
        game.printWinner();
    }

    public void run(){
        for (int i = 0; i < 100; i++){
            move();
            print();
            try
            {
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public  void print(){
        for (Horse horse : getHorses()){
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public void move(){
        for (Horse horse : getHorses()){
            horse.move();
        }
    }

    public Horse getWinner(){
        double dis=0;
        Horse winner=null;
        for (Horse horse : game.getHorses())
        {
            if (horse.getDistance() > dis)
            {
                dis = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner(){
        System.out.println(String.format("Winner is %s!", getWinner().getName()));
    }
}
