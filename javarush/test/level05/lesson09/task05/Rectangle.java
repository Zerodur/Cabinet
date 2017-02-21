package com.javarush.test.level05.lesson09.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    //напишите тут ваш код
    int left;
    int top;
    int width;
    int height;

        public Rectangle(int left1, int top1)
    {
        this.left=left1;
        this.top=top1;
    }
    public Rectangle(int left1, int top1, int width1)
    {
        this.left=left1;
        this.top=top1;
        this.width=width1;
        this.height=width1;
    }
    public Rectangle(Rectangle obj)
    {
        this.left=obj.left;
        this.top=obj.top;
        this.width=obj.width;
        this.height=obj.height;
    }
    public Rectangle(int left1, int top1, int width1, int height)
    {
        this.left=left1;
        this.top=top1;
        this.width=width1;
        this.height=height;
    }
}
