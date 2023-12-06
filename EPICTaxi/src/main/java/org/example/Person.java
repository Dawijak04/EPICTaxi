package org.example;
import java.util.Random;



public class Person {
    private int locX;
    private int locY;

    private static Taxi assignedTaxi = CSVFileReading.getTaxis().get(15);
    private static String assignedTaxiReg = assignedTaxi.getReg();

    public Person(){
        Random rand = new Random();
        this.locX = rand.nextInt(10);
        this.locY = rand.nextInt(10);
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
}
