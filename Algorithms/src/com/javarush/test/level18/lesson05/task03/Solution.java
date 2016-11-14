package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream input = new FileInputStream(file1);
        FileOutputStream out1 = new FileOutputStream(file2);
        FileOutputStream out2 = new FileOutputStream(file3);

        byte[] buffer1 = new byte[input.available()/2 + input.available() % 2];
        byte[] buffer2 = new byte[input.available() - buffer1.length];

        out1.write(buffer1, 0, input.read(buffer1));
        out2.write(buffer2, 0, input.read(buffer2));
        reader.close();
        input.close();
        out1.close();
        out2.close();
    }
}