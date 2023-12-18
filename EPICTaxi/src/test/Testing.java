
//import org.junit.Test;

import org.example.Main;
import org.junit.Test;
import static org.junit.Assert.assertEquals;




public class Testing  {
    @Test
    public void test1() {
        assertEquals((Main.add(1, 2)), 3);
    }
}
