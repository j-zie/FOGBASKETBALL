package FunctionLayer;

import DBAccess.MaterialeMapper;
import com.google.protobuf.ByteString;

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
}
