package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int firstNumber = Integer.parseInt(reader.readLine());
        int secondNumber = Integer.parseInt(reader.readLine());
        System.out.println(gcd(firstNumber, secondNumber));

    }
    public static int gcd(int a,  int b)
    {
        int temp = 0;
        while (b != 0)
        {
            a %= b;
            temp = a;
            a = b;
            b = temp;
        }
        return a;
    }
}
