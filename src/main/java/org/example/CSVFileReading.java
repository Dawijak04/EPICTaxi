package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReading {
    static String csvPath = "D:\\EPICTaxi\\src\\TaxiFile.txt";

    private static List<Taxi> Taxis = new ArrayList<>();

    public static void readTaxiCSV() {

        try (
                BufferedReader reader = new BufferedReader(new FileReader(csvPath))) {
            String line;


            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length >= 5) { // Ensure there are at least 5 columns


                    try {
                        Type type = Type.valueOf(data[0].trim());
                        String reg = data[1].trim();
                        String make = data[2].trim();
                        String model = data[3].trim();
                        String driverName = data[4].trim();

                        //System.out.println(make);


                        Taxis.add(new Taxi(type, reg, make, model, driverName));

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

    public static List<Taxi> getTaxis() {
        return Taxis;
    }
}
