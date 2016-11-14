package com.javarush.test.level12.lesson04.task04;

/* Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }
    public static int min(int temp1, int temp2)
    {
        return temp1 > temp2 ? temp2 : temp1;
    }
    public static long min(long temp1, long temp2)
    {
        return temp1 > temp2 ? temp2 : temp1;
    }
    public static double min(double temp1, double temp2)
    {
        return temp1 > temp2 ? temp2 : temp1;
    }
    //Напишите тут ваши методы
}
