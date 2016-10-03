package myProjects;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/

public class Clone {

    public static final String IN_FILE = "F:/in.txt";
    public static final String OUT_FILE = "F:/out.txt";

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(IN_FILE));
        List<String> inList = new ArrayList();
        List<String> outList = new ArrayList<>();

        while (reader.ready()) {
            inList.add(reader.readLine());
        }
        reader.close();

        for (String item : inList
                ) {
            outList.add(String.valueOf(checkExp(item)));
        }
        printList(inList, outList);

    }


    public static void printList(List<String> inList, List<String> outList) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(OUT_FILE);

        for (int i = 0; i < inList.size(); i++) {
            writer.println(inList.get(i) + "\t \t \t \t" + outList.get(i));
        }
        writer.close();
    }


    public static boolean checkExp(String string) {
        Pattern pattern = Pattern.compile("[+][8(][0,5]{2}[)][0-9]{7}");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

}
