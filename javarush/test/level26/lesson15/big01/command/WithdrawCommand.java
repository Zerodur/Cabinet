package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Zerodur on 29.07.2016.
 */
class WithdrawCommand implements Command
{
    ResourceBundle res = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.withdraw_en");
    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        String curCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(curCode);
        int amount;
        while (true)
        {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String s = ConsoleHelper.readString();
            if (s.matches("\\d+"))
            {
                amount = Integer.parseInt(s);

                //----------------------------------------------
                if (manipulator.isAmountAvailable(amount))
                {
                    try
                    {
                        Map<Integer, Integer> result = manipulator.withdrawAmount(amount);

                        for (Map.Entry<Integer, Integer> entry : result.entrySet())
                            ConsoleHelper.writeMessage("\t" + String.format(res.getString("success.format"),entry.getKey(), entry.getValue()));

                        break;
                    }
                    catch (NotEnoughMoneyException e)
                    {
                        ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                    }
                } else
                {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                }
            } else
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
        }
    }
}
