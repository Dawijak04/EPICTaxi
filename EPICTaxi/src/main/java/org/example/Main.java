package org.example;


import java.util.List;

public class Main {
    public static void main(String[] args) {

          CSVFileReading.readTaxiCSV();

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
       // LinkedGrid LG = new LinkedGrid(10);
        //LG.display();
        ////////////////////////////////////////////////////////////////////////////////////////////////
       // LinkedGrid linkedGrid = new LinkedGrid(10); // Adjust the dimension as needed
       // linkedGrid.display();

        // Assuming startNode and endNode are valid nodes within the grid
       // Node startNode = linkedGrid.getNodeAt(2,2);
      //  Node endNode = linkedGrid.getNodeAt(9, 5);

       // List<Node> shortestPath = linkedGrid.dijkstraShortestPath(startNode, endNode);


        //System.out.println("Shortest Path:");
       // for (Node node : shortestPath) {
       //     System.out.print(node.getData() + " ");
      //  }

        LinkedGrid lg = new LinkedGrid(10);
        lg.display();


    }
  //  public static int add(int a, int b){
     //   return a + b;
    //}

}