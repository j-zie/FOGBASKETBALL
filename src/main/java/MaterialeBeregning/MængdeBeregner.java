package MaterialeBeregning;

import FunctionLayer.Ordre;

import java.util.Scanner;

public class MængdeBeregner {
    double height;
    double width;
    double angle;
    double tagSten;

    public MængdeBeregner(Ordre ordre) {
        width = ordre.getCarportBredde();
        height = ordre.getCarportLængde();
        angle = ordre.getHældning();
        tagSten = ordre.getTagtypeNr();
    }

    // TODO: 21/04/2020 !find ud af hvordan input skal ind i den her slags metoder, scanner skal væk!
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
}
