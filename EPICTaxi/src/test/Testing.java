import org.example.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class Testing  implements VehicleHiringTest {



    @Test
    public void test1() {
        assertEquals((Main.add(1, 2)), 3);
    }
    @Test
    public boolean testAddToMap(String reg, int x , int y){
        DataList<Taxi> generatedTaxis = Taxi.randomTaxiGenerate();
        String registration = "151-C-935";

        for(int i =0; i < generatedTaxis.size(); i++){
            if(generatedTaxis.get(i).getReg().equals(registration)){
                return true;
            }
        }
        return false;
    }

    @Test
    @Override
    public void testAddToMap() {
        //method that displays elements on the linked grid
     LinkedGrid lg = new LinkedGrid(10);
     lg.display();

     int taxix = 3;
     int taxiy = 4;
     DataList<Taxi> generatedtaxis;
    // lg.getTaxiAtPosition(taxix, taxiy, generatedtaxis);








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
