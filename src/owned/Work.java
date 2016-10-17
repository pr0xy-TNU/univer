package owned;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;


/**
 * Created by Yarik on 13.09.2016.
 */
public class Work {

    static class Point2D {
        float x;
        float y;

        public float getY() {
            return y;
        }

        public float getX() {

            return x;
        }

        @Override
        public String toString() {
            return "Point2D(" + x +
                    ", " + y +
                    ')';
        }

        public Point2D(float x, float y) {

            this.x = x;
            this.y = y;
        }

        public Point2D() {
            this.x = -1;
            this.y = -1;
        }

        public boolean equalPoint2D(Point2D value) {
            if ((this.getX() == value.getX()) && (this.getY() == value.getY()))
                return true;
            else
                return false;
        }
    }

    public static void printList(ArrayList<Point2D> list, int number, Point2D corePoint) {
        System.out.println("Result: class" + number + ", core " + corePoint);
        for (Point2D item : list
                ) {
            System.out.print("(" + item.getX() + " " + item.getY() + ")");
        }
        System.out.println();
    }

    public static void printList(ArrayList<Point2D> list, int number) {
        System.out.println("Result: class" + number);
        for (Point2D item : list
                ) {
            System.out.print("(" + item.getX() + " " + item.getY() + ")");
        }
        System.out.println();
    }

    public static float distance(Point2D a, Point2D b) {
        float first = (float) Math.pow((a.getX() - b.getX()), 2);
        float second = (float) Math.pow((a.getY() - b.getY()), 2);
        float result = (float) Math.sqrt(first + second);

        return result;
    }

    public static Point2D getCorePoint(ArrayList<Point2D> list) {
        float deltaX = 0;
        float deltaY = 0;
        for (Point2D item : list
                ) {
            deltaX += item.x;
            deltaY += item.y;
        }
        deltaY /= list.size();
        deltaX /= list.size();
        return new Point2D(new BigDecimal(deltaX).setScale(2, RoundingMode.HALF_UP).floatValue(),
                new BigDecimal(deltaY).setScale(2, RoundingMode.HALF_UP).floatValue());
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Point2D> class1ArrayList = new ArrayList<>();
        ArrayList<Point2D> class1TotalList = null;
        ArrayList<Point2D> class2ArrayList = new ArrayList<>();
        ArrayList<Point2D> class2TotalList = null;
        System.out.println("Enter size of mass");

        int size = Integer.parseInt(reader.readLine());

        ArrayList<Point2D> defaultDate = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            String line = reader.readLine();
            String[] point = line.split(" ");
            defaultDate.add(new Point2D(Integer.parseInt(point[0]), Integer.parseInt(point[1])));
        }

        boolean flag = true;

        Point2D class1Point2D = defaultDate.get(0);
        class1ArrayList.add(class1Point2D);

        Point2D class2Point2D = defaultDate.get(1);
        class2ArrayList.add(class2Point2D);

        int position = 2;
        int iterationCount = 1;
        Point2D class1LastPoint = new Point2D();
        Point2D class2LastPoint = new Point2D();
        while (flag) {
            System.out.println("New " + iterationCount + " iteration:");
            for (int i = position; i < size; i++) {
                float rad1 = distance(class1Point2D, defaultDate.get(i));
                float rad2 = distance(class2Point2D, defaultDate.get(i));
                if (rad1 <= rad2) {
                    class1ArrayList.add(defaultDate.get(i));
                } else {
                    class2ArrayList.add(defaultDate.get(i));
                }
            }
            //среднее значние класса
            class1Point2D = getCorePoint(class1ArrayList);
            class2Point2D = getCorePoint(class2ArrayList);

            printList(class1ArrayList, 1, class1Point2D);
            printList(class2ArrayList, 2, class2Point2D);

            position = 0;
            if (class1Point2D.equalPoint2D(class1LastPoint) && class2Point2D.equalPoint2D(class2LastPoint)) {
                flag = false;
            } else {
                flag = true;
            }

            if (!flag) {
                class1TotalList = new ArrayList<>(class1ArrayList);
                class2TotalList = new ArrayList<>(class2ArrayList);

            }
            class1ArrayList.clear();
            class2ArrayList.clear();
            Thread.sleep(1000);
            iterationCount++;
            System.out.println("--------------------------------------------");
            class1LastPoint = class1Point2D;
            class2LastPoint = class2Point2D;
        }

        Point2D userPoint;

        System.out.println("Введите точку");
        float x, y;
        x = Float.parseFloat(reader.readLine());
        y = Float.parseFloat(reader.readLine());
        userPoint = new Point2D(x, y);

        printList(class1TotalList, 1);
        printList(class2TotalList, 2);

        System.out.println("-------------------------------");
        float distance1 = distance(class1Point2D, userPoint);
        float distance2 = distance(class2Point2D, userPoint);
        if (distance1 <= distance2) {
            System.out.println(userPoint + " пренадлежит классу 1");
        } else {
            System.out.println(userPoint + " пренадлежит классу 2");
        }

    }
}
