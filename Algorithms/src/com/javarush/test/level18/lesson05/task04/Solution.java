package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstFile = null;
        String secondFile = null;

        //firstFile = reader.readLine();
        //secondFile = reader.readLine();
        firstFile = "D:/in.txt";
        secondFile = "D:/out.txt";

        reader.close();
        FileInputStream inFile = new FileInputStream(firstFile);
        FileOutputStream outFile = new FileOutputStream(secondFile);

        byte[] bytes = new byte[inFile.available()];

        for (int i = inFile.read(bytes); i > 0 ; i--)
        {
            outFile.write(bytes[i - 1]);
        }

        inFile.close();
        outFile.close();
    }
}
