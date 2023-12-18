
package org.example;




public class Main {
    public static void main(String[] args) {

          CSVFileReading.readTaxiCSV();



         UserInterface.welcome();
        LinkedGrid lg = new LinkedGrid(10);
        lg.display();
        UserInterface.routeInfo();
        GridStateMange gridStateManager = new GridStateMange(lg , lg.generatedTaxis);
        gridStateManager.saveOriginalPositions();

        gridStateManager.displayGridWithPersonAndTaxis();





        // System.out.println("Type: " + Person.getAssignedTaxi().getType());
      // System.out.println("Make: " + Person.getAssignedTaxi().getMake());
       // System.out.println("Model: " + Person.getAssignedTaxi().getModel());
       // System.out.println("Driver name: " + Person.getAssignedTaxi().getDriverName());
      //  System.out.println("Availability: " + Person.getAssignedTaxi().isAvailable());



       // UserInterface.endMessage();



        //Dijkstra dijkstra = new Dijkstra();


        //Node startNode = dijkstra.getNodeAt(LinkedGrid.getPerson().getLocX(), LinkedGrid.getPerson().getLocY());

        //Node endNode = dijkstra.getNodeAt(9, 9);




      //  System.out.println();
      //  Dijkstra dijkstra = new Dijkstra();

       // Node startNode = dijkstra.getNodeAt(0, 2);
      //  Node endNode = dijkstra.getNodeAt(0, 9);

      //  DataList<Node> shortestPath = dijkstra.dijkstraShortestPath(startNode, endNode);
       // System.out.println("Shortest Path:");
        //for(int i = 0; i < shortestPath.size(); i++) {
        //    Node node = shortestPath.get(i);
         //   System.out.print(node.getData() + " ");
       // }


        UserInterface.endMessage();


    }




    public static int add(int a, int b) {
        return a + b;
    }


}