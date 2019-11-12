package Project;

import java.io.*;
import java.util.Random;

public class Model implements Serializable {

    public Animal[][] animal;
    private int width, column;
    private Random rand;
    private File outFile;
    private File inFile;
    private FileOutputStream outFileStream;
    private OutputStream outObjectStream;
    private FileInputStream inFileStream;
    private ObjectInputStream inObjectStream;

    public Model(int width, int column) {
        this.width = width;
        this.column = column;
        animal = new Animal[width][column];
        rand = new Random();
        placeAnimal();


        outFile = new File("Model.ser");
        //saveModel();
        //placeAnimal();
        //tellMeWhatsInside();

       /* try {
            loadModel();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("it didnt work");
        }
        tellMeWhatsInside();
        */

    }


    public void placeAnimal() {

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
        Fish.reSetSumOfFishSwarms();
        Shark.reSetSumOfSharks();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                animal[i][j] = null; // emptying the Array
            }
        }
    }

    public void saveModel() {
        try {
            outFileStream = new FileOutputStream(outFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            outObjectStream = new ObjectOutputStream(outFileStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ((ObjectOutputStream) outObjectStream).writeObject(animal);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outObjectStream.close();
            outFileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("saved");

    }

    public void loadModel() throws IOException {
        inFile = new File("Model.ser");
        inFileStream = new FileInputStream(inFile);
        inObjectStream = new ObjectInputStream(inFileStream);
        try {
            animal = (Animal[][]) inObjectStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        inFileStream.close();
        inObjectStream.close();

        System.out.println("loaded");
    }

    //This method is for testing purposes. Is the populating of the grid working?
    public void tellMeWhatsInside() {
        Animal a1;

        System.out.println("Tell me whats inside?");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {

                a1 = animal[i][j];

                if (a1 instanceof Fish)
                    System.out.println("blubb");
                if (a1 instanceof Shark)
                    System.out.println("rawwwr");
                else System.out.println("blue water");
            }
        }
        System.out.println("Fish: " + Fish.getSumOfFishSwarms() + "\nSharks: " + Shark.getNumOfSharks() + "\nBlue Water: " + (16 * 9 - Fish.getSumOfFishSwarms() - Shark.getNumOfSharks()));

    }


}
