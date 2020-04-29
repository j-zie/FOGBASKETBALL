package FunctionLayer;

import DBAccess.*;

import java.util.ArrayList;

/**
 *
 *  Metoden OrdreListe henter alle Ordre ud af et ArrayList af samme navn
 * @param ArrayList<Ordre> ordre;
 */




public class OrdreListe {

    ArrayList<Ordre> ordre;

    public OrdreListe() {
        try {
            ordre = OrdreMapper.getAlleOrdre();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
     }

    /**
     *
     *  Metoden getOrderFromOrderNumber benytter et foreach loop på ArrayListen ordre til at finde en bestemt ordre
     *  efter et specifikt nummer.
     */

    public Ordre getOrderFromOrderNumber(int num) {
        for ( Ordre i : ordre) {
            if (i.getOrdreNr() == num) {
                return i;
            }
        }
        return null;
    }


}
