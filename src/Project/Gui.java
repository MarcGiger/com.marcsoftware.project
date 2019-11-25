package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

/**
 * A graphical view of the Gui. A Menu and Buttons are implemented.
 * The view shows for every position a coloured rectangle, which represents the type of the placed Animal.
 *
 * @author Marc Giger
 * @version 0.1
 */
public class Gui extends JFrame {

    // line between rectangles
    private final int SPACING = 1;
    // values received from driver class
    private final int width, row;
    // nested objects
    private JDialog dialog, dialog2;
    private Model model;
    private Board board;
    private JButton reset, simulate;
    private JLabel sharksLabel, fishLabel, save, load;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem i1, i2, i3, i4, i5;
    // for JButton
    private Image img, img2;
    private int insertInt;

    // background colour for Menu and Content
    private static final Color BACKGROUND_COLOR = Color.lightGray;

    /**
     * The Gui class represents the graphical user interface. It visualises what got initialised in the model class
     * and shows the changes while running the Simulation class. Furthermore, it displays a menu and some buttons.
     *
     * @param width this int gets passed from the driver class and sets the with within grid
     * @param row   this int gets passed from the driver class and sets the amount of columns within the grid
     */
    public Gui(int width, int row) {
        model = new Model(width, row);
        this.setTitle("Visualisation");
        this.setSize(1296, 843);
        this.setDefaultCloseOperation(Gui.EXIT_ON_CLOSE);
        //to prevent not ideal frames
        this.setResizable(false);
        this.width = width;
        this.row = row;


        // source: https://stackoverflow.com/questions/20680060/location-of-jframe-in-middle-of-the-window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        //JLabel
        sharksLabel = new JLabel();
        fishLabel = new JLabel();

        this.setVisible(true);
        board = new Board();
        this.setContentPane(board);

        // after adding Menu l needed to adapt Graphics g
        createMenu();

        //JButton
        reset = new JButton("Reset");
        img2 = new ImageIcon(this.getClass().getResource("/Project/pictures/Clear-icon.png")).getImage();
        reset.setIcon(new ImageIcon(img2));
        reset.addActionListener(new ResetHandler());
        simulate = new JButton("Simulation");
        // Source: https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html#getresource
        img = new ImageIcon(this.getClass().getResource("/Project/pictures/fishButton.png")).getImage();
        simulate.setIcon(new ImageIcon(img));
        simulate.addActionListener(new SimulationHandler());


        board.paintImmediately(0, 0, 1280, 880);

    }

    //

    /**
     * This method creates and adds the MenuBar, Menu and MenuItem. This method is created to reduce the code within
     * the constructor and keep it easier to read.
     * <p>
     * sources: https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html helped me to set up the menu
     * https://www.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI_2.html  helped me to set up the menu
     * https://www.geeksforgeeks.org/java-swing-jmenubar/
     */
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
        setJMenuBar(menuBar);

