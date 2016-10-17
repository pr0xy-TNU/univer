package univer.MyAwt;


import javax.swing.*;
import java.awt.*;

/**
 * Created by Yarik on 10.10.2016.
 */
public class TempFile {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Okolofootball");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(5, 5));
        Canvas canvas = new Canvas(frame);
        frame.add(canvas);
        frame.setResizable(false);


        frame.setVisible(true);

    }


}
