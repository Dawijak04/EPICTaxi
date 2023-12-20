import org.example.*;
import org.junit.Test;

import static org.example.Type.Premium;
import static org.example.Type.Regular;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.*;
import static org.junit.Assert.*;


public class Testing  implements VehicleHiringTest {



    @Test
    public void test1() {
        assertEquals((Main.add(1, 2)), 3);
    }


    @Test
    @Override
    public void testAddToMap() {
        //method that displays elements on the linked grid
        //method that displays elements on the linked grid
        LinkedGrid lg = new LinkedGrid(10);


        int taxix = 3;
        int taxiy = 4;

        Taxi mockTaxi = new Taxi(Regular,"151-C-935","Honda","Accord","John",4.123,196);
        mockTaxi.setPointX(taxix);
        mockTaxi.setPointY(taxiy);

        DataList<Taxi> generatedtaxis = new DataList<>();
        generatedtaxis.add(mockTaxi);

        lg.display();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        lg.display();
        String gridOutput = outputStream.toString();


        assertTrue(outputStream.toString().contains(" \uD83D\uDE95"));

    }





   @Test
   @Override
    public void testMoveVehicle() {
    LinkedGrid map = new LinkedGrid(10);
    map.display();
    GridStateMange manager = new GridStateMange(map, map.generatedTaxis);
    UserInterface.setAssignedTaxi(CSVFileReading.getTaxis().get(0));
    UserInterface.getAssignedTaxi().setPointX(0);
    UserInterface.getAssignedTaxi().setPointY(0);
    int initialX = UserInterface.getAssignedTaxi().getPointX();
    int initialY = UserInterface.getAssignedTaxi().getPointY();

    Node start = Dijkstra.getNodeAt(0, 0);
    Node end = Dijkstra.getNodeAt(9, 9);

    DataList<Node> route = Dijkstra.dijkstraShortestPath(start, end);

    for(int i = 0; i < route.size(); i++){
        Node node = route.get(i);
        UserInterface.getAssignedTaxi().setPointX(node.getData() % 10);
        UserInterface.getAssignedTaxi().setPointY(node.getData() / 10);
        manager.displayOnlySelectedTaxiLessPerson();
    }
    int finalX = UserInterface.getAssignedTaxi().getPointX();
    int finalY = UserInterface.getAssignedTaxi().getPointY();
    assertNotEquals(initialX, finalX);
    assertNotEquals(initialY, finalY);
    }

@Test
    @Override
    public void testRemoveVehicle() {
        // i want to test that when the taxi chooses a type, the other types dont appear on the grid
    LinkedGrid lg = new LinkedGrid(10);

    Taxi taxi1 = new Taxi(Regular,"134-432", "bmw","kite","jake", 4.3,3);
    Taxi taxi2 = new Taxi(Premium, "123-321", "citroen", "cw", "richard", 2.3, 43);

     DataList<Taxi>  generatedTaxis = new DataList<>();
    generatedTaxis.add(taxi1);
    generatedTaxis.add(taxi2);

    Taxi selectedTaxi = taxi1;
    UserInterface.setAssignedTaxi(selectedTaxi);

    GridStateMange gsm = new GridStateMange(lg, generatedTaxis);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    gsm.displayOnlySelectedTaxi();
    System.setOut(System.out);
    assertTrue(outputStream.toString().contains(" \uD83D\uDE95"));




    }
@Test
    @Override
    public void testGetVehicleLoc() {
        // testing to see if a certain taxi is on map
        LinkedGrid linkedGrid = new LinkedGrid(10);

        int taxix = 3;
        int taxiy = 4;

    Taxi mockTaxi = new Taxi(Regular, "151-C-935", "Honda", "Accord", "John", 4.123, 196);
    mockTaxi.setPointX(taxix);
    mockTaxi.setPointY(taxiy);

    DataList<Taxi> generatedtaxis = new DataList<>();
    generatedtaxis.add(mockTaxi);

    linkedGrid.display();
    String targetTaxiRegNumber = "151-C-935";
    int foundIndex = -1;
    for (int i = 0; i < generatedtaxis.size(); i++) {
        if (generatedtaxis.get(i).getReg().equals(targetTaxiRegNumber)) {
            foundIndex = i;
            break;
        }
    }

    if (foundIndex != -1) {
        Taxi foundTaxi = generatedtaxis.get(foundIndex);
        System.out.println("Taxi Registration Number: " + foundTaxi.getReg());
        System.out.println("Taxi Coordinates (X, Y): " + foundTaxi.getPointX() + ", " + foundTaxi.getPointY());
        assertTrue(foundTaxi.getPointX() == taxix && foundTaxi.getPointY() == taxiy);
    } else {
        System.out.println("Taxi not found with registration number: " + targetTaxiRegNumber);
    }
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    linkedGrid.display();
    String gridOutput = outputStream.toString();


}
@Test
    @Override
    public void testGetVehiclesInRange() {
    //narrowing range testing
    Person person = new Person(10);
    person.setLocX(0);
    person.setLocY(0);

    Taxi taxisInsideRange = new Taxi(Regular, "151-C-935", "Honda", "Accord", "John", 4.123, 196);
    taxisInsideRange.setPointX(3);
    taxisInsideRange.setPointY(4);


    DataList<Taxi> visibleTaxis = new DataList<>();
    visibleTaxis.add(taxisInsideRange);

    }
}
