package SVG;

public class Stolper implements Draw {

    int stolpeBredde = 12;
    int y1 = 29;

    @Override
    public String draw(int length, int width) {
    StringBuilder stolpeText = new StringBuilder();

        int y2 = width - 60 + stolpeBredde - 3;


        int userinput = (int) length;
        int AfstandprBjælke = 180;
        //int N = 180; Udhæng skal det være der eller ej?
        int minimumsøjler = 2;
        int minimumLængdefor4søjler = userinput-360;
        int AntalB = (minimumLængdefor4søjler/*-N*/)/AfstandprBjælke;
        int ExtraB = (AntalB+1);
        int Resultat = (minimumsøjler+ExtraB);

        int x = 40;
        for (int i = 0; i < Resultat; i++){

            stolpeText.append("<rect x=\""+x+"\" y=\""+y1+"\" width=\"12\" height=\"12\" " +
                    "style=\"stroke:black; storke-width:1; fill-opacity:0.0;\" > </rect>" + "\n"
            );
            stolpeText.append("<rect x=\""+x+"\" y=\""+ y2 +"\" width=\"12\" height=\"12\" " +
                    "style=\"stroke:black; storke-width:1; fill-opacity:0.0;\" > </rect>" + "\n"
            );
            x += 180;
        }


        return stolpeText.toString();
    }
}
