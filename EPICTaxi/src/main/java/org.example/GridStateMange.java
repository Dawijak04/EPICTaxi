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
    // Method to display the grid with the person and taxis based on the selected type
    public DataList<Taxi> displayGridWithPersonAndTaxis() {// List to store visible taxis based on the selected type
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

    private Taxi getTaxiAtPosition(int x, int y) { // Method to get the taxi at a specific position in the grid
        for (int i = 0; i < generatedTaxis.size(); i++) {
            Taxi taxi = generatedTaxis.get(i);
            if (taxi.getPointX() == x && taxi.getPointY() == y) {
                return taxi;
            }
        }
        return null;
    }

    private boolean isTaxiInGeneratedTaxis(Taxi taxiToCheck) {// Method to check if a taxi is in the generated taxis list
        for (int i = 0; i < generatedTaxis.size(); i++) {
            Taxi taxi = generatedTaxis.get(i);
            if (taxi.equals(taxiToCheck)) {
                return true;
            }
        }
        return false;
    }
    public void narrowRangeAndDisplay() {// Method to narrow the range of taxis and display the grid with person and taxis
        narrowingRange.narrowRange(generatedTaxis, linkedGrid.getPerson(), 5);
        DataList<Taxi> visibleTaxis = displayGridWithPersonAndTaxis();
        if (!visibleTaxis.isEmpty()) {
            // Displaying information about visible taxis and allowing the user to select one
            for (int i = 0; i < visibleTaxis.size(); i++) {
                Taxi taxi = visibleTaxis.get(i);
                System.out.println("Taxi " + i + ": " +" Driver " + taxi.getDriverName() + " in the " + taxi.getMake());
            }
            Scanner scanner = new Scanner(System.in);
            int selectedTaxiIndex;
            // Prompting the user to select a taxi until a valid index is entered
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

            for (int i = 0; i < visibleTaxis.size(); i++) {// Marking the selected taxi as visible
                Taxi taxi = visibleTaxis.get(i);
                taxi.setVisible(i == selectedTaxiIndex);
            }
            // Displaying the grid with the person and the selected taxi
            displayGridWithPersonAndSelectedTaxi(visibleTaxis.get(selectedTaxiIndex));
            // Setting the selected taxi in the user interface
            UserInterface.setAssignedTaxi((visibleTaxis.get(selectedTaxiIndex)));
        } else {
            System.out.println("No taxis available in the narrowed range.");
        }
    }
    private void displayGridWithPersonAndSelectedTaxi(Taxi selectedTaxi) {// Method to display the grid with the person and the selected taxi
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