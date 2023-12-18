package org.example;

public class GridStateMange {

    private LinkedGrid linkedGrid;
    private DataList<Taxi> generatedTaxis;

    public GridStateMange(LinkedGrid linkedGrid, DataList<Taxi> generatedTaxis) {
        this.linkedGrid = linkedGrid;
        this.generatedTaxis = generatedTaxis;
    }
    public void saveOriginalPositions() {

        for (int i = 0; i < generatedTaxis.size(); i++) {
            Taxi taxi = generatedTaxis.get(i);
            taxi.setOriginalX(taxi.getPointX());
            taxi.setOriginalY(taxi.getPointY());
        }

        Person person = linkedGrid.getPerson();
        person.setOriginalX(person.getLocX());
        person.setOriginalY(person.getLocY());
    }

    public void restorePersonLocation() {
        Person person = linkedGrid.getPerson();
        person.setLocX(person.getOriginalX());
        person.setLocY(person.getOriginalY());
    }
    public void displayGridWithPersonAndTaxis() {
        Person person = linkedGrid.getPerson();
        Type selectedType = person.getType();

        for (int y = 0; y < linkedGrid.getSize(); y++) {
            for (int x = 0; x < linkedGrid.getSize(); x++) {
                Taxi originalTaxi = getTaxiAtPosition(x , y);

                if (originalTaxi != null && isTaxiInGeneratedTaxis(originalTaxi )&& originalTaxi.getType() == selectedType) {
                    System.out.print(" \uD83D\uDE95");  // Taxi emoji
                } else if (linkedGrid.isSpaceEmpty(x, y)) {
                    System.out.print("\u001B[32m - \u001B[0m");  // Empty space
                } else if (x == person.getLocX() && y == person.getLocY()) {
                    System.out.print("\uD83E\uDDCD");  // Person emoji
                } else  if(linkedGrid.isRiver(x, y)){
                    System.out.print("\u001B[34m ~ \u001B[0m");
                }else{
                    System.out.printf("%3d",linkedGrid.getData(x, y)); //spaces out all parts of grid so all nodes are aligned
                }
            }
            System.out.println();
        }
    }

    private Taxi getTaxiAtPosition(int x, int y) {
        for (int i = 0; i < generatedTaxis.size(); i++) {
            Taxi taxi = generatedTaxis.get(i);
            if (taxi.getPointX() == x && taxi.getPointY() == y) {
                return taxi;
            }
        }
        return null;
    }

    private boolean isTaxiInGeneratedTaxis(Taxi taxiToCheck) {
        for (int i = 0; i < generatedTaxis.size(); i++) {
            Taxi taxi = generatedTaxis.get(i);
            if (taxi.equals(taxiToCheck)) {
                return true;
            }
        }
        return false;
    }


}






