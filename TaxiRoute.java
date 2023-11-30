package org.example;


import java.util.*;

public class TaxiRoute {

    List<LocationNode> locations;

    public TaxiRoute() {
        this.locations = new ArrayList<>();
    }

    public void addLocation(String location, int x, int y) {
        LocationNode newNode = new LocationNode(location, x, y);
        locations.add(newNode);
    }

    public void displayRoute(){
        for (LocationNode node : locations) {
            System.out.println(node.location + " (" + node.x + "," + node.y + ")");
        }
    }

    public LocationNode findShortestPath(LocationNode start, LocationNode end) {
        start.distance = 0;
       PriorityQueue<LocationNode> priorityQueue= new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        priorityQueue.add(start);
        while(!priorityQueue.isEmpty()){
            LocationNode current = priorityQueue.poll();
            current.visited = true;

            for(LocationNode neighbor : locations){
                if(!neighbor.visited){
                    int newDistance = current.distance + calculateDistance(current, neighbor);
                    if(newDistance < neighbor.distance){
                        neighbor.distance = newDistance;
                        neighbor.previous = current;
                        priorityQueue.add(neighbor);
                    }
                }
            }
        }
        //System.out.println(priorityQueue);
        return end;
    }

    private int calculateDistance(LocationNode node1, LocationNode node2){
        return Math.abs(node1.x - node2.x) + Math.abs(node1.y - node2.y);
    }
}

/////////////////////////////////////////////////////////////////////
//public static void main(String[] args) {
    //CSVFileReading.readTaxiCSV();

    //TaxiRoute route = new TaxiRoute();
    //route.addLocation("Loc A", 0, 0);
    //route.addLocation("Loc B", 1, 0);
    //route.addLocation("Loc C", 2, 0);
    //route.addLocation("Loc D", 2, 1);
    //route.addLocation("Loc E", 2, 2);
    //route.addLocation("Loc F", 1, 1);
    //route.addLocation("Loc G", 1, 2);
    ////route.displayRoute();
    //LocationNode start = route.findShortestPath(route.locations.get(0), route.locations.get(6));
    //System.out.println("Shortest path from A to G:");
    //printShortestPath(start);
    //route.findShortestPath(route.locations.get(0), route.locations.get(6));
//}
    //private static void printShortestPath(LocationNode end) {
        //if (end == null) {
            //System.out.println("No path found");
            //return;
        //}
        //List<String> path = new ArrayList<>();
        //while(end != null){
            //path.add(end.location);
            //end = end.previous;
        //}
        //Collections.reverse(path);
        //System.out.println("Shortest path: " + String.join(" -> ", path));
    //}
