package org.example;
import java.util.Scanner;
public class UserInterface {
    private static int locX;
    private static int locY;
    private static Type type;
    private static int numberPassengers = 5;
    private static int category = 4;
    private static int rating = 6;

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

        while(category > 3 || category < 1) {
            System.out.println("Which type of vehicle do you require? Enter number");
            System.out.println("1. Regular");
            System.out.println("2. Premium");
            System.out.println("3. Wheelchair Accessible");
            category = scan.nextInt();
            switch (category) {
                case 1:
                    setType(Type.Regular);
                    break;
                case 2:
                    setType(Type.Premium);
                    break;
                case 3:
                    setType(Type.WheelchairAccesible);
            }
            if (category > 3 || category < 1) {
                System.out.println("Invalid input");
                System.out.println("Please try again");
            }
        }

        while (getNumberPassengers() > 4) {
            System.out.println("How many passengers will there be?");
            setNumberPassengers(scan.nextInt());
            if (getNumberPassengers() > 4) {
                System.out.println("The limit for each vehicle is 4 passengers, please try again");
            }
        }
        scan.close();
    }

    public static void endMessage() {
        Scanner scan = new Scanner(System.in);
        System.out.println("The fare for this ride was: ");
        System.out.println("Please give your driver a rating between 1 and 5");
        while (rating < 1 || rating > 5) {
            rating = scan.nextInt();
            if (rating < 1 || rating > 5) {
                System.out.println("Invalid input, please try again");
            }
        }
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
}
