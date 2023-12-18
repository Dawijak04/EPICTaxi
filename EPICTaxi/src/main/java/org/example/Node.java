package org.example;


public class Node {
    private Taxi taxi;
    private boolean originalEmpty;
    private Taxi originalTaxi;
    private int x;
    private int y;
    private int data;
    private Node up, down, left, right;
    private boolean isEmpty;


    Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getUp() {
        return up;
    }

    public void setUp(Node up) {
        this.up = up;
    }

    public Node getDown() {
        return down;
    }

    public void setDown(Node down) {
        this.down = down;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int setX(int x) {
        this.x = x;
        return x;
    }

    public int setY(int y) {
        this.y = y;
        return y;
    }

    public void setOriginalEmpty(boolean originalEmpty) {
        this.originalEmpty = originalEmpty;
    }

    public boolean getOriginalEmpty() {
        return originalEmpty;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setOriginalTaxi(Taxi originalTaxi) {
        this.originalTaxi = originalTaxi;
    }

    public Taxi getOriginalTaxi() {
        return originalTaxi;
    }

}