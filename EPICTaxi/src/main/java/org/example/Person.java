package main.java.org.example;
import java.util.Random;



public class Person {
    private int locX;
    private int locY;
    private static Type type;
    private static int numberPassengers = 5;
    private static int category = 4;
    private static double rating = 6;

<<<<<<< HEAD
   private static Taxi assignedTaxi = CSVFileReading.getTaxis().get(14);
=======
   private static Taxi assignedTaxi = CSVFileReading.getTaxis().get(15);
>>>>>>> 453df01607b112b894f4af481b1000880c68c93c
    private static String assignedTaxiReg = assignedTaxi.getReg();

    public Person(int gridDimension){
        Random rand = new Random();

        do {
            this.locX = rand.nextInt(gridDimension);
            this.locY = rand.nextInt(gridDimension);
        }while(LinkedGrid.isRiver(locX, locY) || LinkedGrid.isSpaceEmpty(locX, locY));
    }

    public int getLocX() {
        return locX;
    }

    public void setLocX(int locX) {
        this.locX = locX;
    }

    public int getLocY() {
        return locY;
    }

    public void setLocY(int locY) {
        this.locY = locY;
    }


<<<<<<< HEAD
=======
    public static String getAssignedTaxiReg() {return assignedTaxiReg;}

>>>>>>> 453df01607b112b894f4af481b1000880c68c93c

   public static void setAssignedTaxiReg(String reg) {
       assignedTaxiReg = reg;
    }
<<<<<<< HEAD
=======

>>>>>>> 453df01607b112b894f4af481b1000880c68c93c



<<<<<<< HEAD


    public static Taxi getAssignedTaxi() {
        return assignedTaxi;
    }
=======
>>>>>>> 453df01607b112b894f4af481b1000880c68c93c

    public static void setAssignedTaxi(Taxi assignedTaxi) {
        Person.assignedTaxi = assignedTaxi;
    }

    public static Type getType() {
        return type;
    }

    public static void setType(Type t) {
        type = t;
    }

    public static int getNumberPassengers() {
        return numberPassengers;
    }

    public static void setNumberPassengers(int Passengers) {
        numberPassengers = Passengers;
    }

    public static int getCategory() {
        return category;
    }

    public static void setCategory(int cat) {
        category = cat;
    }

    public static double getRating() {
        return rating;
    }

    public static void setRating(double r) {
        rating = r;
    }
}



<<<<<<< HEAD

=======
>>>>>>> 453df01607b112b894f4af481b1000880c68c93c
