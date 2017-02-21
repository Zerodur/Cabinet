package com.javarush.test.level17.lesson10.bonus01;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1

    }

    public static void main(String[] args) throws IOException {

        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (args[0].equals("-c")) {
            Date bd = null;
            try {
                bd = dateFormat1.parse(args[3]);
            } catch (ParseException e) {
                System.out.println("Wrong date");
            }
            if (args[2].equals("м"))
                allPeople.add(Person.createMale(args[1], bd));
            else if (args[2].equals("ж"))
                allPeople.add(Person.createFemale(args[1], bd));
            else throw new IOException("Wrong data");
            System.out.println(allPeople.size() - 1);
        } else if (args[0].equals("-u")) {
            int index = Integer.parseInt(args[1]);
            String sex = args[3];
            allPeople.get(index).setName(args[2]);
            if (sex.equals("м"))
                allPeople.get(index).setSex(Sex.MALE);
            else if (sex.equals("ж"))
                allPeople.get(index).setSex(Sex.FEMALE);
            else throw new IOException("Wrong data");
            try {
                allPeople.get(index).setBirthDay(dateFormat1.parse(args[4]));
            } catch (ParseException e) {
                System.out.println("Wrong date");
            }
        } else if (args[0].equals("-d") && args.length == 2) {
            int index = Integer.parseInt(args[1]);
            if (index < 0 || index >= allPeople.size())
                throw new IOException("Wrong data");
            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
            allPeople.get(Integer.parseInt(args[1])).setName(null);
            allPeople.get(Integer.parseInt(args[1])).setSex(null);
        } else if (args[0].equals("-i")) {
            int index = Integer.parseInt(args[1]);
            Person person = allPeople.get(index);
            String sex;
            if (person.getSex().equals(Sex.FEMALE))
                sex = "ж";
            else sex = "м";
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            System.out.println(person.getName() + " " + sex + " " + dateFormat.format(person.getBirthDay()));
        }
    }
}
