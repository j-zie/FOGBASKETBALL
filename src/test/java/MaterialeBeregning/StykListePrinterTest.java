package MaterialeBeregning;


import FunctionLayer.Carport;
import FunctionLayer.Ordre;
import FunctionLayer.OrdreListe;
import FunctionLayer.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class StykListePrinterTest {


    Ordre ordre;
    StringBuilder textToScreen = new StringBuilder();
    MængdeBeregner mængder;

    @Before
    public void arrange() {
        User kunde = new User("test", "test", "test", "test", "test", "test", 2, "test");
        Carport carport = new Carport(300.0, 300.0, 1, 0.0, 0, 0);
        ordre = new Ordre(carport, kunde);
        mængder = new MængdeBeregner(ordre);
    }


    @Test
    public void printEverything() {
        StykListePrinter s = new StykListePrinter(1);
        assertTrue(s.printEverything() != null);
        }

}
