package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends UniversityPerson {

    private int numberOfStudents;

    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);
        this.numberOfStudents = numberOfStudents;
    }

    public String getPosition(){
        return "Преподаватель";
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

}
