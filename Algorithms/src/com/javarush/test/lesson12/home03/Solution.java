package com.javarush.test.lesson12.home03;

/* Создай классы Dog, Cat, Mouse
Создай классы Dog, Cat, Mouse. Добавь по три поля в каждый класс, на твой выбор. Создай объекты для героев мультика Том и Джерри. Так много, как только вспомнишь.
Пример:
Mouse jerryMouse = new Mouse(“Jerry”, 12 , 5), где 12 - высота в см, 5 - длина хвоста в см.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Mouse jerryMouse = new Mouse("Jerry", 12 , 5);
        Cat topCat = new Cat("Tomass", 32, 2);
        Dog dog = new Dog("Fraddy", 22, 43);

        //напишите тут ваш код
    }

    public static class Mouse
    {
        String name;
        int height;
        int tail;

        public Mouse(String name, int height, int tail)
        {
            this.name = name;
            this.height = height;
            this.tail = tail;
        }
    }
    public static class Dog{
        private int height;
        private String name;
        private int tail;

        public Dog(String name, int height, int tail)
        {
            this.height = height;
            this.name = name;
            this.tail = tail;
        }

    }

    public static class Cat{
        private int age;
        private  int tail;
        private String name;

        public Cat(String name, int tail, int age)
        {
            this.name = name;
            this.tail = tail;
            this.age = age;
        }
    }


}
