package org.example;

import java.util.Scanner;

public class UserInterface {

    private static int locX;//users x coordinate
    private static int locY;//users y coodrinate
    private static Type type;//users desired type of taxi
    private static int numberPassengers = 5;//number of passengers
    private static int category = 4;
    private static double rating = 6;//users rating of taxi driver
    private static Taxi assignedTaxi;
    private static DataList<Taxi> generatedTaxis;
    private static double Fare;

    public static void welcome(){
        System.out.println("Welcome to PlanetTaxi");

        System.out.println("Every trip you take, will plant a tree to save the planet");
    }

    public static void routeInfo() { //gathers all necessary info about the trip

        Scanner scan = new Scanner(System.in);
        System.out.println("Where would you like to go? Please input co-ordinates");
        System.out.println("X:");
        setLocX(scan.nextInt());
        System.out.println("Y:");
        setLocY(scan.nextInt());

        while (Person.getCategory() > 3 || Person.getCategory() < 1) { //checks for invalid inputs
            System.out.println("Which type of vehicle do you require? Enter number");
            System.out.println("1. Regular");
            System.out.println("2. Premium");
            System.out.println("3. Wheelchair Accessible");
            Person.setCategory(scan.nextInt());
            switch (Person.getCategory()) {
                case 1:
                    Person.setType(Type.Regular);
                    break;
                case 2:
                    Person.setType(Type.Premium);
                    break;
                case 3:
                    Person.setType(Type.WheelchairAccesible);
            }
            if (Person.getCategory() > 3 || Person.getCategory() < 1) { //informs user of invalid inputs
                System.out.println("Invalid input");
                System.out.println("Please try again");

            }
        }

        while (Person.getNumberPassengers() > 4 || Person.getNumberPassengers() < 1) { //checks for invalid inputs
            System.out.println("How many passengers will there be?");
            Person.setNumberPassengers(scan.nextInt());
            if (Person.getNumberPassengers() > 4) { //informs user of invalid inputs
                System.out.println("The limit for each vehicle is 4 passengers, please try again");
            }
        }

        //scan.close();
        //  LinkedGrid lg = new LinkedGrid(10);


        // LinkedGrid.display();
        //Person.setAssignedTaxiByType(CSVFileReading.getTaxis(), Person.getType());
        //LinkedGrid.setShowSelectedTypeOnly(true);


        //scan.close();


    }

    public static void endMessage() { //message displayed at end of trip
        Scanner scan = new Scanner(System.in);
        double totalFare = Fare + 0.25;
        if (UserInterface.getAssignedTaxi().getType().equals(Type.Premium)) {
            totalFare = totalFare*2;

        }
        System.out.println("The fare for this ride was: $" + Fare);
        System.out.println("Please give your driver a rating between 1 and 5");
        while (Person.getRating() < 1 || Person.getRating() > 5) {
            Person.setRating(scan.nextDouble());
            if (Person.getRating() < 1 || Person.getRating() > 5) {
                System.out.println("Invalid input, please try again");
            }
        }
        CSVFileReading.updateRating(); //update the drivers rating
        System.out.println("Thank you for choosing Planet Taxi");
        scan.close();
    }

    public static int getLocX() {
        return locX;
    }

    public static void setLocX(int X) {
        locX = X;
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

    public static String getRating() {
        return String.valueOf(rating);
    }

    public static void setRating(int rating) {
        UserInterface.rating = rating;
    }

    public static int getLocY() {
        return locY;
    }

    public static void setLocY(int Y) {
        locY = Y;
    }

    public static Taxi getAssignedTaxi() {
        return assignedTaxi;
    }

    public static void setAssignedTaxi(Taxi assignedTaxi) {
        UserInterface.assignedTaxi = assignedTaxi;
    }

    public static double getFare() {
        return Fare;
    }

    public static void setFare(double fare) {
        Fare = fare;
    }
}