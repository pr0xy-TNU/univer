package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human kid1 = new Human("Маша", false, 13);
        Human kid2 = new Human("Женя", true, 14);
        Human kid3 = new Human("Никита", true, 20);
        Human father = new Human("Александр", true, 45, new ArrayList<Human>(Arrays.asList(kid1,kid2,kid3)));
        Human mother = new Human("Наталья", false, 23, new ArrayList<Human>(Arrays.asList(kid1, kid2, kid3)));
        Human grandFatherFirst = new Human("Горра", true, 60, new ArrayList<Human>(Arrays.asList(father)));
        Human grandFatherSecond = new Human("Лена", false, 56, new ArrayList<>(Arrays.asList(father)));
        Human grandMotherFirst = new Human("Миша", false, 56, new ArrayList<>(Arrays.asList(mother)));
        Human grandMotherSecond = new Human("Маша", false, 56, new ArrayList<>(Arrays.asList(mother)));

        ArrayList<Human> human = new ArrayList<>();

        human.add(kid1);
        human.add(kid2);
        human.add(kid3);
        human.add(father);
        human.add(mother);
        human.add(grandFatherFirst);
        human.add(grandFatherSecond);
        human.add(grandMotherFirst);
        human.add(grandMotherSecond);

        for (int i = 0; i < human.size(); i++)
        {
            System.out.println(human.get(i).toString());
        }


    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        public Human()
        {
            this.age = 0;
            this.children = null;
            this.sex = false;
            this.name = null;
        }


        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = null;
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = 0;
            if (this.children != null)
            {
                childCount  = this.children.size();
            }
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }
            return text;
        }
    }

}
