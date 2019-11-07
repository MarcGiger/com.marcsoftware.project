package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gui extends JFrame {

    private final int SPACING = 1;
    private int width, column;
    private Model model;
    private Board board;
    private JButton redraw;
    private JLabel sharks,fish;
    private static final Color BACKGROUND_COLOR = Color.lightGray;
    private static final Color WATER_COLOR = Color.blue;
    private static final Color SHARK_COLOR = Color.red;
    private static final Color FISH_COLOR = new Color(0, 100, 0);


    public Gui(int width, int column) {
        this.setTitle("Visualisation");
        this.setSize(1286, 829);
        this.setDefaultCloseOperation(Gui.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.width = width;
        this.column = column;

        model = new Model(width, column);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        this.setVisible(true);
        board = new Board();
        this.setContentPane(board);

        redraw = new JButton("Redraw");
        redraw.addActionListener(new RedrawHandler());

        sharks = new JLabel();
        fish = new JLabel();

        // redraw.setVisible(true); why redundant
        // this.setVisible(true); why position not important
    }

    private class Board extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(BACKGROUND_COLOR);
            g.fillRect(0, 0, 1280, 800);

            //JButton
            add(redraw);
            redraw.setBounds(getWidth() / 2 - 50, 10, 95, 40);

            //JLabel
            add(sharks);
            sharks.setBounds(10,0,100,100);
            sharks.setText("Sharks: "+Shark.getNumOfSharks());
            add(fish);
            fish.setBounds(10,15,100,100);
            fish.setText("Fish: "+Fish.getSumOfFishSwarms());

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < column; j++) {
                    g.setColor(WATER_COLOR);
                    if ((model.getObject(i, j) instanceof Fish)) {
                        g.setColor(FISH_COLOR);
                    }
                    if (model.getObject(i, j) instanceof Shark) {
                        g.setColor(SHARK_COLOR);
                    }
                    g.fillRect(SPACING + i * 80, SPACING + j * 80 + 80, 80 - 2 * SPACING, 80 - 2 * SPACING);
                }
            }
        }

        public void resetBoard() {
            //https://stackoverflow.com/questions/47545250/java-repaint-gridlayout
            removeAll();
            revalidate();
            repaint();
            System.out.println("new drawn");
        }
    }

    private class RedrawHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "You clicked Redraw!");
            model.resetAnimal();
            model.placeAnimal();
            // for testing purposes
            model.tellMeWhatsInside();

            board.resetBoard();

        }
    }
}
