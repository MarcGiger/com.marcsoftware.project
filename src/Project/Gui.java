package Project;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Gui extends JFrame {

    private final int SPACING = 1;
    private int width,column;
    private Object[][] fish = new Object[16][9];
    private Object[][] shark = new Object[16][9];

    private static final Color BACKGROUND_COLOR = Color.lightGray;
    private static final Color WATER_COLOR = Color.blue;
    private static final Color SHARK_COLOR = Color.red;
    private static final Color FISH_COLOR = new Color(0, 100, 0);

    Random rand = new Random();

    public Gui(int width, int column) {
        this.setTitle("Visualisation");
        this.setSize(1286, 829);
        this.setDefaultCloseOperation(Gui.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.width = width;
        this.column = column;

        // centering a JFrame from: https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                if (rand.nextInt(5) < 1) {
                    fish[i][j] = new Fish();

                } else {
                    fish[i][j] = null;
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                if (rand.nextInt(30) < 1) {
                    shark[i][j] = new Shark();

                } else {
                    shark[i][j] = null;
                }
            }
        }
        Board board = new Board();
        this.setContentPane(board);
    }

    private class Board extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(BACKGROUND_COLOR);
            g.fillRect(0, 0, 1280, 800);

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < column; j++) {
                    g.setColor(WATER_COLOR);
                    if (fish[i][j] != null) {
                        g.setColor(FISH_COLOR);
                    }
                    if (shark[i][j] != null) {
                        g.setColor(SHARK_COLOR);
                    }
                    g.fillRect(SPACING + i * 80, SPACING + j * 80 + 80, 80 - 2 * SPACING, 80 - 2 * SPACING);
                }
            }
        }

    }

}
