package FunctionLayer;


import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class MaterialeListeTest {


    MaterialeListe materialeListe = new MaterialeListe();


    @Test
    public void getMaterialeBytag() {
        // Virker kun hvis de pågældene materiale er i DB'en
       Materiale m = materialeListe.getMaterialeBytag("carport"); // HVORFOR I AL VERDEN LIGGER SPÆR UNDER TAG? haha

        assertTrue(m != null);

    }

    @Test
    public void getCarporte() {
        // Virker kun der er en carport i DB'en
        Materiale m = materialeListe.getMaterialeBytag("carport");
        assertTrue(m != null);
    }
}
