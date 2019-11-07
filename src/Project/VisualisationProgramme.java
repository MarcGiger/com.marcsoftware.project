package Project;

import java.awt.*;

public class VisualisationProgramme {

    private static final int WIDTH = 16;
    private static final int COLUMN = 9;
    private Gui gui;


    public VisualisationProgramme() {
        gui = new Gui(WIDTH, COLUMN);
    }

    public static void main(String[] args) {
        new VisualisationProgramme();
    }


}
