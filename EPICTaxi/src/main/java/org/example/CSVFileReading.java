package main.java.org.example;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReading {
    //static String csvPath = "/Users/alisiakazimierek/MyRepos/EPICTaxi/EPICTaxi/src/TaxiFile.txt";
    static String csvPath = "EPICTaxi//src//TaxiFile.txt";
    static String tempCsvPath = "D:\\EPICTaxi\\src\\TempFile.txt";

    //private static List<Taxi> Taxis = new ArrayList<>();
    private static DataList<Taxi> taxiList = new DataList();

    public static void readTaxiCSV() {

        try (
                BufferedReader reader = new BufferedReader(new FileReader(csvPath))) {
            String line;


            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 7) { // Ensure there are at least 5 columns


                    try {
                        Type type = Type.valueOf(data[0].trim());
                        String reg = data[1].trim();
                        String make = data[2].trim();
                        String model = data[3].trim();
                        String driverName = data[4].trim();
                        double rating = Double.parseDouble(data[5].trim());
                        int noOfTrips = Integer.parseInt(data[6].trim());

                        //System.out.println(make);


                        taxiList.add(new Taxi(type, reg, make, model, driverName, rating, noOfTrips));
                        //System.out.println(type + reg + make + model + driverName + rating + noOfTrips);

                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing age: " + e.getMessage());
                        // handle the error or decide how to proceed
                    }
                } else {
                    System.err.println("Invalid data format: " + line);
                    // handle the error or decide how to proceed
                }

            }
        } catch (
                IOException e) {
            //e.printStackTrace();
            System.out.println("File not found");
           // System.out.println(taxiList.get(11).getDriverName());
        }

        System.out.println(taxiList.get(11).getDriverName());

    }

    public static void updateRating() {
        DataList<String> updatedLines = new DataList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String line;

            DecimalFormat roundToThree = new DecimalFormat("#.###");
            double newRating = ((Person.getAssignedTaxi().getRating() * Person.getAssignedTaxi().getNoOfTrips()) +
                    Double.parseDouble((Double.toString(Person.getRating())))) /
                    (Person.getAssignedTaxi().getNoOfTrips() + 1);
            newRating = Double.parseDouble(roundToThree.format(newRating));

            while ((line = br.readLine()) != null) {
               // line = br.readLine();
               // System.out.println(line);
                String[] data = line.split(",");
                if (data.length >= 7 && data[1].equals(Person.getAssignedTaxi().getReg())) {
                    data[5] = Double.toString(newRating);
                    data[6] = String.valueOf(Person.getAssignedTaxi().getNoOfTrips() + 1);
                }
                    line = String.join(",", data);

                updatedLines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error with updating rating");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvPath))) {
            for(int i = 0; i < updatedLines.size(); i++) {
                //System.out.println("for loop" + i);
                String updatedLine = updatedLines.get(i);
                bw.write(updatedLine);
                bw.newLine();
            }
            System.out.println("Rating updated successfully");
        } catch (IOException e) {
            System.out.println("Error writing updated data to the file");
        }
    }


    public static DataList<Taxi> getTaxis() {
        return taxiList;
    }
}

