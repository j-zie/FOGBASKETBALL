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
    public String canIShow() {
        return matListe.get(0).getMaterialeNavn();
    }

    public Materiale getMaterialeBytag(String tag) {
        for (int i = 0; i < matListe.size(); i++) {
            if (matListe.get(i).getTag().equals(tag)) {
                return matListe.get(i);
            }
        }
        return null;
    }

    public int getTotalPrice() {

    }


}
