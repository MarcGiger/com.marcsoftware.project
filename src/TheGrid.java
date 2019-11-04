import javax.swing.*;
import java.awt.*;

public class TheGrid extends JFrame {
    // getting inputs from https://stackoverflow.com/questions/34036216/drawing-java-grid-using-swing
    // getting inputs from https://docs.oracle.com/javase/7/docs/api/java/awt/GridLayout.html


    public static void main(String[] args) {
        new TheGrid();
    }

    public TheGrid() {
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
                frame.add(new ProgPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

    }
}


/**
 * setSize(500, 500);
 * setVisible(true);
 * }
 * <p>
 * public void paint(Graphics g) {
 * for (int x = 30; x <= 300; x += 30)
 * for (int y = 30; y <= 300; y += 30)
 * g.drawRect(x, y, 30, 30);
 * <p>
 * }
 * <p>
 * public static void main(String args[]) {
 * TheGrid application = new TheGrid();
 * application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 * }
 * }
*/