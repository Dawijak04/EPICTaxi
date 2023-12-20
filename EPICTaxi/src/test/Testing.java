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


    @Override
    public void testAddToMap() {
        
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
