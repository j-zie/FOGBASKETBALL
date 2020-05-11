package FunctionLayer;


import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class KurvItemsTest {


    /**
     * Denne metode tester at hvis man henter listen før der er blevet tilføjet noget så retunere den null.
     */
    @Test
    public void getListNegativTest(){
        ArrayList<KurvItems> liste = KurvItems.getItemList();
        assertEquals(null, liste);
    }



    /**
     * Denne metode tester om der faktisk bliver tilføjet noget til Kurvlisten.
     */
    @Test
    public void addItems() {
        KurvItems.addItems("Carport...","imagePath/image","20.00");
        ArrayList<KurvItems> liste = KurvItems.getItemList();
        int size = liste.size();
        KurvItems.addItems("Carport2...","imagePath/image2","20.00");
        ArrayList<KurvItems> liste2 = KurvItems.getItemList();
        assertTrue(size < liste2.size());
    }

    /**
     * Denne metode tester om der faktisk bliver fjernet noget til Kurvlisten.
     */
    @Test
    public void removeItem() {
        ArrayList<KurvItems> liste = KurvItems.getItemList();
        int size1 = liste.size();
        KurvItems.removeItem("imagePath/image2");
        int size2 = KurvItems.getItemList().size();
        assertTrue(size1 >size2);


    }


    /**
     * Denne metode tester om listen bliver estancieret hvis man tilføjer noget til den.
     */
    @Test
    public void getListPostiveTest(){
        KurvItems.addItems("Carport2...","imagePath/image2","20.00");
        ArrayList<KurvItems> liste = KurvItems.getItemList();
      assertNotEquals(null, liste);
    }
}
