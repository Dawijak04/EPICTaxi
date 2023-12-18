package org.example;



import java.util.Comparator;

public class Dijkstra {
    private LinkedGrid lg = new LinkedGrid(10);
    private Node first = lg.getFirst();

    public DataList<Node> dijkstraShortestPath(Node start, Node end) {
        DataHashMap<Node, Double> distanceMap = new DataHashMap<>(); //creates hash map
        DataHashMap<Node, Node> predecessorMap = new DataHashMap<>(); //creates hash map
        DataPriorityQueue<Node> priorityQueue = new DataPriorityQueue<>(Comparator.comparingDouble(distanceMap::get)); //creates priority queue

        distanceMap.put(start, 0.0); //sets start as distance of 0
        priorityQueue.add(start); //adds start to priorityQueue

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll(); //find node with smallet distance in priorityQueue
            for (int i = 0; i < getNeighbors(current).size(); i++) { //look through all neighbouring nodes
                Node neighbor = getNeighbors(current).get(i); //assigns current node to neighbour variable

                double newDistance = distanceMap.get(current) + getDistance(current, neighbor); //adds new distance (between current node and neighbour) to existing distance

                if (!distanceMap.containsKey(neighbor) || newDistance < distanceMap.get(neighbor)) { //if distance for neighbour was already recorded and new distance is less than previous distance
                    distanceMap.put(neighbor, newDistance); //set new distance of neighbour
                    predecessorMap.put(neighbor, current); //registers what previous node it was at
                    priorityQueue.add(neighbor); //adds neighbour to priorityQueue
                }

            }
        }

        return buildPath(start, end, predecessorMap); //returns shortest path as a list
    }

    public DataList<Node> buildPath(Node start, Node end, DataHashMap<Node, Node> predecessorMap) {
        DataList<Node> shortestPath = new DataList(); //new list is created
        Node current = end; //current node is set to end

        while (current != null) { //while current isn't null
            shortestPath.add(current); //add current to the list
            current = predecessorMap.get(current); //assign current as the node previous to the current node
        }

        shortestPath.reverse(); //reverse the list

        return shortestPath; //return the list
    }

    public DataList<Node> getNeighbors(Node node) {
        DataList<Node> neighbors = new DataList(); //create new list

        // Check if there is a node to the right and its not empty and not a river
        if (node.getRight() != null && !node.getRight().isEmpty() && !isRiver(node.getRight())) {
            neighbors.add(node.getRight());
        }

        // Check if there is a node to the down and its not empty and not a river
        if (node.getDown() != null && !node.getDown().isEmpty() && !isRiver(node.getDown())) {
            neighbors.add(node.getDown());
        }

        // Check if there is a node to the left and its not empty and not a river
        if (node.getLeft() != null && !node.getLeft().isEmpty() && !isRiver(node.getLeft())) {
            neighbors.add(node.getLeft());
        }

        // Check if there is a node to the up and its not empty and not a river
        if (node.getUp() != null && !node.getUp().isEmpty() && !isRiver(node.getUp())) {
            neighbors.add(node.getUp());
        }

        return neighbors; //return list of neighbouring nodes
    }

    public boolean isRiver(Node node) { //checks if node is a river
        int x = node.getData() % 10; //gets x coordinate
        int y = node.getData() / 10; //gets y coordinate

        return lg.isRiver(x, y); //runs isRiver method from LinkedGrid
    }

    public double getDistance(Node node1, Node node2) {
        //returns distance of 1.0 between any 2 nodes
        return 1.0;
    }




    public Node getNodeAt(int x, int y) { //gets node at a given coordinate
        Node temp = first; //starts at the beginning
        for (int i = 0; i < y; i++) { //moves along y-axis for y amount of times
            temp = temp.getDown();
        }
        for (int i = 0; i < x; i++) {
            temp = temp.getRight(); //moves along x-axis for x amount of times
        }
        return temp; //returns desired node
    }

}
