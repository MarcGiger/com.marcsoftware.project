package Project;

import java.awt.Color;

//not actually an animal but maybe like this l can save the Array
public class Water extends Animal  {

    public Water() {
        alive = false;
    }

    @Override
    public Color getColour() {
        return Color.blue;
    }
}
