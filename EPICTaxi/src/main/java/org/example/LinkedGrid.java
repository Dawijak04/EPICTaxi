package main.java.org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LinkedGrid {
    private Node first;
    private int dimension;
    private Person person;


    public LinkedGrid(int dimension) { //gotta give the grid a size

        if (dimension > 0) {

            this.dimension = dimension;
            int counter = 1;

            //creating the first node
            first = new Node(counter++);
            Node columnMarker = first;
            Node rowMarker = first;

            //creating the rest of the row
            for (int x = 0; x < dimension - 1; x++) {
                //linking the node horizontally
                columnMarker.setRight(new Node(counter++));
                columnMarker.getRight().setLeft(columnMarker);
                columnMarker = columnMarker.getRight();
            }

            for (int x = 0; x < dimension - 1; x++) { // looping it to keep making new rows with 8 nodes in each
                //creating the first node in a row
                rowMarker.setDown(new Node(counter++));
                rowMarker.getDown().setUp(rowMarker); // these line and the one above are connecting the top grid box to the one under it

                rowMarker = rowMarker.getDown();
                columnMarker = rowMarker;

                //creating the rest of the row
                for (int y = 0; y < dimension - 1; y++) {
                    //linking nodes horizontally
                    columnMarker.setRight(new Node(counter++));
                    columnMarker.getRight().setLeft(columnMarker);

                    //linking nodes vertically
                    columnMarker.getRight().setUp(columnMarker.getUp().getRight()); //name of second node is columnMarker.getUp().getRight()
                    columnMarker.getRight().getUp().setDown(columnMarker.getRight());

                    columnMarker = columnMarker.getRight();
                }

            }
        }
        markNodesAsEmpty();


        //intialising the person with random coordiantes
        this.person = new Person(10);
        int personX = this.person.getLocX();
        int personY = this.person.getLocY();

        getNodeAt(personX, personY).setEmpty(false);

    }

    public static boolean isSpaceEmpty(int x, int y) {
        int[][] emptyNodes = {
                {2, 2},  // node 12 (x,y)
                {2, 3}, {9, 6}, {9, 7}, {1, 7}, {2, 7}, {3, 7}, {1, 9}, {2, 9}, {3, 9}, {5, 9}, {6, 9}, {7, 9},
                {9, 9}, {8, 6}, {8, 7}, {5, 6}, {5, 7}, {6, 6}, {6, 7}, {4, 2}, {5, 2}, {6, 2}, {7, 2}, {8, 2}, {9, 2}


        };
        for (int[] node : emptyNodes) {
            if (x == node[0] - 1 && y == node[1] - 1) { //checks if x is first element -1, y is second element -1
                return true;
            }
        }
        return false;
    }

    public static boolean isRiver(int x, int y) { //x = f, g =y
        int[][] river = {
                //nodes that i want to be a river , its one line across with two spaces for bridges
                {2, 4}, {3, 4}, {5, 4}, {6, 4}, {7, 4}, {9, 4}, {10, 4}, {11, 4},
                {2, 5}, {3, 5}, {5, 5}, {6, 5}, {7, 5}, {9, 5}, {10, 5}, {11, 5}


        };
        for (int[] node : river) {
            if (x == node[0] - 1 && y == node[1] - 1) {
                return true;
            }
        }

        return false;
    }

    private Node getNodeAt(int x, int y) {
        Node temp = first;
        for (int i = 0; i < y; i++) {
            temp = temp.getDown();
        }
        for (int i = 0; i < x; i++) {
            temp = temp.getRight();
        }
        return temp;
    }

    private void markNodesAsEmpty() {
        Node rowMarker = first;

        for (int y = 0; y < dimension; y++) { //looping through the rows
            Node temp = rowMarker;
            for (int x = 0; x < dimension; x++) { //loop through the columns
                if (isSpaceEmpty(x, y)) {
                    temp.setEmpty(true);
                }
                temp = temp.getRight();
            }
            rowMarker = rowMarker.getDown();

        }
    }

    public void display() { //method to display the linked grid

        Node temp = first;
        Node rowMarker = first;

        while (rowMarker != null) { //loop through rows
            while (temp != null) { // loop through columns
                if (temp.isEmpty()) {
                    System.out.print("\u001B[32m - \u001B[0m"); //ANSI escape code for green
                } else {
                    int x = temp.getData() % dimension;
                    int y = temp.getData() / dimension;

                    if (isRiver(x, y)) {
                        System.out.print("\u001B[34m ~ \u001B[0m"); // ANSI escape codes to make it blue
                    } else if (x == person.getLocX() && y == person.getLocY()) {
                        System.out.print("\uD83E\uDDCD"); // unicode for a peron emoji
                    } else {
                        System.out.printf("%3d", temp.getData()); //spaces out all parts of grid so all nodes are aligned
                    }
                }
                temp = temp.getRight();

            }

            System.out.println();
            temp = rowMarker.getDown();
            rowMarker = temp;
        }
    }


    public List<Node> dijkstraShortestPath(Node start, Node end) {
        Map<Node, Double> distanceMap = new HashMap<>();
        Map<Node, Node> predecessorMap = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distanceMap::get));

        distanceMap.put(start, 0.0);
        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            for (Node neighbor : getNeighbors(current)) {
                double newDistance = distanceMap.get(current) + getDistance(current, neighbor);

                if (!distanceMap.containsKey(neighbor) || newDistance < distanceMap.get(neighbor)) {
                    distanceMap.put(neighbor, newDistance);
                    predecessorMap.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
            }
        }

        return buildPath(start, end, predecessorMap);
    }

    private List<Node> buildPath(Node start, Node end, Map<Node, Node> predecessorMap) {
        List<Node> path = new ArrayList<>();
        Node current = end;

        while (current != null) {
            path.add(current);
            current = predecessorMap.get(current);
        }

        Collections.reverse(path);

        return path;
    }

    private List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<>();

        if (node.getRight() != null && !node.getRight().isEmpty()) {
            neighbors.add(node.getRight());
        }
        if (node.getDown() != null && !node.getDown().isEmpty()) {
            neighbors.add(node.getDown());
        }

        return neighbors;
    }

    private double getDistance(Node node1, Node node2) {
        return 1.0;
    }


    public Node getFirst() {
        return first;
    }


}



