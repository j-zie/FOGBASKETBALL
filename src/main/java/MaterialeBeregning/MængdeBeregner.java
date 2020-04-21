package MaterialeBeregning;

import java.util.Scanner;

public class MængdeBeregner {

    // TODO: 21/04/2020 !find ud af hvordan input skal ind i den her slags metoder, scanner skal væk!
    public int antalStolper(){

        //Til denne metode kræves der længde fra databasen.

        Scanner S = new Scanner(System.in);

        System.out.println("Indtast længde");

        int userinput = S.nextInt();
        int AfstandprBjælke = 180;
        //int N = 180; Udhæng skal det være der eller ej?
        int minimumsøjler = 2;
        int minimumLængdefor4søjler = userinput-360;
        int AntalB = (minimumLængdefor4søjler/*-N*/)/AfstandprBjælke;
        int ExtraB = (AntalB+1);
        int Resultat = (minimumsøjler+ExtraB*2);

        return Resultat;
    }
    public int antalSpær(){

        //Til denne metode kræves der en længde fra databasen.

        Scanner S = new Scanner(System.in);

        System.out.println("Indtast længde");

        int userinput = S.nextInt();
        int AfstandPrSpær = 56;
        int Resultat = (userinput/AfstandPrSpær);

        return Resultat;

    }

    public double antalTagsten(){

        //Til denne metode kræves der en længde, bredde, vinkel og tagsten Pr Kvadratmeter

        Scanner S = new Scanner(System.in);

        System.out.println("Indtast bredde");
        double bredde = S.nextDouble();
        System.out.println("Indtast længde");
        double længde = S.nextDouble();
        System.out.println("Indtast vinkel");
        double heldning = S.nextDouble();
        heldning = Math.toRadians(heldning);

        double Resultat = (længde/100) * ((bredde/100) / Math.cos(heldning));

        System.out.println("Indtast tagstens størrelse");
        double tagstenPrKvadratMeter = S.nextDouble();
        double TotalRes = Resultat*tagstenPrKvadratMeter;

        return TotalRes;

    }
}
