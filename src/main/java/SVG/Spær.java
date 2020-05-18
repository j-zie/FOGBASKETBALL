package SVG;

public class Spær implements Draw  {


    int spærTykkelse = 10;
    int x = 0 + 40;
    int y1 = 30 + 40;


    @Override
    public String draw(int length, int width) {
        StringBuilder svgSpærText = new StringBuilder();
        int inderBredde = width - 60;
        int y2 = inderBredde + spærTykkelse + 40;

        svgSpærText.append("<rect x=\"" +x+ "\" y=\""+y1+"\" width=\""+length+"\" " +
                "height=\""+spærTykkelse+"\" " +
                "style=\"stroke:black; storke-width:1; fill:rgb(255,255,255);\" > </rect>" + "\n"
        );

        svgSpærText.append("<rect x=\""+x+"\" y=\""+y2+"\" width=\""+length+"\"" +
                " height=\""+spærTykkelse+"\" " +
                "style=\"stroke:black; storke-width:1;  fill:rgb(255,255,255);\" > </rect>" + "\n"
        );

        svgSpærText.append("<rect x=\"" +40+ "\" y=\""+40+"\" width=\""+spærTykkelse+"\" " +
                "height=\""+width+"\" " +
                "style=\"stroke:black; storke-width:1; fill:rgb(255,255,255);\" > </rect>" + "\n"
        );

        svgSpærText.append("<rect x=\""+(length - 10 + 40)+"\" y=\""+40+"\" width=\""+spærTykkelse+"\"" +
                " height=\""+width+"\" " +
                "style=\"stroke:black; storke-width:1; fill:rgb(255,255,255);\" > </rect>" + "\n"
        );


        int mellemRum = 56 + spærTykkelse;
        int antalSpær = (length / mellemRum);

        int location = 40 + mellemRum;
        for (int i = 0; i < antalSpær; i++){

            svgSpærText.append("<rect x=\"" +location+ "\" y=\""+40+"\" width=\""+spærTykkelse+"\" " +
                    "height=\""+width+"\" " +
                    "style=\"stroke:black; storke-width:1; fill:rgb(255,255,255);\" > </rect>" + "\n"
            );
        location += (56 + spærTykkelse);
        }


        return svgSpærText.toString();
    }
}


