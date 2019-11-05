import javax.swing.*;
import java.awt.*;

public class VisualisationProgramme {

    public static void main(String[] args) {

        new ThePane();

        Fish f1 = new Fish();
        Shark s1 = new Shark();

        JFrame jf=new JFrame("Hello");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setSize(300,300);
        jf.setLocationRelativeTo(null);

        jf.pack();
        jf.add(new TheGrid2());


    }

}
