
package org.example;


public class Main {
    public static  LinkedGrid lg = new LinkedGrid(10);
    public static void main(String[] args)  {

        UserInterface.welcome();
        lg.display();

        UserInterface.routeInfo();
        GridStateMange gridStateManager = new GridStateMange(lg, lg.generatedTaxis );

        gridStateManager.narrowRangeAndDisplay();



        Node startNode = Dijkstra.getNodeAt(UserInterface.getAssignedTaxi().getPointX(), UserInterface.getAssignedTaxi().getPointY());
        Node endNode = Dijkstra.getNodeAt(Person.getLocX(), Person.getLocY());

         DataList<Node> shortestPath = Dijkstra.dijkstraShortestPath(startNode, endNode);

        System.out.println(UserInterface.getAssignedTaxi().getDriverName() + " is on the way");

        for(int i = 0; i < shortestPath.size(); i++) {
            try {
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println("error with pausing");
            }
           Node node = shortestPath.get(i);
           int nodeX = node.getData() % 10;
           int nodeY = node.getData() / 10;
           UserInterface.getAssignedTaxi().setPointX(nodeX);
           UserInterface.getAssignedTaxi().setPointY(nodeY);

            gridStateManager.displayOnlySelectedTaxi();
            System.out.println();



         }
        System.out.println("User picked up");
        try {
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println("error with pausing");
        }
       startNode = Dijkstra.getNodeAt(UserInterface.getAssignedTaxi().getPointX(), UserInterface.getAssignedTaxi().getPointY());
       endNode = Dijkstra.getNodeAt(UserInterface.getLocX(), UserInterface.getLocY());
        shortestPath = Dijkstra.dijkstraShortestPath(startNode, endNode);
        for(int i = 0; i < shortestPath.size(); i++) {

            try {
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println("error with pausing");
            }

            UserInterface.setFare(UserInterface.getFare() + 0.50);
            Node node = shortestPath.get(i);
            int nodeX = node.getData() % 10;
            int nodeY = node.getData() / 10;
            UserInterface.getAssignedTaxi().setPointX(nodeX);
            UserInterface.getAssignedTaxi().setPointY(nodeY);

           gridStateManager.displayOnlySelectedTaxiLessPerson();
            System.out.println();
        }
        UserInterface.endMessage();


    }




    public static int add(int a, int b) {
        return a + b;
    }

    public static LinkedGrid getLg() {
        return lg;
    }
}