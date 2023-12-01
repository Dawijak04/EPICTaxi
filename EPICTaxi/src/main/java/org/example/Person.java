package org.example;
import java.util.Random;
public class Person {
    private int locX;
    private int locY;

    public Person(){
        Random rand = new Random();
        this.locX = rand.nextInt(10);
        this.locY = rand.nextInt(10);
    }

    public int getLocX() {
        return locX;
    }

    public void setLocX(int locX) {
        this.locX = locX;
    }

    public int getLocY() {
        return locY;
    }

    public void setLocY(int locY) {
        this.locY = locY;
    }
}
