package com.javarush.test.level07.lesson06.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 10 строчек в начало списка
1. Создай список строк в методе main.
2. Добавь в него 10 строчек с клавиатуры, но только добавлять не в конец списка, а в начало.
3. Используя цикл выведи содержимое на экран, каждое значение с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> listString = new ArrayList<>();
        String tempValue = null;
        for (int i = 0; i < 10; i++)
        {
            tempValue = reader.readLine();
            listString.add(0, tempValue);
        }

        for (int i = 0; i < 10; i++)
        {
            System.out.println(listString.get(i));
        }

    }
}