        i1.addActionListener(new MenuHandler());
        i2.addActionListener(new MenuHandler());
        i3.addActionListener(new MenuHandler());
        i4.addActionListener(new MenuHandler());
        i5.addActionListener(new MenuHandler());
    }

    /**
     * The private Board class draws the grid and adds & displays the other features (Buttons, Menu)
     */
    private class Board extends JPanel {

        // source: https://www.youtube.com/watch?v=EMu1cC2Vnis helped me to set up the visualisation of the grid
// source: https://docs.oracle.com/javase/7/docs/api/javax/swing/JComponent.html#paintComponent(java.awt.Graphics)

        /**
         * Calls the UI delegate's paint method, if the UI delegate is non-null. We pass the delegate a copy of the Graphics object to protect the rest of the paint code from irrevocable changes (for example, Graphics.translate).
         * If you override this in a subclass you should not make permanent changes to the passed in Graphics. For example, you should not alter the clip Rectangle or modify the transform. If you need to do these operations you may find it easier to create a new Graphics from the passed in Graphics and manipulate it. Further, if you do not invoker super's implementation you must honor the opaque property, that is if this component is opaque, you must completely fill in the background in a non-opaque color. If you do not honor the opaque property you will likely see visual artifacts.
         * <p>
         * The passed in Graphics object might have a transform other than the identify transform installed on it. In this case, you might get unexpected results if you cumulatively apply another transform.
         *
         * @param g the Graphics object to protect
         */
        @Override
        public void paintComponent(Graphics g) {
            g.setColor(BACKGROUND_COLOR);
            g.fillRect(0, 0, 1280, 880);

            // gets and sets the colour for the Content Pane
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < row; j++) {
                    g.getColor();
                    if ((model.getObject(i, j) instanceof Fish)) {
                        g.setColor((model.getObject(i, j)).getColour());
                    }
                    if (model.getObject(i, j) instanceof Shark) {
                        g.setColor((model.getObject(i, j)).getColour());
                    }
                    if (model.getObject(i, j) instanceof Water) {
                        g.setColor((model.getObject(i, j)).getColour());
                    }
                    // paints the Content Pane
                    // SPACING + j * 80 + 60 (60 is for JButton and JLabel)
                    g.fillRect(SPACING + i * 80, SPACING + j * 80 + 60, 80 - 2 * SPACING, 80 - 2 * SPACING);
                }
            }
            //JButton
            add(reset);
            reset.setBounds(getWidth() / 2 - 160, 1, 150, 58);
            add(simulate);
            simulate.setBounds(getWidth() / 2, 1, 150, 58);
           

            //JLabel
            add(sharksLabel);
            sharksLabel.setBounds(8, -30, 100, 100);
            sharksLabel.setText("Sharks: " + Shark.getNumOfSharks());
            add(fishLabel);
            fishLabel.setBounds(8, -15, 100, 100);
            fishLabel.setText("Fish: " + Fish.getSumOfFishSwarms());

        }

        /**
         * This method clears the Board class and repaints it. If the grid got changed, it will be illustrated after calling this method.
         */
        public void resetBoard() {
            // source: https://stackoverflow.com/questions/47545250/java-repaint-gridlayout
            removeAll();
            revalidate();
            //repaint();
            paintImmediately(0, 0, 1280, 880);
            model.tellMeWhatsInside();
        }
    }

    /**
     * Inner class which handles clicks on a button
     * Source: Help from course notes
     */
    private class ResetHandler implements ActionListener {
        /**
         * When the button is clicked, response starts here
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            model.resetStoreSharksArrayList();
            model.resetAnimal();
            model.placeAnimal();
            // for testing purposes
            model.tellMeWhatsInside();

            board.resetBoard();
            JOptionPane.showMessageDialog(null, "Initial board Reset!");
        }
    }

    private class SimulationHandler implements ActionListener {
        /**
         * When the button is clicked, response starts here
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            insertInt = 0;
            // sources for threading https://dzone.com/articles/java-thread-tutorial-creating-threads-and-multithr
            // https://www.geeksforgeeks.org/multithreading-in-java/
            insertInt = Integer.parseInt(JOptionPane.showInputDialog(null, "How many steps shall be simulated?", "Please tell me", 1));
            while (insertInt == 0) {
                insertInt = Integer.parseInt(JOptionPane.showInputDialog(null, "How many steps shall be simulated?", "Please tell me", 1));
            }
            for (int a = insertInt; a > 0; a--) {
                model.letSharkSwim();
                board.resetBoard();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * Inner class which handles clicks on the menu.
     * Source: Help from course notes
     */
    private class MenuHandler implements ActionListener {
        /**
         * When an item is clicked, response starts here
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            String menuName;
            menuName = event.getActionCommand(); // what's written on the item that was clicked

            //other way could have been with if and else, but this seemed more "handy"
            switch (menuName) {
                // source: Timer http://www.java2s.com/Tutorials/Java/Swing_How_to/JOptionPane/Use_Timer_to_close_JOptionPane_after_few_seconds.htm
                // source: https://docs.oracle.com/javase/8/docs/api/javax/swing/Timer.html
                case "Save current stats":
                    // just playing with a timer and visualise it with a dialog window
                    dialog = new JDialog();
                    dialog.setSize(100, 80);
                    save = new JLabel("   Saving...");
                    dialog.add(save);
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);
                    dialog.setModal(false);
                    dialog.setVisible(true);
                    dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                    Timer t = new Timer(2000, e -> dialog.setVisible(false));
                    t.start();
                    // without setRepeats it continues to fire events every time the between-event delay has elapsed, until it is stopped (lesson learned:)
                    t.setRepeats(false);
                    // actually what should be done when clicked (save the animal Array)
                    model.saveModel(model.getStorageFile());
                    break;

                case "Load stats":
                    // just playing with a timer and visualise it with a dialog window
                    dialog2 = new JDialog();
                    dialog2.setSize(100, 80);
                    load = new JLabel("   Loading...");
                    dialog2.add(load);
                    Dimension dim2 = Toolkit.getDefaultToolkit().getScreenSize();
                    dialog2.setLocation(dim2.width / 2 - dialog2.getSize().width / 2, dim2.height / 2 - dialog2.getSize().height / 2);
                    dialog2.setModal(false);
                    dialog2.setVisible(true);
                    dialog2.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                    Timer t2 = new Timer(1100, e -> dialog2.setVisible(false));
                    t2.start();
                    // without setRepeats it continues to fire events every time the between-event delay has elapsed, until it is stopped (lesson learned:)
                    t2.setRepeats(false);


                    // emptying the actual animal Array (to prevent bugs)
                    model.resetAnimal();
                    // actually what should be done when clicked (load the animal Array)
                    model.loadModel(model.getStorageFile());
                    // model.tellMeWhatsInside();
                    // redraw the board
                    board.resetBoard();
                    //System.out.println(Shark.getNumOfSharks());
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
