package Project;

import java.io.Serializable;

public abstract class Animal implements Serializable {
    protected boolean alive;

    public Animal() {
        this.alive = true;
    }

}
