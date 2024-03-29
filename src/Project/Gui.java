package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JButton resetButton, simulateButton;
    private JLabel sharksLabel, fishLabel, userLabel, stepsLabel, save, load;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem i1, i2, i3, i4, i5;
    private Image fishImg, broomStickImg, sharkImg;
    // user sets the amount of iteration of the simulation
    private int insertInt, stepCount;
    private Music sharkMusic;

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

        //for music while simulating
        sharkMusic = new Music();

        // source: https://stackoverflow.com/questions/20680060/location-of-jframe-in-middle-of-the-window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        //JLabel
        sharksLabel = new JLabel();
        fishLabel = new JLabel();
        userLabel = new JLabel();
        stepsLabel = new JLabel();

        //JButton
        resetButton = new JButton("Reset");
        broomStickImg = new ImageIcon(this.getClass().getResource("/Project/Pictures/Clear-icon.png")).getImage();
        resetButton.setIcon(new ImageIcon(broomStickImg));
        resetButton.addActionListener(new ResetHandler());
        simulateButton = new JButton("Simulation");
        // Source: https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html#getresource
        fishImg = new ImageIcon(this.getClass().getResource("/Project/Pictures/fishButton.png")).getImage();
        simulateButton.setIcon(new ImageIcon(fishImg));
        simulateButton.addActionListener(new SimulationHandler());
        createMenu();
        sharkImg = new ImageIcon(this.getClass().getResource("/Project/Pictures/icons8-shark-96.png")).getImage();
        this.setVisible(true);
        board = new Board();
        this.setContentPane(board);

    }


    /**
     * This method creates and adds the MenuBar, Menu and MenuItem. This method is created to reduce the code within
     * the constructor and keep it easier to read.
     * sources:
     * https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html
     * https://www.ntu.edu.sg/home/ehchua/programming/java/J4a_GUI_2.html
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

        i1.addActionListener(new MenuHandler());
        i2.addActionListener(new MenuHandler());
        i3.addActionListener(new MenuHandler());
        i4.addActionListener(new MenuHandler());
        i5.addActionListener(new MenuHandler());

        setJMenuBar(menuBar);
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
                    if ((model.getAnimal(i, j) instanceof Fish)) {
                        g.setColor((model.getAnimal(i, j)).getColour());
                    }
                    if (model.getAnimal(i, j) instanceof Shark) {
                        g.setColor((model.getAnimal(i, j)).getColour());
                    }
                    if (model.getAnimal(i, j) instanceof Water) {
                        g.setColor((model.getAnimal(i, j)).getColour());
                        g.drawImage(fishImg, SPACING + i * 80, SPACING + j * 80 + 60, null);
                    }
                    // paints the Content Pane
                    // SPACING + j * 80 + 60 (60 is for JButton and JLabel)
                    g.fillRect(SPACING + i * 80, SPACING + j * 80 + 60, 80 - 2 * SPACING, 80 - 2 * SPACING);
                }
            }

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < row; j++) {
                    //over paint sharkColourRect with shark img
                    if (model.getAnimal(i, j) instanceof Shark) {
                        g.drawImage(sharkImg, SPACING + i * 80, SPACING + j * 80 + 60, null);
                    }
                    //over paint fishColourRect with fish img
                    if (model.getAnimal(i, j) instanceof Fish) {
                        g.drawImage(fishImg, SPACING + 14 + i * 80, SPACING + 14 + j * 80 + 60, null);
                    }
                }
            }
            //JButton
            add(resetButton);
            resetButton.setBounds(getWidth() / 2 - 160, 1, 150, 58);
            add(simulateButton);
            simulateButton.setBounds(getWidth() / 2, 1, 150, 58);

            //JLabel
            add(sharksLabel);
            sharksLabel.setBounds(8, -30, 100, 100);
            sharksLabel.setText("Sharks: " + Shark.getNumOfSharks());
            add(fishLabel);
            fishLabel.setBounds(8, -15, 100, 100);
            fishLabel.setText("Fish: " + Fish.getSumOfFishSwarms());
            add(stepsLabel);
            stepsLabel.setBounds(8, 0, 100, 100);
            stepsLabel.setText("Steps: " + stepCount);
            add(userLabel);
            userLabel.setBounds(1180, -30, 100, 100);
            // source: https://stackoverflow.com/questions/19990038/how-to-get-windows-username-in-java
            // source: https://stackoverflow.com/questions/19990038/how-to-get-windows-username-in-java
            userLabel.setText("User: " + System.getProperty("user.name").substring(0, Math.min(9, System.getProperty("user.name").length())));
            userLabel.setForeground(new Color(75, 0, 130));
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
            model.resetAllAnimal();
            model.placeAnimal();
            // for testing purposes
            model.tellMeWhatsInside();
            board.resetBoard();
            stepCount = 0;
            JOptionPane.showMessageDialog(null, "Initial board Reset!");
        }
    }

    /**
     * Inner class which handles clicks on a button
     * Source: Help from course notes
     */
    private class SimulationHandler implements ActionListener {
        /**
         * When the button is clicked, response starts here
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            insertInt = 0;

            while (insertInt == 0 || insertInt > 2000) {
                try {
                    insertInt = Integer.parseInt(JOptionPane.showInputDialog(null, "How many steps shall be simulated? (max. 2000)"));
                }
                // forces the user to insert a number between 0 and 2001
                catch (Exception e) {
                    insertInt = 0;
                }
            }
            sharkMusic.playMusic();
            for (int a = insertInt; a > 0; a--) {


                // replaces the shark on the grid to a neighbour position if possible
                model.letSharkSwim();
                // spawns a shark at a neighbour position if the probability strikes and if possible
                model.spawnAShark();
                // redraw board show the new positions and new spawns on the board
                board.resetBoard();
                stepCount++;
                // sources for threading https://dzone.com/articles/java-thread-tutorial-creating-threads-and-multithr
                // https://www.wideskills.com/java-tutorial/java-threads-tutorial
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Shark.getNumOfSharks() == 0) {
                    JOptionPane.showMessageDialog(null, "Oh no, the Shark extinct!");
                    break;
                }
            }

            sharkMusic.stopMusic();
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
            //stores the pressed MenuItem name
            menuName = event.getActionCommand(); // what's written on the item that was clicked

            //other way could have been with if and else, but this seemed more "handy"
            switch (menuName) {
                case "Save current stats":
                    /*just playing with a timer and visualise it with a dialog window (help and source below)
                    http://www.java2s.com/Tutorials/Java/Swing_How_to/JOptionPane/Use_Timer_to_close_JOptionPane_after_few_seconds.htm
                    https://docs.oracle.com/javase/8/docs/api/javax/swing/Timer.html */
                    dialog = new JDialog();
                    dialog.setSize(100, 80);
                    save = new JLabel("   Saving...");
                    dialog.add(save);
                    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                    dialog.setLocation(dim.width / 2 - dialog.getSize().width / 2, dim.height / 2 - dialog.getSize().height / 2);
                    dialog.setModal(false);
                    dialog.setVisible(true);
                    dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                    // dialog shall be shown 2 seconds
                    Timer t = new Timer(2000, e -> dialog.setVisible(false));
                    t.start();
                    // without setRepeats it continues to fire events every time the between-event delay has elapsed, until it is stopped (lesson learned:)
                    t.setRepeats(false);
                    // actually what should be done when clicked (save the animal Array)
                    model.saveModel(model.getStorageFile());
                    break;

                case "Load stats":
                    if (model.isSaved() == true) {
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
                        // dialog shall be shown 1.1 seconds
                        Timer t2 = new Timer(1100, e -> dialog2.setVisible(false));
                        t2.start();
                        // without setRepeats it continues to fire events every time the between-event delay has elapsed, until it is stopped (lesson learned:)
                        t2.setRepeats(false);

                        // emptying the actual animal Array (to prevent bugs)
                        model.resetAllAnimal();
                        // actually what should be done when clicked (load the animal Array)
                        model.loadModel(model.getStorageFile());
                        // redraw the board
                        board.resetBoard();
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Nothing has been saved yet");
                        break;
                    }

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
                    JOptionPane.showMessageDialog(null, "an error occurred");
                    break;
            }
        }
    }

}
