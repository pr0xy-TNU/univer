package com.javarush.test.level08.lesson11.home09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args) throws ParseException
    {
        String date = "MAY 1 2013";

        System.out.println(date + " = " + isDateOdd(date));
    }

    public static boolean isDateOdd(String date) throws ParseException
    {
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMM d yyyy");
        Date d = inputFormat.parse(date);
        SimpleDateFormat outFormat = new SimpleDateFormat("D");
        int dayOfYear = Integer.parseInt(outFormat.format(d));
        boolean isOdd = dayOfYear % 2 == 1;
        return isOdd;
    }
}
