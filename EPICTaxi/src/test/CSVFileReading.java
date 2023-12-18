package org.example;

import java.io.*;
import java.text.DecimalFormat;

public class CSVFileReading {
    static String csvPath = "EPICTaxi//src//TaxiFile.txt";

    private static DataList<Taxi> taxiList = new DataList();


    public static void readTaxiCSV() {

        try (
                BufferedReader reader = new BufferedReader(new FileReader(csvPath))) { //buffered reader reads file at csvPath
            String line;


            while ((line = reader.readLine()) != null) { //while file isn't finsihed

                String[] data = line.split(","); //split csv line into a string array


                if (data.length >= 7) { // Ensure there are at least 7 columns



                    try {
                        Type type = Type.valueOf(data[0].trim()); //first value is assgined as Type
                        String reg = data[1].trim(); //second value is assigned as reg
                        String make = data[2].trim(); //third value is assigned as make
                        String model = data[3].trim(); //fourth value is assigned as model
                        String driverName = data[4].trim(); //fifth value is assigned as the drivers name
                        double rating = Double.parseDouble(data[5].trim()); //sixth value is assigned as drivers rating and parsed into a double
                        int noOfTrips = Integer.parseInt(data[6].trim()); //seventh value is assigned as the dirvers number of trip and parsed into an integer


                        taxiList.add(new Taxi(type, reg, make, model, driverName, rating, noOfTrips)); //a taxi obejct is created with the above attributes



                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing age");
                    }
                } else {
                    System.err.println("Invalid data format: " + line);
                }

            }
        } catch (
                IOException e) {
            System.out.println("File not found");


        }



        


    }

    public static void updateRating() {
        DataList<String> updatedLines = new DataList<>(); //creates new list

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            String line;

            DecimalFormat roundToThree = new DecimalFormat("#.###"); //decimal format for driver rating
            double newRating = ((Person.getAssignedTaxi().getRating() * Person.getAssignedTaxi().getNoOfTrips()) + //drivers current rating mulitplied by number of trips
                    Double.parseDouble((Double.toString(Person.getRating())))) / //plus drivers new rating
                    (Person.getAssignedTaxi().getNoOfTrips() + 1); //divided by drivers number of trips + 1
            newRating = Double.parseDouble(roundToThree.format(newRating)); //converts into appropriate decimal format

            while ((line = br.readLine()) != null) { //while file isnt finished
                String[] data = line.split(","); //split the current line into a string array
                if (data.length >= 7 && data[1].equals(Person.getAssignedTaxi().getReg())) { //if appropriate format and has reg of assigned taxi
                    data[5] = Double.toString(newRating); //set sixth value as the new rating
                    data[6] = String.valueOf(Person.getAssignedTaxi().getNoOfTrips() + 1); //set seventh value as new number of trips
                }
                    line = String.join(",", data); //join array back into one line

                updatedLines.add(line); //add line into updated lines
            }
        } catch (IOException e) {
            System.out.println("Error with updating rating");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvPath))) {
            for(int i = 0; i < updatedLines.size(); i++) { //goes through all elements of updatedLines list
                String updatedLine = updatedLines.get(i); //assigns current value to updatedLine
                bw.write(updatedLine); //writes current line
                bw.newLine(); //moves to next line
            }
            System.out.println("Rating updated successfully");
        } catch (IOException e) {
            System.out.println("Error writing updated data to the file");
        }
    }


    public static DataList<Taxi> getTaxis() {
        return taxiList;
    } //returns list of taxis
}


