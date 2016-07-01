package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> listIntegerLarg = new ArrayList<>();
        ArrayList<Integer> listIntegerDivThree = new ArrayList<>();
        ArrayList<Integer> listIntegerDivTwo = new ArrayList<>();
        ArrayList<Integer> listIntegerOther = new ArrayList<>();

        for (int i = 0; i < 20; i++)
        {
            listIntegerLarg.add(Integer.parseInt(reader.readLine()));
        }

        for (int i = 0; i < listIntegerLarg.size(); i++)
        {
            if( listIntegerLarg.get(i) % 3 == 0 && listIntegerLarg.get(i) % 2 == 0){
                listIntegerDivThree.add(listIntegerLarg.get(i));
                listIntegerDivTwo.add(listIntegerLarg.get(i));
            }
            if( listIntegerLarg.get(i) % 3 == 0 && listIntegerLarg.get(i) % 2 != 0){
                listIntegerDivThree.add(listIntegerLarg.get(i));
            }
            if( listIntegerLarg.get(i) % 3 != 0 && listIntegerLarg.get(i) % 2 == 0){
                listIntegerDivTwo.add(listIntegerLarg.get(i));
            }
            if (listIntegerLarg.get(i) % 3 != 0 && listIntegerLarg.get(i) % 2 != 0){
                listIntegerOther.add(listIntegerLarg.get(i));
            }
        }

        printList(listIntegerDivThree);
        printList(listIntegerDivTwo);
        printList(listIntegerOther);
    }

    public static void printList(List<Integer> list)
    {
        for (Integer i: list)
        {
            System.out.println(i);
        }
    }
}
