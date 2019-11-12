package Project;

import java.io.Serializable;

public abstract class Animal implements Serializable {
    private boolean alive;

    public Animal() {
        this.alive = true;
    }

}
