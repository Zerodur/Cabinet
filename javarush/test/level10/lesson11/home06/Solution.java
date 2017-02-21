package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human {

        int weigt;
        int height;
        int age;
        String name;
        boolean school;
        boolean student;
        boolean worker;

        public Human(){
            weigt = height = age = 0;
            school = student = worker = false;
        }

        public Human(int weigt, int height, int age){
            this.weigt = weigt;
            this.height = height;
            this.age = age;
        }

        public Human(String name, int weigt, int height, int age){
            this.name = name;
            this.weigt = weigt;
            this.height = height;
            this.age = age;
        }

        public Human(String name, int weigt, int height){
            this.name = name;
            this.weigt = weigt;
            this.height = height;
        }

        public Human(String name, int weigt){
            this.name = name;
            this.weigt = weigt;
        }

        public Human(String name){
            this.name = name;
        }

        public Human(String name, String status){
            this.name = name;
            if (status.equals("school")){
                this.school = true;
            } else if (status.equals("student")){
                this.school = true;
                this.student = true;
            }else if (status.equals("worker")){
                this.school = true;
                this.student = true;
                this.worker = true;
            }

        }

        public Human(String name, String status, int age){
            this.name = name;
            if (status.equals("school")){
                this.school = true;
            } else if (status.equals("student")){
                this.school = true;
                this.student = true;
            }else if (status.equals("worker")){
                this.school = true;
                this.student = true;
                this.worker = true;
            }
            this.age = age;
        }

        public Human(String name, String status, int age, int weight){
            this.name = name;
            if (status.equals("school")){
                this.school = true;
            } else if (status.equals("student")){
                this.school = true;
                this.student = true;
            }else if (status.equals("worker")){
                this.school = true;
                this.student = true;
                this.worker = true;
            }
            this.age = age;
            this.weigt = weight;
        }

        public Human(String name, String status, int age, int weight, int height){
            this.name = name;
            if (status.equals("school")){
                this.school = true;
            } else if (status.equals("student")){
                this.school = true;
                this.student = true;
            }else if (status.equals("worker")){
                this.school = true;
                this.student = true;
                this.worker = true;
            }
            this.age = age;
            this.weigt = weight;
            this.height = height;
        }
    }
}
