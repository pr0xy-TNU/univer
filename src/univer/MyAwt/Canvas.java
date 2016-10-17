package univer.MyAwt;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Yarik on 12.10.2016.
 */
public class Canvas extends JComponent {
    private Frame frame;
    public static final int PADDING = 50;

    public Canvas(Frame frame) {
        this.frame = frame;
    }

    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);
        Graphics2D g2D = (Graphics2D) graphics;
        g2D.setPaint(Color.CYAN);
        g2D.drawRect(100, 100, 20, 80);
        g2D.setPaint(Color.BLACK);

        g2D.setStroke(new BasicStroke(0.9f));
        // Расчерчиваем холст
        for (int i = 0; i < frame.getHeight(); i += 10) {
            g2D.drawLine(0, i, frame.getWidth(), i);
        }
        for (int i = 0; i < frame.getWidth(); i += 10) {
            g2D.drawLine(i, 0, i, frame.getHeight());
        }
        //Рисуем оси
        g2D.setStroke(new BasicStroke(3.9f));
        g2D.drawLine(50, frame.getHeight() / 2, frame.getWidth() - PADDING, frame.getHeight() / 2);
        g2D.drawLine(frame.getWidth() / 2, PADDING, frame.getWidth() / 2, frame.getHeight() - PADDING);
        //frame.getHeight()/2
        int R = (int) (Math.random() * 256);
        int G = (int) (Math.random() * 256);
        int B = (int) (Math.random() * 256);
        //g2D.setColor(new Color(R, G, B));
        g2D.setColor(Color.red);
        g2D.setStroke(new BasicStroke(2.9f));
        /*
        int r = 100;
        g2D.drawOval(frame.getWidth() / 2 - r / 2, frame.getHeight() / 2 - r / 2, r, r);
        */
        //Синусоида
        for (int x = frame.getWidth() / 2; x < frame.getWidth(); x++) {
            int y = (int) (150 * Math.sin(Math.toRadians(x)) + frame.getHeight() / 2);
            g2D.fillOval(x, y, 4, 4);
        }
        g2D.fillOval(frame.getWidth() / 2, frame.getHeight() / 2, 4, 4);
        /*g2D.setColor(Color.RED);
        for (int x = frame.getWidth() / 2; x < frame.getWidth(); x++) {
            int y = (int) (100 * Math.cos(Math.toRadians(x))) + this.getHeight() / 2;
            g2D.fillOval(x, y, 2, 2);
        }*/
        update(g2D);
    }
}
