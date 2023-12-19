import org.example.*;
import org.junit.Test;

import static org.example.Type.Regular;
import static org.junit.Assert.assertEquals;
import java.io.*;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class Testing  implements VehicleHiringTest {



    @Test
    public void test1() {
        assertEquals((Main.add(1, 2)), 3);
    }


    @Test
    @Override
    public void testAddToMap() {
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


        assertTrue(outputStream.toString().contains(" \\uD83D\\uDE95"));





    }





    @Override
    public void testMoveVehicle() {

    }

    @Override
    public void testRemoveVehicle() {

    }

    @Override
    public void testGetVehicleLoc() {

    }

    @Override
    public void testGetVehiclesInRange() {

    }
}
