package univer.Dilucheva.Grafics;

import univer.Dilucheva.Grafics.MyCanvas;
import univer.umeriacl_methods.Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;


public class MainFrame extends JFrame {

    /**
     * @param args
     */
    MyCanvas c;

    public static double f(double x) {
        return x - 2;//результат выражения
    }

    public MainFrame() {
        setSize(400, 400);
        setDefaultCloseOperation(3);
        c = new MyCanvas();
        add(c);
        setVisible(true);
        c.show();
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();


    }

}
