package com.javarush.test.level07.lesson09.task03;


import java.util.ArrayList;


/* Слово «именно»
1. Создай список из слов «мама», «мыла», «раму».
2. После каждого слова вставь в список строку, содержащую слово «именно».
3. Используя цикл for вывести результат на экран, каждый элемент списка с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> listString = new ArrayList<>();

        listString.add("мама");
        listString.add("именно");
        listString.add("мыла");
        listString.add("именно");
        listString.add("раму");
        listString.add("именно");

        for (int i = 0; i < listString.size(); i++)
        {
            System.out.println(listString.get(i));
        }

    }
}
