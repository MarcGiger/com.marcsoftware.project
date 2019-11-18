package Project;

/**
 * The driver class for the visualisation program. Run to see what happens - if you are brave enough. :-)
 *
 * @author Marc Giger
 * @version 0.1
 */
public class VisualisationProgramme {
    // declares the width of the grid (value should not be modified)
    private static final int WIDTH = 16;
    //declares the amount of columns within the grid (value should not be modified)
    private static final int COLUMN = 9;
    // nested Object gui
    private Gui gui;

    /**
     * Sets up the programmes interface and displays it.
     */
    public VisualisationProgramme() {
        gui = new Gui(WIDTH, COLUMN);
    }

    /**
     * The entry point for the application. The main method instanciates the application, which then sets up the gui and displays it.
     *
     * @param args not used
     */
    public static void main(String[] args) {
        new VisualisationProgramme();
    }
}