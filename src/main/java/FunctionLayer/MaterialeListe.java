package FunctionLayer;

import DBAccess.MaterialeMapper;
import java.util.ArrayList;

public class MaterialeListe {

    /**
     * Denne klasse bruges til at hente alle materialer og carporte ned.
     * Klassens contructer benytter @MaterialeMapper metoden getAlleMaterialer som henter alle materialer ned fra DB'en
     */

    private ArrayList<Materiale> matListe;

    public MaterialeListe() {
        this.matListe = MaterialeMapper.getAlleMaterialer();
    }


    /**
     * En simple debug metode brugt til at løse et problem
     */
    public void debugPrint() {
        for (int i = 0; i < matListe.size(); i++) {
            System.out.println(matListe.get(i).getMaterialeNavn());
        }
    }

    /**
     *  Denne metode retunere et enkelt Materiale object via et String parameter
     * @param tag Bruges til at indetificere og finde det matriale man vil have i DB'en
     * @return returnere endten et Materiale object eller null hvis parameret angivet ikke findes i DB'en
     */
    public Materiale getMaterialeBytag(String tag) {
        for (int i = 0; i < matListe.size(); i++) {
            if (matListe.get(i).getTag().equals(tag)) {
                return matListe.get(i);
            }
        }
        return null;
    }
    /**
     *  Denne metode retunere et enkelt Materiale object via et String parameter
     * @param navn Bruges til at indetificere og finde det matriale man vil have i listen
     * @return returnere endten et Materiale object eller null hvis parameret angivet ikke findes i DB'en
     */
    public Materiale getMaterialeByNavn(String navn) {
        for (int i = 0; i < matListe.size(); i++) {
            if (matListe.get(i).getMaterialeNavn().equals(navn)) {
                return matListe.get(i);
            }
        }
        return null;
    }
    public ArrayList<Materiale> getMatListe() {
        return matListe;
    }

    /**
     *  Denne metode henter alle carport ved at fjerne alle Materialer fra listen hvor tag ikke er lig med carport.
     */
    public ArrayList<Materiale> getCarporte() {
        ArrayList<Materiale> retVal = matListe;
        retVal.removeIf(x -> !(x.getTag().equals("carport")));
        return retVal;
    }
    /**
     *  Denne metode henter alle carport ved at fjerne alle Materialer fra listen hvor tag ikke er lig med carport.
     */
    public ArrayList<Materiale> getKomponenter() {
        ArrayList<Materiale> retVal = matListe;
        retVal.removeIf(x -> (x.getTag().equals("carport")));
        return retVal;
    }



}
