package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filePath = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
        ArrayList<String> dataline = new ArrayList<>();

        //читаем файл

        while (in.ready()) {
            dataline.addAll(Arrays.asList(in.readLine().split(" ")));
        }

        in.close();

        Map<String, String> pairs = new HashMap<>();

        for (int i = 0; i < dataline.size(); i++) {

            String usual = dataline.get(i);
            StringBuilder usualreversebuilder = new StringBuilder(usual);
            String usualreverse = usualreversebuilder.reverse().toString();

            {
                for (int j = i + 1; j < dataline.size(); j++) {
                    // 1 если такой ключ уже есть
                    if (pairs.containsKey(usual)) {
                        continue;
                    }
                    // 2 если такой ключ, только перевернутый, уже есть, т.е повтор
                    if (pairs.containsKey(usualreverse)) {
                        continue;
                    }


                    StringBuilder sb = new StringBuilder(dataline.get(j));
                    String reverse = sb.reverse().toString();

                    //2 условие если строка реверсивна следующей
                    if (usual.equals(reverse)) {
                        pairs.put(usual, sb.reverse().toString());
                    }
                }
            }
        }

        for (Map.Entry<String, String> item : pairs.entrySet()) {
            Pair pair = new Pair();
            pair.first = item.getKey();
            pair.second = item.getValue();
            result.add(pair);
        }

        for (Pair pa : result) {
            System.out.println(pa.first + " " + pa.second);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
