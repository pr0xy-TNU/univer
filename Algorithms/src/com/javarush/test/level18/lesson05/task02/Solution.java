package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static int count = 0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(filePath);
        int content;
        while (inputStream.available() > 0 )
        {
            content = inputStream.read();
            if (content == 44)
            {
                count++;
            }
        }
        inputStream.close();
        System.out.println(count);

    }
}
