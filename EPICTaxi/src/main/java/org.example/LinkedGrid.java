
package org.example;


public class LinkedGrid {
    private Node first; //this is the first node in the grid
    private int dimension; //size of the grid

    private Person person;
    public DataList<Type> addedTaxiTypes;
    public DataList<Taxi>generatedTaxis;

    private Type type;
    private Node[][] nodes;

    public LinkedGrid(int dimension) { //gotta give the grid a size
        CSVFileReading.readTaxiCSV(); //reads taxis from the csv file

        if (dimension > 0) { //checks if size is greater than 0
            this.dimension = dimension;
            int counter = 0;

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
        markNodesAsEmpty(); //marking nodes as empty



        //intialising the person with random coordiantes
        this.person = new Person(10);
        int personX = Person.getLocX();
        int personY = Person.getLocY();
        getNodeAt(personX, personY).setEmpty(false);

//creating random taxis and adding them tto the grid
        this.generatedTaxis = Taxi.randomTaxiGenerate();
        addTaxisToGrid(generatedTaxis);
        this.addedTaxiTypes = new DataList<>();


    }




    public static boolean isSpaceEmpty(int x, int y) { //this makes the empty nodes
        int[][] emptyNodes = {
                {2, 2},  // node 12 (x,y)
                {2, 3}, {9, 6}, {9, 7}, {1, 7}, {2, 7}, {3, 7}, {1, 9}, {2, 9}, {3, 9}, {5, 9}, {6, 9}, {7, 9},
                {9, 9}, {8, 6}, {8, 7}, {5, 6}, {5, 7}, {6, 6}, {6, 7}, {4, 2}, {5, 2}, {6, 2}, {7, 2}, {8, 2}, {9, 2}


        };
        for (int[] node : emptyNodes) { //checks if the given co ords match any other predefined empty nodes
            if (x == node[0] - 1 && y == node[1] - 1) { //checks if x is first element -1, y is second element -1
                return true;
            }
        }
        return false;
    }

    public static boolean isRiver(int x, int y) { //makes a river
        int[][] river = {
                //nodes that i want to be a river , its one line across with two spaces for bridges
                {2, 4}, {3, 4}, {5, 4}, {6, 4}, {7, 4}, {9, 4}, {10, 4}, {11, 4},
                {2, 5}, {3, 5}, {5, 5}, {6, 5}, {7, 5}, {9, 5}, {10, 5}, {11, 5}


        };
        for (int[] node : river) { // Checking if the given coordinates match any predefined river nodes
            if (x == node[0] - 1 && y == node[1] - 1) {
                return true;
            }
        }

        return false;
    }

    public Node getNodeAt(int x, int y) { //method to get the node at given co ords in the grid
        Node temp = first;
        for (int i = 0; i < y; i++) {
            temp = temp.getDown();
        }
        for (int i = 0; i < x; i++) {
            temp = temp.getRight();
        }
        return temp;
    }

    private void markNodesAsEmpty() { // Method to mark nodes as empty based on predefined conditions
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
                if (!temp.isEmpty()) {
                    int x = temp.getData() % dimension;
                    int y = temp.getData() / dimension;
                    // In display method



                    Taxi taxiAtPosition = getTaxiAtPosition(x, y, generatedTaxis);

                    if(taxiAtPosition != null ){
                        System.out.print(" \uD83D\uDE95"); //taxi emoji
                        // printTaxiEmoji(taxiAtPosition);
                    }
                    else if(isRiver(x, y)) {

                        System.out.print("\u001B[34m ~ \u001B[0m"); // ANSI escape codes to make it blue
                    } else if (x == Person.getLocX() && y == Person.getLocY()) {//////////////////////////////////
                        System.out.print("\uD83E\uDDCD"); // unicode for a peron emoji
                    } else {
                        System.out.printf("%3d", temp.getData()); //spaces out all parts of grid so all nodes are aligned
                    }


                } else{
                    System.out.print("\u001B[32m - \u001B[0m");

                }
                temp = temp.getRight();

            }

            System.out.println();
            temp = rowMarker.getDown();
            rowMarker = temp;


        }
    }


    public Taxi getTaxiAtPosition(int x, int y, DataList<Taxi> generatedTaxis){ // Method to get the taxi at a specific position in the grid
        for(int i = 0; i < generatedTaxis.size(); i++){
            Taxi taxi = generatedTaxis.get(i);
            if(taxi.getPointX() == x && taxi.getPointY() == y){
                return taxi;
            }
        }
        return null;
    }





    public Node getFirst() {
        return first;
    }

    // Method to check if there is a taxi at a specific position in the grid
    public static boolean isTaxiAtPosition( int x, int y, DataList<Taxi> generatedTaxis){
        for(int i = 0; i < generatedTaxis.size(); i ++){
            Taxi taxi =generatedTaxis.get(i);
            if (taxi.getPointX() == x && taxi.getPointY() == y){
                return true;
            }
        }
        return false;
    }






    public void addTaxisToGrid( DataList<Taxi> generatedTaxis ) {
        for (int i = 0; i < generatedTaxis.size(); i++) {
            Taxi taxi = generatedTaxis.get(i);
            int x = taxi.getPointX();
            int y = taxi.getPointY();
            Node node = getNodeAt(x, y);


            // Checking if the space is empty and not occupied by another taxi
            if (node != null && node.isEmpty() && !isTaxiAtPosition( x, y, generatedTaxis)) {
                node.setEmpty(false);

                addedTaxiTypes.add(taxi.getType());
            }
        }
    }
    public Person getPerson() {
        return person;
    }

    public int getSize(){
        return dimension;
    }
    public int getData(int x, int y) {
        Node node = getNodeAt(x, y);
        if (node != null) {
            return node.getData();
        } else {
            // Handles the case where the node is null
            return-1 ;
        }}



}


