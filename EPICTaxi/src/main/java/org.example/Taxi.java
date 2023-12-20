
package org.example;

import java.util.Random;

public class Taxi {
    private  Type type;
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
    private boolean isVisible;
    public Taxi(Type type, String reg, String make, String model, String driverName, double rating, int noOfTrips) { //construcotr of taxi
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


    public static DataList<Taxi> randomTaxiGenerate( ) { //randomly assigns coordinates to available taxis

        DataList<Taxi> list = CSVFileReading.getTaxis(); //list of all taxis
        DataList<Taxi> generatedTaxis = new DataList<>(); //new list
        Random rand = new Random(); //random

        for (int i = 0; i < list.size(); i++) { //iterates through all the taxis
            Taxi csvTaxi = list.get(i); //takes current

            int x, y; //coordinates
            do {

                // Generate random coords
                x = rand.nextInt(10);
                y = rand.nextInt(10);
            }while(LinkedGrid.isRiver(x, y) || LinkedGrid.isSpaceEmpty(x, y) || LinkedGrid.isTaxiAtPosition(x, y, generatedTaxis) || ((Person.getLocX() == x) && (Person.getLocY() == y)) );//doesnt generate taxis where theres grass, water or a person
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
            generatedTaxi.setPointX(x); //sets x coordinate
            generatedTaxi.setPointY(y); //sets y coordinate

            // Add the generated Taxi to the list
            generatedTaxis.add(generatedTaxi);

        }
        return generatedTaxis; //return list of generated taxis
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
    public boolean isVisible(){
        return isVisible;
    }
    public void setVisible(boolean visible){
        isVisible = visible;
    }

}