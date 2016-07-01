package myProjects;

import java.io.*;

import static myProjects.net.util.MyUtil.*;


public class Main
{

    public static void main(String[] args) throws IOException {

        byte[] bytes = new byte[]{(byte) 192, (byte) 168, 12};

        System.out.println((byte)192);
        byte b1 = (byte)5;
        String s1 = String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
        System.out.println(s1);


    }



/*
        StringBuilder builder = new StringBuilder();
        builder.append("Lena").append('\n');
        String date = builder.toString();

        InputStream is = new ByteArrayInputStream(date.getBytes());
        System.setIn(is);




    }

    public static void readAndPrintLine() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        while (true) {

            String content = reader.readLine();



        }


    }*/

}