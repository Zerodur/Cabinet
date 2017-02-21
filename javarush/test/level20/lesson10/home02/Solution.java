package com.javarush.test.level20.lesson10.home02;

import java.io.*;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable{
    public Solution(){}
    public A getOriginalObject(ObjectInputStream objectStream) {
        Object obj = null;

        try
        {
            obj = objectStream.readObject();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        if (obj instanceof B) return (B) obj;
        return (A) obj;
    }

    public class A implements Serializable{
        public A(){}
    }

    public class B extends A {

        public B() {
            System.out.println("inside B");
        }
    }
   }
