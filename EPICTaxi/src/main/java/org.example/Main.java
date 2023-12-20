
package org.example;


public class Main {
    public static  LinkedGrid lg = new LinkedGrid(10); //set as attribute so that it can be accessed in other class

    public static void main(String[] args)  {

        UserInterface.welcome(); //welcome message

        lg.display(); //linked grid is displayed

        UserInterface.routeInfo(); //user inputs necessary info about trip
        GridStateMange gridStateManager = new GridStateMange(lg, lg.generatedTaxis ); //creates new linked grid with only desired type of taxis


        gridStateManager.narrowRangeAndDisplay(); //displays grid and asks user to choose a specific vehicle


        Node startNode = Dijkstra.getNodeAt(UserInterface.getAssignedTaxi().getPointX(), UserInterface.getAssignedTaxi().getPointY()); //sets start node as chosen taxis location
        Node endNode = Dijkstra.getNodeAt(Person.getLocX(), Person.getLocY()); //sets end node as users location


         DataList<Node> shortestPath = Dijkstra.dijkstraShortestPath(startNode, endNode); //stores shortest path in a list of nodes

        System.out.println(UserInterface.getAssignedTaxi().getDriverName() + " is on the way"); //informs user that driver is on the way

        for(int i = 0; i < shortestPath.size(); i++) { //iterates through each node of shortest path
            try {
                Thread.sleep(500); //pauses for 0.5 seconds
            }catch(InterruptedException e){
                System.out.println("error with pausing"); //exception handling in case of error
            }
           Node node = shortestPath.get(i); //takes current node
           int nodeX = node.getData() % 10; //gets x coordinate of node
           int nodeY = node.getData() / 10; //gets y coordinate of node
           UserInterface.getAssignedTaxi().setPointX(nodeX); //sets x coordinate as taxis location
           UserInterface.getAssignedTaxi().setPointY(nodeY); //sets y coordinate as taxis location

            gridStateManager.displayOnlySelectedTaxi(); //displays grid with only chosen taxi
            System.out.println(); //space between current grid and next grid

         }

        System.out.println("User picked up"); //user has been picked up

        try {
            Thread.sleep(500); //pauses for 0.5 seconds
        }catch(InterruptedException e){
            System.out.println("error with pausing");
        }
       startNode = Dijkstra.getNodeAt(UserInterface.getAssignedTaxi().getPointX(), UserInterface.getAssignedTaxi().getPointY()); //sets start node as chosen taxis current location (i.e. the user)
       endNode = Dijkstra.getNodeAt(UserInterface.getLocX(), UserInterface.getLocY()); //sets end node as the users destination
        shortestPath = Dijkstra.dijkstraShortestPath(startNode, endNode); //gets shortest path as a list of nodes
        for(int i = 0; i < shortestPath.size(); i++) { //iterates through the nodes

            try {
                Thread.sleep(500); //pause for 0.5 seconds
            }catch(InterruptedException e){
                System.out.println("error with pausing");
            }

            UserInterface.setFare(UserInterface.getFare() + 0.50); //adds 50c every time it iterates, charges 50c per node of distance
            Node node = shortestPath.get(i); //takes current node
            int nodeX = node.getData() % 10; //gets x coordinate of node
            int nodeY = node.getData() / 10; //gets y coordinate of node
            UserInterface.getAssignedTaxi().setPointX(nodeX); //assigns taxi coordinate x as new nodes x
            UserInterface.getAssignedTaxi().setPointY(nodeY); //assigns taxi coordinate y as new nodes y

           gridStateManager.displayOnlySelectedTaxiLessPerson(); //displays grid with only taxi and no person
            System.out.println(); //prints a break between each grid
        }
        UserInterface.endMessage(); //displays end message


    }




    public static int add(int a, int b) { //sample method, used to verify if CI works correctly
        return a + b;
    }

    public static LinkedGrid getLg() { //a getter for the linked grid to be accessed in other classes
        return lg;
    }
}