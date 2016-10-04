package myProjects;


import java.io.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.util.*;


public class Main {

    public static final String IN_FILE = "F:/in.txt";
    public static final String OUT_FILE = "F:/out.txt";


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Calendar calendar = Calendar.getInstance();
        System.out.println(String.format("%tA, %<tB", calendar));

    }


/*
        StringBuilder builder = new StringBuilder();
        builder.append("Lena").append('\n');
        String date = builder.toString();
        InputStream is = new ByteArrayInputStream(date.getBytes());
        System.setIn(is);

         Integer i=675;
        double root;
        root = Math.sqrt(i);
        System.out.printf("Корень числа %d равен %1f", i, root );

    }


    }*/
}

 /* for (int i = 0; i < inList.size(); i++) {

            char lastChar = inList.get(i).charAt(inList.get(i).length() - 1);

            for (int j = 0; j < inList.size(); j++) {
                char firstChar = inList.get(j).charAt(inList.get(j).length() - 1);

                if (lastChar == firstChar) {
                    outList.add(inList.get(j));
                    inList.remove(inList.get(j));
                } else {
                    outList.add(inList.get(j));
                    inList.remove(inList.get(j));
                }

            }
        }*/