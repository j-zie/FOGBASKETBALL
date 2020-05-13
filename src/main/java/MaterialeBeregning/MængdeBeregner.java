package MaterialeBeregning;

import DBAccess.MaterialeMapper;
import DBAccess.StykListeMapper;
import FunctionLayer.Materiale;
import FunctionLayer.MaterialeListe;
import FunctionLayer.Ordre;

import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * MængdeBeregner klassen indeholder det fornødne logik, til at regne mængder af materialer ud fra en ordre
 *
 */



public class MængdeBeregner {
    Ordre ordre;
    double height;
    double width;
    double angle;
    int tagStenID;
    int ordreID;

    public MængdeBeregner(Ordre ordre) {
        width = ordre.getcarport().getCarportBredde();
        height = ordre.getcarport().getCarportLængde();
        angle = ordre.getcarport().getHældning();
        tagStenID = ordre.getcarport().getTagtypeID();
        ordreID = ordre.getOrdreNr();
        this.ordre = ordre;
    }


    
    public int antalStolper(){
        //Til denne metode kræves der længde fra databasen.

        int userinput = (int) height;
        int AfstandprBjælke = 180;
        //int N = 180; Udhæng skal det være der eller ej?
        int minimumsøjler = 2;
        int minimumLængdefor4søjler = userinput-360;
        int AntalB = (minimumLængdefor4søjler/*-N*/)/AfstandprBjælke;
        int ExtraB = (AntalB+1);
        int Resultat = (minimumsøjler+ExtraB*2);

        return Resultat;
    }
    public int antalSpaer(){
        int userinput = (int) height;
        int AfstandPrSpær = 56;
        int Resultat = (userinput/AfstandPrSpær);

        return Resultat;
    }

    public double antalTagsten(){
        double bredde = height;
        double længde = width;;
        double heldning = angle;
        heldning = Math.toRadians(heldning);
        double resultat = (længde/100) * ((bredde/100) / Math.cos(heldning));
        // vi skal lige have en tagsten klasse.. deafulter til b7
        double tagstenPrKvadratMeter = 0;

        tagstenPrKvadratMeter = MaterialeMapper.getDækningsgrad(ordreID);

        return resultat*tagstenPrKvadratMeter;

    }


    public void indsætStykListeIDB() {
        MaterialeListe alom = new MaterialeListe();
        //Stolper
        Materiale stolpe = alom.getMaterialeBytag("default_stolpe");
        StykListeMapper.insætStykListeElement(ordre, stolpe, antalStolper());
        System.out.println("indsatte stolper");

        //Spær
        Materiale spær = alom.getMaterialeBytag("default_spær");
        StykListeMapper.insætStykListeElement(ordre, spær, antalSpaer());

        //Tag ehh
        System.out.println(MaterialeMapper.getTagNavn(tagStenID));
        Materiale tag = alom.getMaterialeByNavn(MaterialeMapper.getTagNavn(tagStenID));
        System.out.println(tag);
        // Tagsten metoden burde nok retunere en integer.
        StykListeMapper.insætStykListeElement(ordre, tag, (int)antalTagsten());
    }
}
