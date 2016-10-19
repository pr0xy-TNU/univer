package univer.Dilucheva;


import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Neiro {
    public static Scanner value = new Scanner(System.in);
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final int SIZE = 10;
    public static final int OMEGA_SIZE = 3;
    public static final double C = 0.2;
    public static double[] omega;
    public static boolean isInterrupted = false;

    //-1.42 -0.09 5.13
    static {
        omega = new double[3];
        omega[0] = -0.81;
        omega[1] = -0.27;
        omega[2] = 3.84;

    }
    /*
        omega[0] = 0.75;
        omega[1] = 0.5;
        omega[2] = -0.6;

        omega[0] = -0.81;
        omega[1] = -0.27;
        omega[2] = 3.84;
        Нашел два решения:
        -1.42 -0.09 5.13
        -0.81 -0.27 3.84
    * */

    static class Container {
        private double[] listX;
        private double[] listY;
        private int[] listE;


        Container(int value) {
            listX = new double[value];
            listY = new double[value];
            listE = new int[value];
        }

        public void setContainer() throws IOException {
            System.out.println("Enter values (x, y, +-1)");
            for (double aListX : listX) {
                String valueFromTerminal = reader.readLine();
                String[] splitDate = valueFromTerminal.split(" ");
            }
            System.out.println();
        }

        public void setContainerFromFile() throws FileNotFoundException {
            Scanner scanner = new Scanner(new File("D:/Programming/Test files/test.txt"));
            int col = scanner.nextInt();
            for (int i = 0; i < col; i++) {
                float valueX = scanner.nextFloat();
                float valueY = scanner.nextFloat();
                int valueE = scanner.nextInt();
                listX[i] = valueX;
                listY[i] = valueY;
                listE[i] = valueE;
            }
        }

        public void setContainerFromFileWithPath(String filPath) throws FileNotFoundException {
            Scanner scanner = new Scanner(new File(filPath));
            int col = scanner.nextInt();
            for (int i = 0; i < col; i++) {
                float valueX = scanner.nextFloat();
                float valueY = scanner.nextFloat();
                int valueE = scanner.nextInt();
                listX[i] = valueX;
                listY[i] = valueY;
                listE[i] = valueE;
            }
        }

        public void showContainer() {
            System.out.println("Container values: ");
            System.out.println(" N        x      y    value");
            for (int i = 0; i < SIZE; i++) {
                System.out.printf("%2d      %4.1f   %4.1f   % 4d%n", i + 1, listX[i], listY[i], listE[i]);
            }
            System.out.println("-----------------");
        }

        public void checkAnswer() {
            for (int i = 0; i < listE.length; i++) {
                double functionValue = new BigDecimal(omega[0] * listX[i] + omega[1] * listY[i] + omega[2])
                        .setScale(2, RoundingMode.UP)
                        .doubleValue();
                String result = String.format("%2.2f * %2.2f + %2.2f * %2.2f + %2.2f =  %4.1f   is %2d and answer is %2d",
                        omega[0], listX[i], omega[1], listY[i], omega[2], functionValue, sign(i), listE[i]);
                System.out.println(result);
            }
        }

        public int sign(int index) {
            double function = new BigDecimal(omega[0] * listX[index] + omega[1] * listY[index] + omega[2]).setScale(2, RoundingMode.UP).doubleValue();
            if (function > 0) {
                return 1;
            } else {
                return -1;
            }
        }

        public double[] getListX() {
            return this.listX;
        }

        public double[] getListY() {
            return this.listX;
        }

        public int[] getListE() {
            return this.listE;
        }


    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int f;
        double[] oldOmega;

        int incChecker = 0;
        int iterationCounter = 1;
        Container container = new Container(10);
        container.setContainerFromFile();
        container.showContainer();
        oldOmega = omega.clone();

        while (!isInterrupted) {
            System.out.println("Out Iteration: " + iterationCounter);
            for (int i = 0; i < SIZE; i++) {
                f = container.sign(i);
                if (f == container.listE[i])
                    incChecker++;
                else
                    incChecker = 0;
                oldOmega = omega;
                omega = getNewOmega(container, oldOmega, f, i);
            }
            if (incChecker >= 9)
                isInterrupted = true;
            else
                incChecker = 0;
            iterationCounter++;
            System.out.println(omega[0] + " * x1 + " + omega[1] + " * x2 + " + omega[2]);
            Thread.sleep(500);
        }
        iterationCounter--;
        System.out.println("I fined the divided line for " + iterationCounter + " iterations. (Total iteration count is " + iterationCounter * SIZE + " )");
        System.out.println("f(x) = " + omega[0] + " * x1 + " + omega[1] + " * x2 + " + omega[2]);
        container.checkAnswer();


    }

    public static double[] getNewOmega(Container con, double[] oldOmega, int f, int index) {
        double x = new BigDecimal(oldOmega[0] + C * (con.listE[index] - f) * con.listX[index]).setScale(2, RoundingMode.UP).doubleValue();
        double y = new BigDecimal(oldOmega[1] + C * (con.listE[index] - f) * con.listY[index]).setScale(2, RoundingMode.UP).doubleValue();
        double e = new BigDecimal(oldOmega[2] + C * (con.listE[index] - f) * 1).setScale(2, RoundingMode.UP).doubleValue();
        double[] temp = new double[OMEGA_SIZE];
        temp[0] = x;
        temp[1] = y;
        temp[2] = e;
        return temp;
    }
}
