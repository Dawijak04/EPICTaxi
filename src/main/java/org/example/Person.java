package org.example;
import java.util.Random;



public class Person {
    private int locX;
    private int locY;
    private static String assignedTaxiReg = "12-RN-831";
    private static Taxi assignedTaxi = CSVFileReading.getTaxis().get(3);

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
