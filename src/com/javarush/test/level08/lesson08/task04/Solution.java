package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия» " "дата рожд"ния».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        //напишите тут ваш код
        map.put("Сильвестр", new Date("January 1 1990"));
        map.put("Вандамм", new Date("January 1 1999"));
        map.put("Кинконг", new Date("January 2 1999"));
        map.put("Брюсли", new Date("MAY 3 1999"));
        map.put("Чакнорис", new Date("January 4 1999"));
        map.put("Чичолинна", new Date("SEPTEMBER 5 1999"));
        map.put("Мордем", new Date("August 6 1999"));
        map.put("Юсбих", new Date("JUNE 1 1989"));
        map.put("Модем", new Date("July 1 1989"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //напишите тут ваш код
        HashMap<String, Date> copy = new HashMap<String,Date>(map);
        for (Map.Entry<String, Date> pair : copy.entrySet())
        {
            Date date = pair.getValue();
            int temp = date.getMonth();
           // System.out.println(temp);
            if (temp >= 5 && temp < 8)
                map.remove(pair.getKey());
        }
    }
}
