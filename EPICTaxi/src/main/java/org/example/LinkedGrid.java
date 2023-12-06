package org.example;

public class LinkedGrid {
    private Node first;
    private int dimension;


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
    }


    private void markNodesAsEmpty(){
        Node rowMarker = first;

        for(int y = 0; y < dimension; y++){ //looping through the rows
            Node temp = rowMarker;
            for(int x = 0; x < dimension; x++){ //loop through the columns
                if(isSpaceEmpty(x, y)){
                    temp.setEmpty(true);
                }
                temp = temp.getRight();
            }
            rowMarker = rowMarker.getDown();

        }
    }

    private boolean isSpaceEmpty(int x, int y) {
        int[][] emptyNodes = {
                {2, 2},  // node 12 (x,y)
                {2, 3},  // node 22
                {9, 6},  // node 59
                {9, 7},  // node 69
                {1, 7},  // node 61
                {2, 7},  // node 62
                {3, 7}   // node 63

        };
        for (int[] node : emptyNodes) {
            if (x == node[0] - 1 && y == node[1] - 1) { //checks if x is first element -1, y is second element -1
                return true;
            }
        }
        return false;
    }

    private boolean isRiver( int x, int y) { //x = f, g =y
        int[][] river = {
                //nodes that i want to be a river , its one line across with two spaces for bridges
                {2, 4}, {3, 4}, {5, 4}, {6, 4}, {7, 4}, {9, 4},{10,4},{11, 4}

        };
        for (int[] node : river) {
            if (x == node[0] - 1 && y == node[1] - 1) {
                return true;
            }
        }

        return false;
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

                    if(isRiver(x, y)){
                        System.out.print("\u001B[34m ~ \u001B[0m"); // ANSI escape codes to make it blue
                    }else{
                        System.out.printf("%3d", temp.getData()); //spaces out all parts of grid so all nodes are aligned
                    }}
                temp = temp.getRight();

            }

            System.out.println();
            temp = rowMarker.getDown();
            rowMarker = temp;
        }
    }


}
