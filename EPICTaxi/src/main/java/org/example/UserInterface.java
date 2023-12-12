package org.example;
import java.util.Scanner;
public class UserInterface {
    private static int locX;
    private static int locY;
    private static Type type;
    private static int numberPassengers = 5;
    private static int category = 4;
    private static double rating = 6;

    public static void welcome(){
        System.out.println("Welcome to EcoTaxi");
        System.out.println("Every trip you take, will plant a tree to save the planet");
    }

    public static void routeInfo(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Where would you like to go? Please input co-ordinates");
        System.out.println("X:");
        setLocX(scan.nextInt());
        System.out.println("Y:");
        setLocY(scan.nextInt());

        while(Person.getCategory() > 3 || Person.getCategory() < 1) {
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
            if (Person.getCategory() > 3 || Person.getCategory() < 1) {
                System.out.println("Invalid input");
                System.out.println("Please try again");
            }
        }

        while (Person.getNumberPassengers() > 4) {
            System.out.println("How many passengers will there be?");
            Person.setNumberPassengers(scan.nextInt());
            if (Person.getNumberPassengers() > 4) {
                System.out.println("The limit for each vehicle is 4 passengers, please try again");
            }
        }
        //scan.close();
    }

    public static void endMessage() {
        Scanner scan = new Scanner(System.in);
        System.out.println("The fare for this ride was: ");
        System.out.println("Please give your driver a rating between 1 and 5");
        while (Person.getRating() < 1 || Person.getRating() > 5) {
            Person.setRating(scan.nextDouble());
            if (Person.getRating() < 1 || Person.getRating() > 5) {
                System.out.println("Invalid input, please try again");
            }
        }
        CSVFileReading.updateRating();
        System.out.println("Thank you for choosing EcoTaxi");
        scan.close();
    }

    public static int getLocX() {
        return locX;
    }

        public static void setLocX(int X) {
        locX = X;
    }

    public int getLocY() {
        return locY;
    }

    public static void setLocY(int Y) {
        locY = Y;
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
}
