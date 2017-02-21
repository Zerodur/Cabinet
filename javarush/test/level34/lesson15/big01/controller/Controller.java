package com.javarush.test.level34.lesson15.big01.controller;

import com.javarush.test.level34.lesson15.big01.model.Model;
import com.javarush.test.level34.lesson15.big01.view.View;

/**
 * Created by Zerodur on 09.12.2016.
 */
public class Controller
{
    private View view;
    private Model model;

    public Controller()
    {
        model = new Model();
        view = new View(this);
        view.init();
    }

    public static void main(String[] args)
    {
        Controller controller = new Controller();
    }
}
