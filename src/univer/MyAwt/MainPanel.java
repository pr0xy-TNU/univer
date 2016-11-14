package univer.MyAwt;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

/**
 * Created by Yarik on 10.10.2016.
 */
public class MainPanel {
    private static JFrame frame;
    public static List<Double> listX;
    public static List<Double> listY;
    public static List<Double> omegaX;
    public static List<Double> omegaY;
    public static List<Double> omegaZ;

    public static void init() {
        frame = new JFrame("Представление начинается!");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(1, 1));
        frame.setVisible(true);
        frame.setResizable(false);
    }


    public static java.util.List<Double> getDotsX() {
        return listX;
    }

    public static java.util.List<Double> getDotsY() {
        return listY;
    }

    public static java.util.List<Double> getOmegaX() {
        return omegaX;
    }

    public static java.util.List<Double> getOmegaY() {
        return omegaY;
    }

    public static java.util.List<Double> getOmegaZ() {
        return omegaZ;
    }


    public MainPanel() {
        init();
        Canvas dots = new Canvas(frame);
        Canvas dinamicLine = new Canvas(frame);
        frame.add(dots);
        frame.add(dinamicLine);
        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }


    public static void main(String[] args) throws FileNotFoundException {
        setContainerFromFile();
        setOmegaPoins();
        new MainPanel();
    }

    public static void setContainerFromFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("D:/Programming/temp_txt/test.txt"));

        int col = scanner.nextInt();
        listY = new ArrayList<>();
        listX = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            double valueX = scanner.nextFloat();
            double valueY = scanner.nextFloat();
            int valueE = scanner.nextInt();
            listX.add(valueX);
            listY.add(valueY);
        }
    }

    public static void setOmegaPoins() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("D:/Programming/temp_txt/result.txt"));
        omegaX = new ArrayList<>();
        omegaY = new ArrayList<>();
        omegaZ = new ArrayList<>();
        while (scanner.hasNext()) {
            omegaX.add(scanner.nextDouble());
            omegaY.add(scanner.nextDouble());
            omegaZ.add(scanner.nextDouble());
        }
    }
}
