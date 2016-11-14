package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = null;
        filePath = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(filePath);
        int min = inputStream.read();
        int date = 0;
        while (inputStream.available() > 0)
        {
            date = inputStream.read();
            if (min > date)
                min = date;

        }

        inputStream.close();
        System.out.println(min);
    }
}
