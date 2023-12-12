package main.java.org.example;

public class LocationNode {
    int x, y;
    String location;
    int distance;
    boolean visited;
    LocationNode previous;
    public LocationNode(String location, int x, int y) {
    this.location = location;
    this.x = x;
    this.y = y;
    this.distance = Integer.MAX_VALUE;
    this.visited = false;
    this.previous = null;
    }
}
