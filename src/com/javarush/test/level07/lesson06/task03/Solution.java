package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list =  new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tempValue = null;
        int lengthOfLastString = 0;

        for (int i = 0; i < 5; i++)
        {
            tempValue = reader.readLine();
            list.add(tempValue);
        }

        sortArrayListFromMaxToMin(list);
        lengthOfLastString = list.get(4).length();
        int j = 0;
        for (int i = list.size() - 1; i >= 0; i--)
        {
            if (lengthOfLastString == list.get(i).length()){
                System.out.println(list.get(i));
            }
        }

    }
    public static void sortArrayListFromMaxToMin(ArrayList<String> list){
        String currentString = null;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (list.get(j).length() < list.get(i).length()){
                    currentString = list.get(i);
                    list.remove(i);
                    list.add(i, list.get(j));
                    list.remove(j);
                    list.add(j, currentString);
                }
            }
        }
    }
}
