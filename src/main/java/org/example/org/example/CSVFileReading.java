package org.example;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.example.UserInterface.*;

public class CSVFileReading {
    static String csvPath = "D:\\EPICTaxi\\src\\TaxiFile.txt";
    static String tempCsvPath = "D:\\EPICTaxi\\src\\TempFile.txt";

    private static List<Taxi> Taxis = new ArrayList<>();

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


                        Taxis.add(new Taxi(type, reg, make, model, driverName, rating, noOfTrips));

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
        }
        System.out.println(Taxis.get(11).getDriverName());
    }
    public static void updateRating() {
        try (BufferedReader br = new BufferedReader(new FileReader(csvPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempCsvPath))) {
            String line = null;
            int currentLine = 0;
            DecimalFormat roundToThree = new DecimalFormat("#.###");
            double newRating = ((Person.getAssignedTaxi().getRating()* Person.getAssignedTaxi().getNoOfTrips()) +
                    Double.parseDouble(UserInterface.getRating()))/
                    (Person.getAssignedTaxi().getNoOfTrips() + 1);
            newRating = Double.parseDouble(roundToThree.format(newRating));

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                currentLine++;
                if (data[1].equals(Person.getAssignedTaxiReg())) {
                    line = line.replace(data[5], Double.toString(newRating));
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error with updating rating");
            //e.printStackTrace();
            //throw new RuntimeException(e);
        }
        File originalFile = new File(csvPath);
        File tempFile = new File(tempCsvPath);
        if (tempFile.renameTo(originalFile)) {
            System.out.println("Replacement success");
        } else {
            System.out.println("Error with replacement");
        }
    }




        public static List<Taxi> getTaxis () {
            return Taxis;
        }
    }

