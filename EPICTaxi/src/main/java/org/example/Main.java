package main.java.org.example;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        //System.out.println("THANK GOD!!!");
        CSVFileReading.readTaxiCSV();

        // CSVFileReading.readTaxiCSV();


       // UserInterface.welcome();
        //UserInterface.routeInfo();

       // Taxi.randomTaxiGenerate(Person.getType());

        System.out.println("Type: " + Person.getAssignedTaxi().getType());
        System.out.println("Make: " + Person.getAssignedTaxi().getMake());
        System.out.println("Model: " + Person.getAssignedTaxi().getModel());
        System.out.println("Driver name: " + Person.getAssignedTaxi().getDriverName());
        System.out.println("Availability: " + Person.getAssignedTaxi().isAvailable());


        UserInterface.endMessage();
        //CSVFileReading.updateRating();

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



        LinkedGrid linkedGrid = new LinkedGrid(10); // Adjust the dimension as needed
        linkedGrid.display();

        System.out.println();
        Dijkstra dijkstra = new Dijkstra();

        Node startNode = dijkstra.getNodeAt(0, 2);
        Node endNode = dijkstra.getNodeAt(9, 9);

        DataList<Node> shortestPath = dijkstra.dijkstraShortestPath(startNode, endNode);
        System.out.println("Shortest Path:");
        for (int i = 0; i < shortestPath.size(); i++) {
            Node node = shortestPath.get(i);
            System.out.print(node.getData() + " ");
        }


        //LinkedGrid lg = new LinkedGrid(10);
        //lg.display();


    }




    public static int add(int a, int b) {
        return a + b;
    }



}