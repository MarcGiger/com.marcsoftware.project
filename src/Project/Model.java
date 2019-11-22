package Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class sets up the animal grid, which then will be visualised by the Gui class.
 */
public class Model implements Serializable {

    private final int width;
    private final int column;
    private final Random rand;
    private final File storageFile;
    private Animal[][] animal;
    private Simulation s1;
    private ArrayList<Shark> storeSharks = new ArrayList<>();

    public Model(int width, int column) {
        this.width = width;
        this.column = column;
        animal = new Animal[width][column];
        rand = new Random();
        storageFile = new File("Model.ser");
        placeAnimal();
        letSharkSwim();

       /* for(Shark a : storeSharks){
            System.out.println(a.toString());
        }

        */
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
                    animal[i][j] = new Shark(i, j);// place Shark-Object in animal Array
                    storeSharks.add((Shark) animal[i][j]);
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
            animal[width - 1][column - 1] = new Shark(width - 1, column - 1);
            storeSharks.add((Shark) animal[width - 1][column - 1]);
        }
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

    /**
     * This method saves the Animal Array.
     * <p>
     * Created with help from Persistence notes (Powerpoint) and other sources:
     * https://stackoverflow.com/questions/1467193/java-serialization-of-multidimensional-array
     *
     * @param file is created when constuctor is envoked and gets stored within the running program
     */
    public void saveModel(File file) {
        try (final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            (objectOutputStream).writeObject(animal);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("saved");
    }

    /**
     * This method loads the Animal Array.
     * <p>
     * The loading was challenging, because the 2dArray had sometimes null assigned to it.
     * Therefore, I added the class Water to never have null assigned within the Array.
     * <p>
     * Created with help from Persistence notes (Powerpoint) and other source:
     * https://stackoverflow.com/questions/1467193/java-serialization-of-multidimensional-array
     *
     * @param file is created when constuctor is envoked and gets stored within the running program
     */
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
            System.out.println("Fish:" + numOfFishSwarms + "\nSharks:" + numOfSharks + "\nWater:" + numOfWater);
        }


    }

    public void letSharkSwim() {
        for (Shark a : storeSharks) {
            //a.getNeighbour();
            ArrayList<Integer> test = new ArrayList<>();

            int north = a.getPositiveNeighbourY();
            int south = a.getNegativeNeighbourY();
            int west = a.getNegativeNeighbourX();
            int east = a.getPositiveNeighbourX();

            if (north >= 0 && animal[north][a.getPositionY()] instanceof Water) test.add(north);
            if (south >= 0 && animal[north][a.getPositionY()] instanceof Water) test.add(south);
            if (west >= 0 && animal[a.getPositionX()][west] instanceof Water) test.add(west);
            if (east >= 0 && animal[a.getPositionX()][south]instanceof Water) test.add(east);

            if (test.get(rand.nextInt(test.size() - 1)) == north)
                animal[a.getPositionX()][a.getPositionY()] = new Water();
            animal[a.getPositionX()][north] = new Shark(a.getPositionX(),north);
            a.setPositionX(north);


                if (test.get(rand.nextInt(test.size() - 1)) == south)

                    if (test.get(rand.nextInt(test.size() - 1)) == west)

                        if (test.get(rand.nextInt(test.size() - 1)) == east)




                            System.out.println(a.toString());


        }
    }
   /* public void letSharkSwimLeft() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                if (animal[i][j] instanceof Shark) {


                    //s1.random().toString();


                    if(i<16){

                        int a,b;
                        a=i;
                        b=j;

                        if (animal[a+Simulation.WEST.getDeltaX()][b] instanceof Water){
                            animal[a+Simulation.WEST.getDeltaX()][b] = new Shark();
                            animal[i][j] = null;
                            animal[i][j] = new Water();
                            Shark.setSumOfSharks(Shark.getNumOfSharks()-1);

                        }
                    }

                }
            }
        }
    }
    public void letSharkSwim() {
        boolean moved=false;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < column; j++) {
                if (animal[i][j] instanceof Shark) {


                    //s1.random().toString();


                    if(i<width){

                        int a,b;
                        a=i;
                        b=j;

                        if (animal[a-Simulation.WEST.getDeltaX()][b] instanceof Water && (a)<16){
                            animal[a-Simulation.WEST.getDeltaX()][b] = new Shark();
                            animal[i][j] = null;
                            animal[i][j] = new Water();
                            Shark.setSumOfSharks(Shark.getNumOfSharks()-1);
                            moved=true;
                            break;
                        }
                    }

                }
            }
            if (moved==true) break;
        }
    }



*/
}
