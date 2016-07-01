package com.javarush.test.level09.lesson11.home04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* Конвертер дат
Ввести с клавиатуры дату в формате «08/18/2013»
Вывести на экран эту дату в виде «AUG 18, 2013».
Воспользоваться объектом Date и SimpleDateFormat.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String s;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        s=reader.readLine();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date parsedDate = dateFormat.parse(s);
        Format formatter = new SimpleDateFormat("MMM dd, yyyy",Locale.ENGLISH);
        String y = formatter.format(parsedDate);
        System.out.println(y.toUpperCase());
    }
}
