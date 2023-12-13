package main.java.org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {
    LinkedGrid lg = new LinkedGrid(10);
    private Node first = lg.getFirst();

    public DataList<Node> dijkstraShortestPath(Node start, Node end) {
        DataHashMap<Node, Double> distanceMap = new DataHashMap<>();
        DataHashMap<Node, Node> predecessorMap = new DataHashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(distanceMap::get));

        distanceMap.put(start, 0.0);
        priorityQueue.add(start);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            for (int i = 0; i < getNeighbors(current).size(); i++) {
                Node neighbor = getNeighbors(current).get(i);
                //for (Node neighbor : getNeighbors(current)) {
                double newDistance = distanceMap.get(current) + getDistance(current, neighbor);

                if (!distanceMap.containsKey(neighbor) || newDistance < distanceMap.get(neighbor)) {
                    distanceMap.put(neighbor, newDistance);
                    predecessorMap.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
                // }
            }
        }

        return buildPath(start, end, predecessorMap);
    }

    public DataList<Node> buildPath(Node start, Node end, DataHashMap<Node, Node> predecessorMap) {
        DataList<Node> path = new DataList();
        Node current = end;

        while (current != null) {
            path.add(current);
            current = predecessorMap.get(current);
        }

        path.reverse();

        return path;
    }

    public DataList<Node> getNeighbors(Node node) {
        DataList<Node> neighbors = new DataList();

        // Check if there is a node to the right and it is not empty and not a river
        if (node.getRight() != null && !node.getRight().isEmpty() && !isRiver(node.getRight())) {
            neighbors.add(node.getRight());
        }

        // Check if there is a node to the down and it is not empty and not a river
        if (node.getDown() != null && !node.getDown().isEmpty() && !isRiver(node.getDown())) {
            neighbors.add(node.getDown());
        }

        // Check if there is a node to the left and it is not empty and not a river
        if (node.getLeft() != null && !node.getLeft().isEmpty() && !isRiver(node.getLeft())) {
            neighbors.add(node.getLeft());
        }

        // Check if there is a node to the up and it is not empty and not a river
        if (node.getUp() != null && !node.getUp().isEmpty() && !isRiver(node.getUp())) {
            neighbors.add(node.getUp());
        }

        return neighbors;
    }

    public boolean isRiver(Node node) {
        int x = node.getData() % 10;
        int y = node.getData() / 10;

        return lg.isRiver(x, y);
    }

    public double getDistance(Node node1, Node node2) {

        return 1.0;
    }


    //  public Node getFirst() {
    //      return first;
    //  }

    public Node getNodeAt(int x, int y) {
        Node temp = first;
        for (int i = 0; i < y; i++) {
            temp = temp.getDown();
        }
        for (int i = 0; i < x; i++) {
            temp = temp.getRight();
        }
        return temp;
    }

}
