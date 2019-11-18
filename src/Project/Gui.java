package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A graphical view of the Gui. A Menu and Buttons are implemented.
 * The view shows for every position a coloured rectangle, which represents the type of Animal.
 *
 * @author Marc Giger
 * @version 0.1
 */
public class Gui extends JFrame {

    private final int SPACING = 1;
    private final int width, column;
    // nested objects
    private JDialog dialog;
    private Model model;
    private Board board;
    private JButton reset;
    private JLabel sharksLabel, fishLabel, save;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem i1, i2, i3, i4, i5;

    // background colour for Menu and Content
    private static final Color BACKGROUND_COLOR = Color.lightGray;


    public Gui(int width, int column) {
        model = new Model(width, column);
        this.setTitle("Visualisation");
        this.setSize(1296, 843);
        this.setDefaultCloseOperation(Gui.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.width = width;
        this.column = column;


        // https://stackoverflow.com/questions/20680060/location-of-jframe-in-middle-of-the-window causes problems on my laptop but works fine on school pc...
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        sharksLabel = new JLabel();
        fishLabel = new JLabel();

        this.setVisible(true);
        board = new Board();
        this.setContentPane(board);

        reset = new JButton("Reset");
        reset.addActionListener(new ResetHandler());


        //https://www.geeksforgeeks.org/java-swing-jmenubar/
        //after adding Menu l needed to adapt Graphics g
        createMenu();


        // redraw.setVisible(true); why redundant
        // this.setVisible(true); why position not important
    }

    // https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html helped me to set up the menu
    //https://www.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI_2.html  helped me to set up the menu
    public void createMenu() {
        menuBar = new JMenuBar();
        menuBar.setBackground(BACKGROUND_COLOR);
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

        i1.addActionListener(new MenuHandler());
        i2.addActionListener(new MenuHandler());
        i3.addActionListener(new MenuHandler());
        i4.addActionListener(new MenuHandler());
        i5.addActionListener(new MenuHandler());
    }

    private class Board extends JPanel {

        //https://www.youtube.com/watch?v=EMu1cC2Vnis helped me to set up the visualisation of the grid
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
                    g.getColor();
                    if ((model.getObject(i, j) instanceof Fish)) {
                        g.setColor(((Colourful) model.getObject(i, j)).getColour());
                    }
                    if (model.getObject(i, j) instanceof Shark) {
                        g.setColor(((Colourful) model.getObject(i, j)).getColour());
                    }
                    if (model.getObject(i, j) instanceof Water) {
                        g.setColor(((Colourful) model.getObject(i, j)).getColour());
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

        }
    }

    private class ResetHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            model.resetAnimal();
            model.placeAnimal();
            // for testing purposes
            model.tellMeWhatsInside();

            board.resetBoard();
            JOptionPane.showMessageDialog(null, "Initial board Reset!");

        }
    }

    private class MenuHandler implements ActionListener {
        /**
         * Help from course notes
         * when an item is clicked, response starts here
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            String menuName;
            menuName = event.getActionCommand(); // what's written on the item that was clicked

            switch (menuName) {
                // Timer http://www.java2s.com/Tutorials/Java/Swing_How_to/JOptionPane/Use_Timer_to_close_JOptionPane_after_few_seconds.htm
                // https://docs.oracle.com/javase/8/docs/api/javax/swing/Timer.html
                case "Save current stats":
                    dialog = new JDialog();
                    dialog.setSize(100, 80);
                    save = new JLabel("   Saving...");
                    dialog.add(save);

                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);
                    dialog.setModal(false);
                    dialog.setVisible(true);
                    dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

                    model.saveModel(model.getStorageFile());
                    //Timer t;
                    //if (t==null)
                    Timer t = new Timer(2200, e -> dialog.setVisible(false));//.setRepeats(false);
                    t.start();

                    // without setRepeats it continues to fire events every time the between-event delay has elapsed, until it is stopped (lesson learned:)
                    t.setRepeats(false);
                    //System.gc();
                    break;
                case "Load stats":
                    System.out.println("Loading...");
                    model.resetAnimal();
                    model.loadModel(model.getStorageFile());
                    model.tellMeWhatsInside();
                    board.resetBoard();
                    break;
                case "Dummy 1":
                    JOptionPane.showMessageDialog(null, "no function implemented");
                    break;
                case "Dummy 2":
                    JOptionPane.showMessageDialog(null, "no function implemented");
                    break;
                case "Dummy 3":
                    JOptionPane.showMessageDialog(null, "no function implemented");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "an error occured");
                    break;
            }
        }
    }
}
