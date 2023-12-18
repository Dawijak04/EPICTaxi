
package org.example;


import java.util.Random;

public class Taxi {
    private Type type;
    private String reg;
    private String make;
    private String model;
    private String driverName;
    private boolean available;

    private int originalX;
    private int originalY;
    private int pointX;
    private int pointY;
    private double rating;
    private int noOfTrips;

    public Taxi(Type type, String reg, String make, String model, String driverName, double rating, int noOfTrips) {
        this.type = type;
        this.reg = reg;
        this.make = make;
        this.model = model;
        this.driverName = driverName;
        this.available = available;
        this.pointX = pointX;
        this.pointY = pointY;
        this.rating = rating;
        this.noOfTrips = noOfTrips;
    }


    public static DataList<Taxi> randomTaxiGenerate( ) {

        DataList<Taxi> list = CSVFileReading.getTaxis();
        DataList<Taxi> generatedTaxis = new DataList<>();
        Random rand = new Random();

        for (int i = 0; i < list.size(); i++) {
            Taxi csvTaxi = list.get(i);

            int x, y;
            do {

                // Generate random coords
                 x = rand.nextInt(10);
                 y = rand.nextInt(10);
            }while(LinkedGrid.isRiver(x, y) || LinkedGrid.isSpaceEmpty(x, y) || LinkedGrid.isTaxiAtPosition(x, y, generatedTaxis));
            // Creating a new Taxi with the existing data and random generated coords
            Taxi generatedTaxi = new Taxi(
                    csvTaxi.getType(),
                    csvTaxi.getReg(),
                    csvTaxi.getMake(),
                    csvTaxi.getModel(),
                    csvTaxi.getDriverName(),
                    csvTaxi.getRating(),
                    csvTaxi.getNoOfTrips()
            );
            generatedTaxi.setPointX(x);
            generatedTaxi.setPointY(y);

            // Add the generated Taxi to the list
            generatedTaxis.add(generatedTaxi);

            System.out.println("Generated Taxi: Coordinates (" + x + ", " + y + "), Type: " + csvTaxi.getType() +
                    ", Reg: " + generatedTaxi.getReg() +
                    ", Make: " + generatedTaxi.getMake() +
                    ", Model: " + generatedTaxi.getModel() +
                    ", Driver Name: " + generatedTaxi.getDriverName() +
                    ", Rating: " + generatedTaxi.getRating() +
                    ", No. of Trips: " + generatedTaxi.getNoOfTrips());
        }


        return generatedTaxis;
        }



    private static boolean isSpaceOccupied(DataList<Taxi> taxis, int x, int y){
        for(int i = 0; i < taxis.size(); i++){
            Taxi taxi = taxis.get(i);
            if(taxi.getPointX() == x && taxi.getPointY() == y){
                return true;

            }
        }
        return false;
    }



    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getPointX() {
        return pointX;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNoOfTrips() {
        return noOfTrips;
    }

    public void setNoOfTrips(int noOfTrips) {
        this.noOfTrips = noOfTrips;
    }
    public int getOriginalX() {
        return originalX;
    }

    public void setOriginalX(int originalX) {
        this.originalX = originalX;
    }
    public int getOriginalY() {
        return originalX;
    }

    public void setOriginalY(int originalX) {
        this.originalX = originalX;
    }

}
