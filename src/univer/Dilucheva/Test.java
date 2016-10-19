package univer.Dilucheva;

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


    public static void main(String[] args) {

        if (1 == -1){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }

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
