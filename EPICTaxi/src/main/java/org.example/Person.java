
package org.example;
import java.util.Random;


public class Person {
    private static Type type;
    private static int numberPassengers = 5;
    private static int category = 4;
    private static double rating = 6;

    private static String assignedTaxiReg;

    private static int originalX;


    private static int originalY;


    private static int locX;

    private static int locY;

    public Person(int gridDimension) { //constructor
        Random rand = new Random(); //random

        do {
            locX = rand.nextInt(gridDimension); //randomly assigns x coordinate within dimensions of grid
            locY = rand.nextInt(gridDimension); //randomly assigns y coordinate within dimensions of grid

        }while(LinkedGrid.isRiver(locX, locY) || LinkedGrid.isSpaceEmpty(locX, locY)); //repeats if coordinates are in river or on grass


    }

    public static String getAssignedTaxiReg() {
        return assignedTaxiReg;
    }

    public static void setAssignedTaxiReg(String reg) {
        assignedTaxiReg = reg;
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

    public static int getOriginalX() {
        return originalX;
    }

    public void setOriginalX(int X) {
        originalX = X;
    }
    public static int getOriginalY() {
        return originalY;
    }

    public void setOriginalY(int Y) {
        originalY = Y;
    }

    public static int getLocX() {
        return locX;
    }

    public void setLocX(int X) {
        locX = X;
    }

    public static int getLocY() {
        return locY;
    }

    public void setLocY(int Y) {
        locY = Y;
    }

}