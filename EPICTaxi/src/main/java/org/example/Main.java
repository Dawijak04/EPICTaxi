package main.java.org.example;

public class Main {

    public static void main(String[] args) {
        CSVFileReading.readTaxiCSV();

        UserInterface.welcome();
        UserInterface.routeInfo();

        //Taxi.randomTaxiGenerate(Person.getType());


        //LinkedGrid linkedGrid = new LinkedGrid(10); // Adjust the dimension as needed
        //linkedGrid.display();


        //Dijkstra dijkstra = new Dijkstra();


        //Node startNode = dijkstra.getNodeAt(LinkedGrid.getPerson().getLocX(), LinkedGrid.getPerson().getLocY());

        //Node endNode = dijkstra.getNodeAt(9, 9);



       // DataList<Node> shortestPath = dijkstra.dijkstraShortestPath(startNode, endNode);
        //System.out.println("Shortest Path:");
       // for (int i = 0; i < shortestPath.size(); i++) {
        //    Node node = shortestPath.get(i);
        //    System.out.print(node.getData() + " ");
        //}

        UserInterface.endMessage();


    }




    public static int add(int a, int b) {
        return a + b;
    }


}