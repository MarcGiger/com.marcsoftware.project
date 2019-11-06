package Project;

import java.util.Random;

public class Model {

    public Animal[][] animal;
    private int width, column;
    private Fish fish;
    private Shark shark;
    private Random rand;

    public Model(int width, int column){
        animal = new Animal[width][column];
        rand = new Random();
        placeAnimal();
    }

    public Animal[][] getAnimal() {
        return animal;
    }

    public void placeAnimal(){
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                if (rand.nextInt(5) < 1) {
                    animal[i][j] = new Fish();
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                if (rand.nextInt(30) < 1) {
                    animal[i][j] = new Shark();

                }
            }
        }
    }

}
