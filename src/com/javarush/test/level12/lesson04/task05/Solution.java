package com.javarush.test.level12.lesson04.task05;

/* Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max (long, long), double max (double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }
    public static int max(int temp1, int temp2)
    {
        return temp1 < temp2 ? temp2 : temp1;
    }
    public static long max(long temp1, long temp2)
    {
        return temp1 < temp2 ? temp2 : temp1;
    }
    public static double max(double temp1, double temp2)
    {
        return temp1 < temp2 ? temp2 : temp1;
    }
    //Напишите тут ваши методы
}
