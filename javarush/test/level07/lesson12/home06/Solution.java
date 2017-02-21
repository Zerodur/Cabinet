package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human ivan = new Human("Иван", true, 75);
        Human nadin = new Human("Надя", false, 70);

        Human yas = new Human("Ясь", true, 76);
        Human paola = new Human("Паша", false, 71);

        Human igor = new Human("Игорь", true, 50);
        igor.mother = paola;
        igor.father = yas;

        Human kate = new Human("Катя", false, 45);
        kate.father = ivan;
        kate.mother = nadin;

        Human ann = new Human("Аня", false, 15);
        ann.mother = kate;
        ann.father = igor;

        Human dasha = new Human("Даша", false, 15);
        dasha.mother = kate;
        dasha.father = igor;

        Human polina = new Human("Полина", false, 15);
        polina.mother = kate;
        polina.father = igor;

        System.out.println(ivan);
        System.out.println(nadin);
        System.out.println(yas);
        System.out.println(paola);
        System.out.println(igor);
        System.out.println(kate);
        System.out.println(ann);
        System.out.println(dasha);
        System.out.println(polina);

    }

    public static class Human
    {
        //напишите тут ваш код
        public Human father, mother;
        private int age;
        private String name;
        private boolean sex;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
