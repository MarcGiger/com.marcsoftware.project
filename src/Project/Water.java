package Project;

import java.awt.Color;

//not actually an animal but maybe like this l can save the Array
public class Water extends Animal implements Colourful {

    public Water() {
        alive = false;
    }

    @Override
    public Color getColor() {
        return Color.blue;
    }
}
