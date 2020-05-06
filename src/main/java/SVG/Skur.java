package SVG;

public class Skur implements Draw {

  int skurBredde;
  int skurLængde;

    public Skur(int skurBredde, int skurLængde){
        this.skurBredde = skurBredde;
        this.skurLængde = skurLængde;
    }

    @Override
    public String draw(int length, int width) {

        int x = length - skurLængde + 40;
        return ("<rect x=\""+x+"\" y=\"80\" width=\""+skurLængde+"\" " +
                "height=\""+skurBredde+"\" " +
                "style=\"stroke:black;" +
                " storke-width:2; " +
                "stroke-dasharray:2,2;" +
                "fill-opacity:0.0;" +
                "fill:white;\" >" +
                " </rect>" +
                "\n");

    }
}
