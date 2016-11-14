package univer.Dilucheva;

import com.sun.deploy.util.StringUtils;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Created by Yarik on 17.10.2016.
 */
public class Test {


    public static String toBinary(int value) {
        int b = 0;
        String temp = "";
        while (value != 0) {
            b = value % 2;
            temp += b;
            value /= 2;
        }


        return temp;
    }


    public static void main(String[] args) throws IOException {

        List<String > values = new ArrayList<>();
        values.add("amo");
        values.add("cma");
        values.add("rma");
        values.add("aem");
        values.add("acm");
        values.add("arm");
        values.add("ema");
        values = getListWithoutDuplicates(values);
        values.forEach(System.out::println);

    }


    public static List<String> getListWithoutDuplicates(List<String> temp) {
        Map<Integer, String> result = new HashMap<>();
        int sum = 0;
        for (String str : temp
                ) {
            char[] charValue1 = str.toCharArray();
            for (Character item : charValue1
                    ) {
                sum += (int) item;
            }
            result.put(sum, str);
            sum = 0;
        }
        for (Map.Entry<Integer, String> pair : result.entrySet()
             ) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        List<String> resultList = new ArrayList<>(result.values());
        return resultList;
    }

    public static String replaceDuplicatesWithTemplate(String inputString) {
        // проверяем входну строку на валидность
        if (inputString == null || inputString.length() < 2) {
            return inputString;
        }
        // возможная позиция дублирующего символа
        int position = 1;
        char[] characters = inputString.toCharArray();
        for (int i = 1; i < inputString.length(); i++) {
            int j;
            // находим уже пройденную позицию
            for (j = 0; j < position; ++j) {
                if (characters[i] == characters[j]) {
                    break;
                }
            }
            // если это символ в этой же позиции, то идем к следующему символу
            if (j == position) {
                characters[position] = characters[i];
                ++position;
                // иначе заменяем его на шаблон 0 и переходим к следующему символу
            } else {
                characters[position] = 0;
                ++position;
            }
        }
        return getStringWithoutDuplicates(characters);
    }

    public static String getStringWithoutDuplicates(char[] inputChars) {
        StringBuilder stringBuilder = new StringBuilder(inputChars.length);
        for (char character : inputChars) {
            // если символ не равен шаблону 0, то это не дубль,
            // значит сохраняем его
            if (character != 0) {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    public static int isExists(String str, String value) {
        char[] chars = value.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (str.contains(String.valueOf(chars[i]))) {
                count++;
            }
        }
        if (count == chars.length)
            return 1;
        else
            return 0;
    }

    public static String getBinary(int value) {

        switch (value) {
            case 1:
                return "001";
            case 2:
                return "010";
            case 3:
                return "011";
            case 4:
                return "100";
            case 5:
                return "101";
            case 6:
                return "110";
            case 7:
                return "111";
        }
        return "";
    }
}
