package org.example;
import java.util.Random;



public class Person {
    private int locX;
    private int locY;

   private static Taxi assignedTaxi = CSVFileReading.getTaxis().get(16);
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

   public static String getAssignedTaxiReg() {return assignedTaxiReg;}

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
