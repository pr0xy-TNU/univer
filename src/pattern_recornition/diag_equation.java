package pattern_recornition;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.DoubleStream;


class DiagEquation {
    public static Random randNumber;
    public static float[] coef = new float[5];
    public static String[] coefString = new String[]{"a", "b", "c", "d"};
    public static int id = 1;

    static class Chromosome {

        public float[] points;
        public float kSurv;
        public int cId;

        public Chromosome() {
            points = new float[4];
            this.kSurv = 0;
            this.cId = id;
            id++;
        }

        public void setPoints(int leftBorder, int rightBorder) {
            randNumber = new Random(rightBorder - leftBorder);
            float temp;
            for (int i = 0; i < points.length; i++) {
                temp = (float) Math.random() * (rightBorder - leftBorder) + leftBorder + 1;
                points[i] = new BigDecimal(temp).setScale(0, RoundingMode.UP).floatValue();
            }
            float survivl = 0;
            for (int i = 0; i < points.length; i++) {
                survivl += points[i] * coef[i];
            }
            survivl -= coef[points.length];
            this.kSurv = survivl;
        }

        //ПОлучаем только точки
        public void showPoints() {
            for (int i = 0; i < points.length; i++) {
                System.out.print(points[i] + " ");
            }
        }

        public float getkSurv() {
            return this.kSurv;
        }

        //Полуаем все данные по хромосоме
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(this.cId);
            builder.append(": ");
            for (int i = 0; i < points.length; i++) {
                builder.append(points[i]);
                builder.append(" ");
            }
            builder.append("k = ");
            builder.append(this.kSurv);
            return builder.toString();
        }

        //Получаем уравнение в исходном виде
        public String getEquastion() {
            StringBuilder equastion = new StringBuilder();
            for (int i = 0; i < coef.length - 1; i++) {
                equastion.append(coefString[i]);
                equastion.append(" * ");
                equastion.append(coef[i]);
                if (i == coef.length - 2)
                    break;
                else
                    equastion.append(" + ");
            }
            equastion.append(" = ");
            equastion.append(coef[coef.length - 1]);
            return equastion.toString();
        }
    }

    static class ChromoContainer {
        public ArrayList<Chromosome> list;
        public float survivle;

        public ChromoContainer(int size) {
            list = new ArrayList<>(size);
        }

        public void setList(int left, int right) {
            float totalSurv = 0;
            for (int i = 0; i < 5; i++) {
                Chromosome temp1 = new Chromosome();
                temp1.setPoints(left, right);
                totalSurv += temp1.getkSurv();

                list.add(temp1);
            }
            this.survivle = totalSurv / 5;
        }

        public void showList() {
            for (Chromosome item : list
                    ) {
                System.out.println(item.toString());
            }
        }

        public float getSurvivile() {
            return this.survivle;
        }
    }


    public static int generator() {

        randNumber = new Random();
        int number = randNumber.nextInt(99) + 1;
        int result = 0;
        if (number > 0 && number <= 35) {
            result = 1;
        } else if (number > 35 && number <= 60) {
            result = 2;
        } else if (number > 60 && number <= 80) {
            result = 3;
        } else if (number > 80 && number <= 90) {
            result = 4;
        } else if (number > 90 && number < 101) {
            result = 5;
        }
        return result;
    }


    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите коэфициенты");
        String data = scanner.nextLine();
        int leftBorder, rightBorder = 1;

        String[] dateParse = data.trim().split(" ");
        for (int i = 0; i < coef.length; i++) {
            coef[i] = Float.parseFloat(dateParse[i]);
        }
        System.out.println("Введите границы, сначала левую потом правую");
        String[] border = scanner.nextLine().trim().split(" ");
        leftBorder = Integer.parseInt(border[0]);
        rightBorder = Integer.parseInt(border[1]);

        ChromoContainer parints = new ChromoContainer(5);
        parints.setList(leftBorder, rightBorder);
        //ArrayList<Chromosome> chromosomesChildren = new ArrayList<>();

        parints.showList();
        System.out.println(parints.getSurvivile());
        /*for (int i = 0; i < 5; i++) {

            System.out.println(chromosomesParents.get((int) (Math.random() * 5)).toString() + " < = > " + chromosomesParents.get((int) (Math.random() * 4 + 0)).toString());
            System.out.println();
        }*/
        Set<Integer> set = getRandomPairs();
        for (Integer item : set
                ) {
            System.out.println(item);
        }

    }

    public static Set<Integer> getRandomPairs() throws InterruptedException {
        Set<Integer> tmep = new HashSet<>();
        Map<Integer, Integer> pair = new HashMap<>();

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int numer1 = i;
                int numer2 = j;
                if (i == j)
                    continue;
                else
                    tmep.add(i * 10 + j);
            }
        }

        return new HashSet<>();
    }
}
