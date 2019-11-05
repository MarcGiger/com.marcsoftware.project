import javax.swing.*;
import java.awt.*;

public class TheGrid extends JPanel {

        public TheGrid() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int size = Math.min(getWidth() - 4, getHeight() - 4) / 10;
            int width = getWidth() - (size * 2);
            int height = getHeight() - (size * 2);

            int y = (getHeight() - (size * 10)) / 2;
            for (int horz = 0; horz < 10; horz++) {
                int x = (getWidth() - (size * 10)) / 2;
                for (int vert = 0; vert < 10; vert++) {
                    g.drawRect(x, y, size, size);
                    x += size;
                }

                y += size;

                // how to colour grid boxes http://www.javased.com/index.php?post=2374295
                // g.setColor(Color.green) changes grid colour ;
               //  g2d.setColor(Color.magenta) does nothing;

            }
            g2d.dispose();
        }

    }

