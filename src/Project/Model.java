package Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

public class Model implements Serializable {

    private final int width;
    private final int column;
    private final Random rand;
    private final File storageFile;
    private Animal[][] animal;

    public Model(int width, int column) {
        this.width = width;
        this.column = column;
        animal = new Animal[width][column];
        rand = new Random();
        storageFile = new File("Model.ser");
        placeAnimal();


    }

    public void placeAnimal() {
        if (animal == null) {
            animal = new Animal[width][column];
        }
        System.out.println("place Animals");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                if (rand.nextInt(5) < 1) {
                    animal[i][j] = new Fish(); // place Fish-Object in animal Array
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                if (rand.nextInt(50) < 1 && !(animal[i][j] instanceof Fish)) {
                    animal[i][j] = new Shark(); // place Shark-Object in animal Array
                }
            }
        }

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                if (animal[i][j] == null) {
                    animal[i][j] = new Water(); // place Water-Object in animal Array
                }
            }

        }
        // if no shark is generated by for-loop
        if (Shark.getNumOfSharks() == 0) {
            animal[width - 1][column - 1] = new Shark();
        }
    }

    // lets the animal swim (not codded yet)
    public void moveAnimal() {
    }

    public Animal getObject(int i, int j) {
        Animal a1;
        return a1 = animal[i][j];
    }

    public void resetAnimal() {
        System.out.println("Reset");
        Fish.resetSumOfFishSwarms();
        Shark.resetSumOfSharks();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                animal[i][j] = null; // emptying the Array
            }
        }
    }

    public void saveModel(File file) {
        try (final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            (objectOutputStream).writeObject(animal);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("saved");

    }

    public void loadModel(File file) {
        try (final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            animal = (Animal[][]) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("loaded");
    }

    public File getStorageFile() {
        return storageFile;
    }

    public void updateStats() {

    }

    //This method is for testing purposes. Is the populating of the grid working?
    public void tellMeWhatsInside() {

        System.out.println("Tell me whats inside?");
        int numOfFishSwarms = 0;
        int numOfSharks = 0;
        int numOfWater = 0;
        int empty = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                if (animal[i][j] != null) {
                    final Animal a1 = this.animal[i][j];
                    if (a1 instanceof Fish) {
                        numOfFishSwarms++;
                    }
                    if (a1 instanceof Shark) {
                        numOfSharks++;
                    } else {
                        numOfWater++;
                    }
                } else {
                    empty++;
                }
            }
        }
        Shark.setSumOfSharks(numOfSharks);
        Fish.setSumOfFishSwarms(numOfFishSwarms);

        if (empty == width * column) {
            System.out.println("all entries are null");
        } else {
            System.out.println("Fishs:" + numOfFishSwarms + "\nSharks:" + numOfSharks + "\nWater:" + numOfWater);
        }


    }


}
