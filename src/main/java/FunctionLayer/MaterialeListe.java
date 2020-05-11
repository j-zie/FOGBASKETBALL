package FunctionLayer;

import DBAccess.MaterialeMapper;
import java.util.ArrayList;

public class MaterialeListe {

    private ArrayList<Materiale> matListe;

    public MaterialeListe() {
        this.matListe = MaterialeMapper.getAlleMaterialer();
    }

    public void debugPrint() {
        for (int i = 0; i < matListe.size(); i++) {
            System.out.println(matListe.get(i).getMaterialeNavn());
        }
    }

    public Materiale getMaterialeBytag(String tag) {
        for (int i = 0; i < matListe.size(); i++) {
            if (matListe.get(i).getTag().equals(tag)) {
                return matListe.get(i);
            }
        }
        return null;
    }

    public ArrayList<Materiale> getCarporte() {
        ArrayList<Materiale> retVal = matListe;
        retVal.removeIf(x -> !(x.getTag().equals("carport")));
        return retVal;
    }

    public ArrayList<Materiale> getKomponenter() {
        ArrayList<Materiale> retVal = matListe;
        retVal.removeIf(x -> (x.getTag().equals("carport")));
        return retVal;
    }


}
