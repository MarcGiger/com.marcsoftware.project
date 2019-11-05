package Project;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Gui extends JFrame {

    private final int SPACING = 1;
    private int[][] fish = new int[16][9];
    private int[][] shark = new int[16][9];

    Random rand = new Random();


    public Gui() {
        this.setTitle("Visualisation");
        this.setSize(1286, 829);
        this.setDefaultCloseOperation(Gui.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        // centering a JFrame from: https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 9; j++) {
                if (rand.nextInt(5) < 1) {
                    fish[i][j] = 1;

                } else {
                    fish[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 9; j++) {
                if (rand.nextInt(30) < 1) {
                    shark[i][j] = 1;

                } else {
                    shark[i][j] = 0;
                }
            }
        }


        Board board = new Board();
        this.setContentPane(board);


    }

    public class Board extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(Color.gray);
            g.fillRect(0, 0, 1280, 800);

            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 9; j++) {
                    g.setColor(Color.blue);
                    if (fish[i][j] == 1) {
                        g.setColor(Color.PINK);
                    }
                    if (shark[i][j] == 1) {
                        g.setColor(Color.black);
                    }


                    g.fillRect(SPACING + i * 80, SPACING + j * 80 + 80, 80 - 2 * SPACING, 80 - 2 * SPACING);
                }
            }
        }
    }

}
