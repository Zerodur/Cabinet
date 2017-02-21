package com.javarush.test.level33.lesson15.big01.strategies;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Zerodur on 20.11.2016.
 */
public class FileBucket
{
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile("tmp", null);
        }
        catch (IOException e) {
           e.printStackTrace();
        }
        path.toFile().deleteOnExit();
    }


    public long getFileSize(){
        return path.toFile().length();
    }

    public void putEntry(Entry entry){
        try
        {
            OutputStream outputStream = new FileOutputStream(path.toFile());
            ObjectOutputStream ous = new ObjectOutputStream(outputStream);
            ous.writeObject(entry);
            outputStream.close();
            ous.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public Entry getEntry(){
        if (getFileSize() == 0) return null;
        Entry entry = null;
        try
        {
            FileInputStream fis = new FileInputStream(path.toFile());
            ObjectInputStream ois = new ObjectInputStream(fis);
            entry = (Entry)ois.readObject();
        }catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return entry;
    }

    public void remove(){
        try
        {
            Files.delete(path);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
