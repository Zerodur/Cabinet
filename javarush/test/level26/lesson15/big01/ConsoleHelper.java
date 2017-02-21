package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Zerodur on 27.07.2016.
 */
public class ConsoleHelper
{
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws InterruptOperationException{
        String line = null;
        try{
            line = reader.readLine();
            if (line.equalsIgnoreCase("exit"))
                throw new InterruptOperationException();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return line;
    }
    public static String askCurrencyCode()throws InterruptOperationException{
        writeMessage("Input currency code:");
        String code;
        while(true){
            code = readString();
            if(code.length() == 3){
                break;
            }
            writeMessage("Wrong currency code. Input currency code:");
        }
        return code.toUpperCase();
    }
    public static Operation askOperation() throws InterruptOperationException
    {
        while (true){
            try
            {
                ConsoleHelper.writeMessage("Choose operation");
                return Operation.getAllowableOperationByOrdinal(Integer.valueOf(readString()));
            }catch (IllegalArgumentException e){
                ConsoleHelper.writeMessage("Incorrect operation");
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode)throws InterruptOperationException{
        String[] res;
        while(true){
            writeMessage("Input your denomination and count money:");
            try{
                res = readString().split(" ");
                if(res.length == 2 && Integer.parseInt(res[0])> 0 && Integer.parseInt(res[1])> 0){
                    break;
                }
                writeMessage("Incorrect data!");
            }
            catch (NumberFormatException e){
                writeMessage("Incorrect data!");
            }
        }
        return res;
    }
}
