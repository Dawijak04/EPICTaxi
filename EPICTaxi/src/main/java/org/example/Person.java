
package org.example;


import java.util.Random;
import java.util.Scanner;


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


    public static void setAssignedTaxiByType(DataList<Taxi> taxilist, Type type){
        DataList<Taxi> availableTaxis = getTaxisByType(taxilist, type);

        if(availableTaxis.isEmpty()){
            System.out.println("no avaiable taxis of your choosen type");
            return;
        }
        int userChooses = displayAvailableTaxis(availableTaxis);

        if(userChooses < 0 || userChooses>= availableTaxis.size()){
            System.out.println("Invalid choice. Please choose a valid taxi");
            return;
        }

        // Set the chosen taxi as the assigned taxi
        assignedTaxi = availableTaxis. get(userChooses);
        assignedTaxiReg = assignedTaxi.getReg();
        }







    private static DataList<Taxi> getTaxisByType(DataList<Taxi> taxilist, Type type){
        DataList<Taxi> availableTaxis = new DataList<>();
        for(int i = 0; i < taxilist.size(); i++){
            Taxi taxi = taxilist.get(i);
            if(taxi.getType() == type){
                availableTaxis.add(taxi);
            }
        }
return availableTaxis;

    }


private static int displayAvailableTaxis(DataList<Taxi> availableTaxis){
Scanner scanner = new Scanner(System.in);
    System.out.println("The available taxis are: ");
    for(int i = 0; i< availableTaxis.size(); i++){
        System.out.println(i + ". " + availableTaxis.get(i).getReg());

    }
    System.out.println("Choose a taxi by entering its number: ");
    int choice = scanner.nextInt();;
    return choice;
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
