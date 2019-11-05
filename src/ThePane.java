import javax.swing.*;
import java.awt.*;

public class ThePane extends JFrame {
    // getting inputs from https://stackoverflow.com/questions/34036216/drawing-java-grid-using-swing
    // getting inputs from https://docs.oracle.com/javase/7/docs/api/java/awt/GridLayout.html

    public ThePane() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Simulation 1.0");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TheGrid());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

    }
}
