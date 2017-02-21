package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;


/**
 * Created by Zerodur on 29.07.2016.
 */
class ExitCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.exit_en");
    @Override
    public void execute()throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String answer = ConsoleHelper.readString();
        if (res.getString("yes").equalsIgnoreCase(answer.trim()))
            ConsoleHelper.writeMessage(res.getString("thank.message"));
            throw new InterruptOperationException();
    }
}
