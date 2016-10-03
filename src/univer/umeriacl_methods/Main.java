package univer.umeriacl_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by ярослав on 16.09.2016.
 */
public class Main {

    public static final float E = (float) 2.7182818;
    public static void eilerMethod() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n; // interval
        float begin, end;//begin end of line segment
        float h;//step
        System.out.println("Ведите N");
        n = Integer.parseInt(reader.readLine());
        System.out.println("Введите начало и конец отверзка");

        String[] values = reader.readLine().split(" ");
        begin = Float.parseFloat(values[0]);
        end = Float.parseFloat(values[1]);
        if (begin > end) {
            float temp = begin;
            begin = end;
            end = temp;
        }

        h = (end - begin) / n;


        ArrayList<Float> argumentsList = getArgumentList(h, begin, n);
        ArrayList<Float> functionList = new ArrayList<>();
        ArrayList<Float> trueValues = getAnswer(argumentsList);

        functionList.add(0, (float) 1);

        for (int i = 0; i < n; i++) {
            float deltaY = functionList.get(i) + h * function(argumentsList.get(i), functionList.get(i));
            functionList.add(i + 1, deltaY);
            //Проверка значения функции
            // System.out.format("x            h        -x * y        y%n");
           // System.out.format("%.5f     %.5f   %.5f     %.5f%n",argumentsList.get(i), h, function(argumentsList.get(i), functionList.get(i)), functionList.get(i));

        }
        System.out.println();
        System.out.println();

        System.out.format("        x         y            true        delta");
        System.out.println();
        for (int i = 0; i < functionList.size() - 1; i++) {


            System.out.format("%2d   %.5f     %.5f       %.5f    % .5f%n", i + 1, argumentsList.get(i), functionList.get(i), trueValues.get(i), functionList.get(i) - trueValues.get(i));
        }
        System.out.println();

    }

    public static void main(String[] args) throws IOException {
        eilerMethod();


    }

    public static ArrayList<Float> getArgumentList(float h, float begin, int n) {
        ArrayList<Float> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(begin + i * h);
        }
        return result;
    }

    public static float function(float x, float y) {

        return -(x * y);
    }

    public static ArrayList<Float> getAnswer(ArrayList<Float> listX) {
        ArrayList<Float> listResult = new ArrayList<>();
        for (int i = 0; i < listX.size(); i++) {
            float value = (float) Math.pow(E, -(listX.get(i)*listX.get(i))/2);
            listResult.add(value);
        }
        return listResult;
    }

}
