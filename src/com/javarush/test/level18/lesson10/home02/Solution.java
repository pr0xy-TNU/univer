package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String filePath = args[0];
        FileInputStream  inputStream = new FileInputStream(filePath);

        int countOfSpace = 0;
        int countOfAllSymbols = inputStream.available();
        while (inputStream.available() > 0)
        {
            int content = inputStream.read();
            if (content == 32)
                countOfSpace++;
        }
        inputStream.close();
        double result = (countOfSpace * 1.0 / countOfAllSymbols * 1.0) * 100;
        double roundNumber = new BigDecimal(result).setScale(2, BigDecimal.ROUND_UP).doubleValue();
        System.out.println(roundNumber);
    }
}
