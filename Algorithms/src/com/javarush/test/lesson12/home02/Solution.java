package com.javarush.test.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        //создай по два объекта каждого класса тут
        Man man1 = new Man("Vasya", 43, "top");
        Man man2 = new Man("Lesha", 34, "left");
        Woman woman1 = new Woman("Lera", 34, "ewr");
        Woman woman2 = new Woman("Vita", 34, "wer");
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);


        //выведи их на экран тут
    }

    public static class Man{
        private String name;
        private String address;
        private int age;

        public Man(String name, int age, String address)
        {
            this.name = name;
            this.address = address;
            this.age = age;
        }
        public String toString(){
            return "[" + this.name + " " + this.age + " " + this.address + "]";
        }
    }

    public static class Woman{

        private String name;
        private String address;
        private int age;

        public Woman(String name, int age, String address)
        {
            this.name = name;
            this.address = address;
            this.age = age;
        }

        public String toString(){
            return "[" + this.name + " " + this.age + " " + this.address + "]";
        }
    }
}
