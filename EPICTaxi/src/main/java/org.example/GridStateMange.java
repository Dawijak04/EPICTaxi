package org.example;
import java.util.Scanner;
public class GridStateMange {

    private LinkedGrid linkedGrid;
    private DataList<Taxi> generatedTaxis;
    private NarrowingRange narrowingRange;

    public GridStateMange(LinkedGrid linkedGrid, DataList<Taxi> generatedTaxis) {
        this.linkedGrid = linkedGrid;
        this.generatedTaxis = generatedTaxis;
        this.narrowingRange = new NarrowingRange();
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
    public DataList<Taxi> displayGridWithPersonAndTaxis() {
        Person person = linkedGrid.getPerson();
        Type selectedType = Person.getType();

        DataList<Taxi> visibleTaxis = new DataList<>();
        for (int y = 0; y < linkedGrid.getSize(); y++) {
            for (int x = 0; x < linkedGrid.getSize(); x++) {


                Taxi originalTaxi = getTaxiAtPosition(x , y);

                if (originalTaxi != null && isTaxiInGeneratedTaxis(originalTaxi) && originalTaxi.getType() == selectedType) {
                    System.out.print(" \uD83D\uDE95");  // Taxi emoji
                    visibleTaxis.add(originalTaxi);
                } else if (linkedGrid.isSpaceEmpty(x, y)) {
                    System.out.print("\u001B[32m - \u001B[0m");  // Empty space
                } else if (x == person.getLocX() && y == person.getLocY()) {
                    System.out.print("\uD83E\uDDCD");  // Person emoji
                } else  if(linkedGrid.isRiver(x, y)){
                    System.out.print("\u001B[34m ~ \u001B[0m");
                }else {
                    System.out.printf("%3d",linkedGrid.getData(x, y)); //spaces out all parts of grid so all nodes are aligned
                }
            }
            System.out.println();
        }
        System.out.println("Displayed taxis for selected type: " + selectedType);
        return visibleTaxis;
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
    public void narrowRangeAndDisplay() {
        DataList<Taxi> visibleTaxis = displayGridWithPersonAndTaxis();
        if (!visibleTaxis.isEmpty()) {
            System.out.println("No taxis available in the narrowed range.");
            for (int i = 0; i < visibleTaxis.size(); i++) {
                Taxi taxi = visibleTaxis.get(i);
                System.out.println("Taxi " + i + ": " +" Driver " + taxi.getDriverName() + " in the " + taxi.getMake());
            }
            Scanner scanner = new Scanner(System.in);
            int selectedTaxiIndex;

            do{
                System.out.print("Select a taxi (enter the taxi number): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
                selectedTaxiIndex = scanner.nextInt();

                if (selectedTaxiIndex < 0 || selectedTaxiIndex >= visibleTaxis.size()) {
                    System.out.println("Invalid taxi number. Please choose a valid taxi.");
                }
            } while (selectedTaxiIndex < 0 || selectedTaxiIndex >= visibleTaxis.size());

            for (int i = 0; i < visibleTaxis.size(); i++) {
                Taxi taxi = visibleTaxis.get(i);
                taxi.setVisible(i == selectedTaxiIndex);
            }

            displayGridWithPersonAndSelectedTaxi(visibleTaxis.get(selectedTaxiIndex));
            UserInterface.setAssignedTaxi((visibleTaxis.get(selectedTaxiIndex)));//////////////////////test
        } else {
            System.out.println("No taxis available in the narrowed range.");
        }
    }
    private void displayGridWithPersonAndSelectedTaxi(Taxi selectedTaxi) {
        //Person person = linkedGrid.getPerson();///////////////////////////////////
        Type selectedType = Person.getType();

        for (int y = 0; y < linkedGrid.getSize(); y++) {
            for (int x = 0; x < linkedGrid.getSize(); x++) {
                Taxi originalTaxi = getTaxiAtPosition(x, y);

                if (originalTaxi != null && originalTaxi.isVisible()) {
                    System.out.print(" \uD83D\uDE95");  // Taxi emoji
                } else if (linkedGrid.isSpaceEmpty(x, y)) {
                    System.out.print("\u001B[32m - \u001B[0m");  // Empty space
                } else if (x == Person.getLocX() && y == Person.getLocY()) {////////////////////////////
                    System.out.print("\uD83E\uDDCD");  // Person emoji
                } else if (x == selectedTaxi.getPointX() && y == selectedTaxi.getPointY()) {
                    System.out.print(" \uD83D\uDE95");  // Selected taxi emoji
                } else if (linkedGrid.isRiver(x, y)) {
                    System.out.print("\u001B[34m ~ \u001B[0m");
                } else {
                    System.out.printf("%3d", linkedGrid.getData(x, y));
                }
            }
            System.out.println();
        }
        System.out.println("Displayed taxis for selected type: " + selectedType);
    }

    public void displayOnlySelectedTaxi() {
        //Person person = linkedGrid.getPerson();
        for (int y = 0; y < linkedGrid.getSize(); y++) {
            for (int x = 0; x < linkedGrid.getSize(); x++) {
                Taxi originalTaxi = getTaxiAtPosition(x, y);
                Taxi selectedTaxi = UserInterface.getAssignedTaxi();

                if (linkedGrid.isSpaceEmpty(x, y)) {
                    System.out.print("\u001B[32m - \u001B[0m");  // Empty space
                } else if (x == Person.getLocX() && y == Person.getLocY()) {
                    System.out.print("\uD83E\uDDCD");  // Person emoji
                } else if (x == selectedTaxi.getPointX() && y == selectedTaxi.getPointY()) {
                    System.out.print(" \uD83D\uDE95");  // Selected taxi emoji
                } else if (linkedGrid.isRiver(x, y)) {
                    System.out.print("\u001B[34m ~ \u001B[0m");
                } else {
                    System.out.printf("%3d", linkedGrid.getData(x, y));
                }
            }
            System.out.println();
        }

    }
    public void displayOnlySelectedTaxiLessPerson() {
        //Person person = linkedGrid.getPerson();
        for (int y = 0; y < linkedGrid.getSize(); y++) {
            for (int x = 0; x < linkedGrid.getSize(); x++) {
                Taxi originalTaxi = getTaxiAtPosition(x, y);
                Taxi selectedTaxi = UserInterface.getAssignedTaxi();

                if (linkedGrid.isSpaceEmpty(x, y)) {
                    System.out.print("\u001B[32m - \u001B[0m");  // Empty space
                } else if (x == selectedTaxi.getPointX() && y == selectedTaxi.getPointY()) {
                    System.out.print(" \uD83D\uDE95");  // Selected taxi emoji
                } else if (linkedGrid.isRiver(x, y)) {
                    System.out.print("\u001B[34m ~ \u001B[0m");
                } else {
                    System.out.printf("%3d", linkedGrid.getData(x, y));
                }
            }
            System.out.println();
        }

    }


}