package univer.MyAwt;

import univer.Dilucheva.Grafics.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Yarik on 12.10.2016.
 */
public class Canvas extends JComponent {
    private Frame frame;
    private Graphics2D g2D;
    public static final int PADDING = 50;
    public final int SCALE = 5;
    private Point X0Y0;

    public Canvas(Frame frame) {
        this.frame = frame;
        X0Y0 = new Point(frame.getHeight() / 2, frame.getWidth() / 2);
    }


    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);
        //Центр координат

        g2D = (Graphics2D) graphics;
        g2D.setPaint(Color.BLACK);
        drawXY();
        drawCanvas();
        java.util.List<Double> listX = MainPanel.getDotsX();
        java.util.List<Double> listY = MainPanel.getDotsY();
        java.util.List<Double> omegaX = MainPanel.getOmegaX();
        java.util.List<Double> omegaY = MainPanel.getOmegaY();
        java.util.List<Double> omegaZ = MainPanel.getOmegaZ();

        for (int i = 0; i < listX.size(); i++) {
            drawPoint(listX.get(i) * SCALE, listY.get(i) * SCALE);
        }
        int[] polygoneY = new int[listX.size()];
        int[] polygoneX = new int[listX.size()];
        /*for (int j = 0; j < omegaX.size(); j++) {
            Random r = new Random();
            g2D.setPaint(new Color(150 + r.nextInt(100), 100 + r.nextInt(150), 100 + r.nextInt(150)));

        }*/

        for (int i = 0; i < omegaX.size(); i++) {
            double result = SCALE * (omegaX.get(i) * i + omegaY.get(i) + omegaZ.get(i));
            polygoneY[i] = (int)result * SCALE + X0Y0.getpY();
            polygoneX[i] = i* SCALE + X0Y0.getpX();
        }
        g2D.drawPolyline(polygoneX, polygoneY, polygoneX.length);


        //g2D.drawLine(100, 100, 200, 200);


    }

    public void drawLine(double x1, double y1, double x2, double y2) {
        g2D.drawLine(X0Y0.getpX() + (int) x1, X0Y0.getpY() + (int) y1, X0Y0.getpX() + (int) x2, X0Y0.getpY() - (int) y2);
    }

    public void drawPoint(double x, double y) {
        g2D.setColor(Color.red);
        g2D.setStroke(new BasicStroke(2.9f));
        g2D.drawRect(X0Y0.getpX() + (int) x, X0Y0.getpY() - (int) y, 2, 2);
    }


    public void drawSin() {
        g2D.setPaint(Color.GREEN);
        for (int x = frame.getWidth() / 2; x < frame.getWidth(); x++) {
            int y = (int) (150 * Math.sin(Math.toRadians(x)) + frame.getHeight() / 2);
            g2D.fillOval(x, y, 4, 4);
        }
    }

    public void drawXY() {
        //Рисуем оси
        g2D.setStroke(new BasicStroke(3.9f));
        g2D.drawLine(50, frame.getHeight() / 2, frame.getWidth() - PADDING, frame.getHeight() / 2);
        g2D.drawLine(frame.getWidth() / 2, PADDING, frame.getWidth() / 2, frame.getHeight() - (PADDING + PADDING / 2));
    }

    public void drawCanvas() {
        // Расчерчиваем холст
        g2D.setStroke(new BasicStroke(0.9f));
        for (int i = 0; i < frame.getHeight(); i += 10) {
            g2D.drawLine(0, i * SCALE, frame.getWidth(), i * SCALE);
        }
        for (int i = 0; i < frame.getWidth(); i += 10) {
            g2D.drawLine(i * SCALE, 0, i * SCALE, frame.getHeight());
        }
    }

    class Point {
        private int pX;
        private int pY;

        public void setpX(int pX) {
            this.pX = pX;
        }

        public void setpY(int pY) {
            this.pY = pY;
        }

        public int getpY() {

            return pY;
        }

        public int getpX() {

            return pX;
        }

        public Point(int pX, int pY) {
            this.pX = pX;
            this.pY = pY;

        }

        public Point getPoint() {
            return new Point(this.pX, this.pY);
        }

        public void setPoint(int pX, int pY) {
            this.pX = pX;
            this.pY = pY;
        }
    }

}
