package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Gui extends JFrame {

    private final int SPACING = 1;
    private int width, column;
    private Model model;
    private Board board;
    private JButton reset;
    private JLabel sharksLabel, fishLabel;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem i1, i2, i3, i4, i5;
    private static final Color BACKGROUND_COLOR = Color.lightGray;


    public Gui(int width, int column) throws IOException, ClassNotFoundException {
        this.setTitle("Visualisation");
        this.setSize(1296, 843);
        this.setDefaultCloseOperation(Gui.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.width = width;
        this.column = column;

        model = new Model(width, column);

        // https://stackoverflow.com/questions/20680060/location-of-jframe-in-middle-of-the-window causes problems on my laptop but works fine on school pc...
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        this.setVisible(true);
        board = new Board();
        this.setContentPane(board);

        reset = new JButton("Reset");
        reset.addActionListener(new ResetHandler());

        sharksLabel = new JLabel();
        fishLabel = new JLabel();

        //https://www.geeksforgeeks.org/java-swing-jmenubar/
        //after adding Menu l needed to adapt g.fillRect
        menuBar = new JMenuBar();
        menuBar.setBackground(Color.lightGray);
        menu = new JMenu("Menu");
        i1 = new JMenuItem("Save current stats");
        i2 = new JMenuItem("Load stats");
        i3 = new JMenuItem("Dummy 1");
        i4 = new JMenuItem("Dummy 2");
        i5 = new JMenuItem("Dummy 3");
        menuBar.add(menu);
        menu.add(i1);
        menu.add(i2);
        menu.add(i3);
        menu.add(i4);
        menu.add(i5);
        // redraw.setVisible(true); why redundant
        // this.setVisible(true); why position not important
    }

    private class Board extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            g.setColor(BACKGROUND_COLOR);
            g.fillRect(0, 0, 1280, 880);

            //Menu
            setJMenuBar(menuBar);


            //JButton
            add(reset);
            reset.setBounds(getWidth() / 2 - 50, 10, 95, 35);

            //JLabel
            add(sharksLabel);
            sharksLabel.setBounds(8, -30, 100, 100);
            sharksLabel.setText("Sharks: " + Shark.getNumOfSharks());
            add(fishLabel);
            fishLabel.setBounds(8, -15, 100, 100);
            fishLabel.setText("Fish: " + Fish.getSumOfFishSwarms());


            for (int i = 0; i < width; i++) {
                for (int j = 0; j < column; j++) {
                    g.setColor(WATER_COLOR);
                    if ((model.getObject(i, j) instanceof Fish)) {
                        g.setColor(FISH_COLOR);
                    }
                    if (model.getObject(i, j) instanceof Shark) {
                        g.setColor(SHARK_COLOR);
                    }
                    // SPACING + j * 80 + 60 (60 is for JButton and JLabel)
                    g.fillRect(SPACING + i * 80, SPACING + j * 80 + 60, 80 - 2 * SPACING, 80 - 2 * SPACING);
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

    private class ResetHandler implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "You clicked Reset!");
            model.resetAnimal();
            model.placeAnimal();
            // for testing purposes
            model.tellMeWhatsInside();

            board.resetBoard();

        }
    }
}
