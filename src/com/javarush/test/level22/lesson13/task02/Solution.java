package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.util.ArrayList;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        if (args.length < 2)
            return;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        ArrayList<String> listIn = new ArrayList<>();

        String tempLine = null;

        while (reader.ready()) {
            listIn.add(reader.readLine());
        }

        reader.close();

        ArrayList<String> listOut = new ArrayList<>();

        for (String item : listIn
                ) {
            listOut.add(new String(item.getBytes("Windows-1251"), "UTF-8"));
        }

        PrintWriter writer = new PrintWriter(new FileWriter(args[1]));

        for (String item : listOut
                ) {
            writer.println(item);
        }
        writer.close();

    }
}
