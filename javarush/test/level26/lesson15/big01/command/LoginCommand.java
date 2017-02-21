package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;


/**
 * Created by Zerodur on 07.08.2016.
 */
public class LoginCommand implements Command
{
    ResourceBundle validCreditCards = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.verifiedCards");
    ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.login_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        while (true){
            ConsoleHelper.writeMessage(res.getString("before"));
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String cardNumb = ConsoleHelper.readString();

            String cardPin = ConsoleHelper.readString();
            if (validCreditCards.containsKey(cardNumb)){
                if(validCreditCards.getString(cardNumb).equals(cardPin))
                {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumb));
                    return;
                }
            }
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
        }
    }
}
