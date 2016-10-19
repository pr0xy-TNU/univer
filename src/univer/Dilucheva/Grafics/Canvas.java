package univer.Dilucheva.Grafics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JComponent;


class MyCanvas extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //Random r = new Random();
        //new Color(150 + r.nextInt(100), 100 + r.nextInt(150), 100 + r.nextInt(150))
        g2.setPaint(Color.RED);
        for (int i = 0; i < 400; i++) {
            double x = (i) / 400.0 * 30 - 15;
            double x2 = (i + 1) / 400.0 * 30 - 15;
            int y1 = 200 - (int) (MainFrame.f(x) / 3.0 * 40);
            int y2 = 200 - (int) (MainFrame.f(x2) / 3.0 * 40);
            g2.drawLine(i, y1, i + 1, y2);
        }
    }

}
