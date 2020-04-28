package FunctionLayer;

import DBAccess.*;

import java.util.ArrayList;

public class OrdreListe {

    ArrayList<Ordre> ordre;

    public OrdreListe() {
        try {
            ordre = OrdreMapper.getAlleOrdre();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
     }

    public Ordre getOrderFromOrderNumber(int num) {
        for ( Ordre i : ordre) {
            if (i.getOrdreNr() == num) {
                return i;
            }
        }
        return null;
    }


}
