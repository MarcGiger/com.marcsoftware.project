import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private static final Color LINECOLOUR = Color.DARK_GRAY;
    private static final Color FISHCOLOUR = Color.GRAY;
    private static final Color SHARKCOLOUR = Color.RED;
    private final int ROWS= 20, COLUMNS = 20;

    public Field(){
        setPreferredSize(new Dimension(400,400));
        setBackground(Color.BLUE);
        setVisible(true);

    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        int width = getWidth();
        int heigth = getHeight();

        graphics.setColor(LINECOLOUR);
        for(int col =1; col < COLUMNS;col++){
            int x = col *width/COLUMNS;
            graphics.drawLine(x,0,x,heigth);
        }
    }

}
