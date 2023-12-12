package org.example;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVFileReading.readTaxiCSV();

        UserInterface.welcome();
        UserInterface.routeInfo();

        Taxi.randomTaxiGenerate(Person.getType());

        System.out.println("Type: " + Person.getAssignedTaxi().getType());
        System.out.println("Make: " + Person.getAssignedTaxi().getMake());
        System.out.println("Model: " + Person.getAssignedTaxi().getModel());
        System.out.println("Driver name: " + Person.getAssignedTaxi().getDriverName());
        System.out.println("Availability: " + Person.getAssignedTaxi().isAvailable());

        UserInterface.endMessage();



        LinkedGrid linkedGrid = new LinkedGrid(10); // Adjust the dimension as needed
        linkedGrid.display();


        Dijkstra dijkstra = new Dijkstra();

        Node startNode = dijkstra.getNodeAt(0, 2);
        Node endNode = dijkstra.getNodeAt(0, 9);

        DataList<Node> shortestPath = dijkstra.dijkstraShortestPath(startNode, endNode);
        System.out.println("Shortest Path:");
        for(int i = 0; i < shortestPath.size(); i++) {
            Node node = shortestPath.get(i);
            System.out.print(node.getData() + " ");
        }






    }
    public static int add(int a, int b){
        return a + b;
    }


}