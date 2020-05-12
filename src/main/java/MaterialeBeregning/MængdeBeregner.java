package MaterialeBeregning;

import DBAccess.StykListeMapper;
import FunctionLayer.Materiale;
import FunctionLayer.MaterialeListe;
import FunctionLayer.Ordre;

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
    double tagSten;
    int ordreID;

    public MængdeBeregner(Ordre ordre) {
        width = ordre.getcarport().getCarportBredde();
        height = ordre.getcarport().getCarportLængde();
        angle = ordre.getcarport().getHældning();
        tagSten = ordre.getcarport().getTagtypeID();
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
        double Resultat = (længde/100) * ((bredde/100) / Math.cos(heldning));
        System.out.println("Indtast tagstens størrelse");
        // vi skal lige have en tagsten klasse.. deafulter til b7
        double tagstenPrKvadratMeter = 2.7;
        double TotalRes = Resultat*tagstenPrKvadratMeter;

        return TotalRes;
    }


    public void indsætStykListeIDB() {
        MaterialeListe alom = new MaterialeListe();
        //Stolper
        Materiale stolpe = alom.getMaterialeBytag("default_stolpe");
        StykListeMapper.insætStykListeElement(ordre, stolpe, antalStolper());

        //Spær
        Materiale spær = alom.getMaterialeBytag("default_spær");
        StykListeMapper.insætStykListeElement(ordre, spær, antalSpaer());

    }

}
