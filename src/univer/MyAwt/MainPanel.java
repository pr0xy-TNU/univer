package univer.MyAwt;


import javax.swing.*;
import java.awt.*;

/**
 * Created by Yarik on 10.10.2016.
 */
public class MainPanel {
    private static JFrame frame;

    public static void init() {
        frame = new JFrame("Представление начинается!");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(1, 1));
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static int func(int x) {
        return x + 2;

    }

    public static void main(String[] args) {
        init();
        Canvas canvas = new Canvas(frame);
        frame.add(canvas);



    }


}
