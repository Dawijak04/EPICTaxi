package org.example;


public class Main {
    public static void main(String[] args) {
       // CSVFileReading.readTaxiCSV();


        //UserInterface.welcome();
        //UserInterface.routeInfo();

        //Taxi.randomTaxiGenerate(UserInterface.getType());
        //System.out.println(CSVFileReading.getTaxis().get(7).isAvailable());
        //System.out.println(CSVFileReading.getTaxis().get(7).getPointX());
        //System.out.println(CSVFileReading.getTaxis().get(7).getPointY());
        //System.out.println("break");
        //System.out.println(CSVFileReading.getTaxis().get(8).isAvailable());
        //System.out.println(CSVFileReading.getTaxis().get(8).getPointX());
        //System.out.println(CSVFileReading.getTaxis().get(8).getPointY());
        //System.out.println("break");
        //System.out.println(CSVFileReading.getTaxis().get(9).isAvailable());
        //System.out.println(CSVFileReading.getTaxis().get(9).getPointX());
        //System.out.println(CSVFileReading.getTaxis().get(9).getPointY());
       // UserInterface.endMessage();

        LinkedGrid lg = new LinkedGrid(10);
        lg.display();;

    }
    public static int add(int a, int b){
        return a + b;
    }

}
