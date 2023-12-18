
package org.example;
import java.util.Random;
import java.util.Scanner;


import java.util.Random;


public class Person {
    private static Type type;
    private static int numberPassengers = 5;
    private static int category = 4;
    private static double rating = 6;




   private static Taxi assignedTaxi ;
    private static String assignedTaxiReg;

    private int originalX;


    private int originalY;


    private int locX;

    private int locY;

    public Person(int gridDimension) {
        Random rand = new Random();

        do {
            this.locX = rand.nextInt(gridDimension);
            this.locY = rand.nextInt(gridDimension);

        }while(LinkedGrid.isRiver(locX, locY) || LinkedGrid.isSpaceEmpty(locX, locY));


    }

    public static String getAssignedTaxiReg() {
        return assignedTaxiReg;
    }

    public static void setAssignedTaxiReg(String reg) {
        assignedTaxiReg = reg;
    }

    public static Taxi getAssignedTaxi() {
        return assignedTaxi;
    }

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



    public int getOriginalX() {
        return originalX;
    }

    public void setOriginalX(int originalX) {
        this.originalX = originalX;
    }
    public int getOriginalY() {
        return originalY;
    }

    public void setOriginalY(int originalY) {
        this.originalY = originalY;
    }



    public  int getLocX() {
        return locX;
    }

    public void setLocX(int X) {
        locX = X;
    }

    public  int getLocY() {
        return locY;
    }

    public void setLocY(int Y) {
        locY = Y;
    }

}
