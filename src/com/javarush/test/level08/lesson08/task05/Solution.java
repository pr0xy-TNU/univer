package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> stringMap = new HashMap<String, String>();
        stringMap.put("Нина", "Романовна");
        stringMap.put("Диана", "Никрасова");
        stringMap.put("Любовь", "Серьгеевна");
        stringMap.put("Владимир", "Владимирович");
        stringMap.put("Римма", "Петровна");
        stringMap.put("Радеон", "Сергеевич");
        stringMap.put("Петров", "Роман");
        stringMap.put("Токарь", "Ярослав");
        stringMap.put("Пархоменко", "Ярослав");
        stringMap.put("Денисов", "Сергей");
        return stringMap;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> myMap = new HashMap<String, String>(map);
        for (Map.Entry<String, String> firstPair: myMap.entrySet())
        {
            for (Map.Entry<String ,String> secondPair : myMap.entrySet())
            {
                if (firstPair.getValue().equals(secondPair.getValue()) && !firstPair.getKey().equals(secondPair.getKey())){
                    removeItemFromMapByValue(map, firstPair.getValue());
                }
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
