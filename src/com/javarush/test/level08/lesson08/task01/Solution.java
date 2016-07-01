package com.javarush.test.level08.lesson08.task01;

import java.util.HashSet;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        Set<String > stringSet = new HashSet<String>();
        stringSet.add("Лора");
        stringSet.add("Лиза");
        stringSet.add("Любовь");
        stringSet.add("Лимфа");
        stringSet.add("Лауреат");
        stringSet.add("Лето");
        stringSet.add("Лист");
        stringSet.add("Лосьен");
        stringSet.add("Лось");
        stringSet.add("Лень");
        stringSet.add("Листья");
        stringSet.add("Лексус");
        stringSet.add("Лазанья");
        stringSet.add("Ладонь");
        stringSet.add("Лопасть");
        stringSet.add("Ладен");
        stringSet.add("Леприкон");
        stringSet.add("Лаборатория");
        stringSet.add("Лик");
        stringSet.add("Лис");
        return (HashSet<String>) stringSet;
    }
}
