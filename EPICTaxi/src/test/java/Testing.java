import junit.framework.TestCase;
import org.junit.Test;

import static org.example.Main.add;

public class Testing extends TestCase{
    @Test
    public void test1() {
        assertEquals((add(1, 2)), 3);
    }
}
