package FunctionLayer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class OrdreListeTest {

    OrdreListe ordreListe = new OrdreListe();


    @Test
    public void getOrderFromOrderNumber() {
        // Virker kun hvis der er nogle ordre i DB'en
        Ordre ordre = ordreListe.getOrderFromOrderNumber(1);
        assertNotEquals(null, ordre);
    }

    @Test
    public void getSize() {
        // Virker kun hvis der er nogle ordre i DB'en
      int size = ordreListe.getSize();
      assertTrue(size > 0);

    }
}
