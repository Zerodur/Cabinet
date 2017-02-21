package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Zerodur on 06.09.2016.
 */
public class Client
{
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Wait error");
            return;
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        while (clientConnected) {
            String s;
            if (!(s = ConsoleHelper.readString()).equals("exit")) {
                if (shouldSentTextFromConsole()) {
                    sendTextMessage(s);
                }
            } else {
                return;
            }
        }
    }



    public class SocketThread  extends Thread{

        @Override
        public void run()
        {
            String serverAddres = Client.this.getServerAddress();
            int serverPort = Client.this.getServerPort();
            Socket socket = null;
            try
            {
                socket = new Socket(serverAddres, serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (IOException e)
            {
                e.printStackTrace();
                notifyConnectionStatusChanged(false);
            }catch (ClassNotFoundException e){
                e.printStackTrace();
                notifyConnectionStatusChanged(false);
            }

        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST){
                    String userName = Client.this.getUserName();
                    connection.send(new Message(MessageType.USER_NAME, userName));
                }else if (message.getType() == MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    break;
                }else throw new IOException("Unexpected MessageType");

            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    processIncomingMessage(message.getData());
                }else if (message.getType() == MessageType.USER_ADDED)
                {
                    informAboutAddingNewUser(message.getData());
                }else if (message.getType() == MessageType.USER_REMOVED)
                {
                    informAboutDeletingNewUser(message.getData());
                } else throw new IOException("Unexpected MessageType");
            }
        }

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " is connected.");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " is leave");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this)
            {
                Client.this.notify();
            }
        }
    }

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Enter ip-address or domain address:");
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Enter server port:");
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Enter user name:");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try
        {
            this.connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Error...");
            clientConnected = false;
        }
    }

    public static void main(String[] args)
    {
        new Client().run();
    }
}
