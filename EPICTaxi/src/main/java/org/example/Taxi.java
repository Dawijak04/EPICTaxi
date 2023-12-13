package main.java.org.example;

import java.util.List;
import java.util.Random;

public class Taxi {
    private Type type;
    private String reg;
    private String make;
    private String model;
    private String driverName;
    private boolean available;
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

    public static void randomTaxiGenerate(Type type) {
        //CSVFileReading.readTaxiCSV();
        DataList<Taxi> list = CSVFileReading.getTaxis();
        //DataList<T> list = (DataList<T>) CSVFileReading.getTaxis(type);
        Random rand = new Random();
        for (int i = 0; i < list.size(); i++) {
            //for(Taxi car : list) {
            Taxi car = list.get(i);
            car.setPointX(rand.nextInt(10));
            car.setPointY(rand.nextInt(10));
            if (car.getType().equals(type)) {
                car.setAvailable(rand.nextBoolean());
                car.setAvailable(true);
            } else {
                car.setAvailable(false);
            }
            //}
        }
    }


    public Type getType() {
        return type;
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
}
