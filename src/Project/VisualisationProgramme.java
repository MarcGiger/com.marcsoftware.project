package Project;

import java.awt.*;
import java.io.IOException;

public class VisualisationProgramme {

    private static final int WIDTH = 16;
    private static final int COLUMN = 9;
    private Gui gui;


    public VisualisationProgramme() throws IOException {
        gui = new Gui(WIDTH, COLUMN);
    }

    public static void main(String[] args) throws IOException {

        new VisualisationProgramme();

    }


}
