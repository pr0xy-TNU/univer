package com.javarush.test.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countOfnummbers =  Integer.parseInt(reader.readLine());
        int maximum = 0;
        int currentNumber = 0;
        int oldNumber = 0;

        while (countOfnummbers > 0){
            currentNumber =  Integer.parseInt(reader.readLine());
            currentNumber = oldNumber > currentNumber ? oldNumber : currentNumber;
            oldNumber = currentNumber;
            countOfnummbers--;
        }
        maximum = currentNumber;
        System.out.println(maximum);
    }
}
