package SVG;

public class Spær implements Draw  {


    int spærTykkelse = 10;
    int x = 0;
    int y1 = 30;


    @Override
    public String draw(int length, int width) {
        StringBuilder svgSpærText = new StringBuilder();
        int inderBredde = width - 60;
        int y2 = inderBredde + spærTykkelse;

        svgSpærText.append("<rect x=\"" +x+ "\" y=\""+y1+"\" width=\""+length+"\" " +
                "height=\""+spærTykkelse+"\" " +
                "style=\"stroke:black; storke-width:1; fill:rgb(255,255,255);\" > </rect>" + "\n"
        );

        svgSpærText.append("<rect x=\""+x+"\" y=\""+y2+"\" width=\""+length+"\"" +
                " height=\""+spærTykkelse+"\" " +
                "style=\"stroke:black; storke-width:1;  fill:rgb(255,255,255);\" > </rect>" + "\n"
        );

        svgSpærText.append("<rect x=\"" +0+ "\" y=\""+0+"\" width=\""+spærTykkelse+"\" " +
                "height=\""+width+"\" " +
                "style=\"stroke:black; storke-width:1; fill:rgb(255,255,255);\" > </rect>" + "\n"
        );

        svgSpærText.append("<rect x=\""+(length - 10)+"\" y=\""+0+"\" width=\""+spærTykkelse+"\"" +
                " height=\""+width+"\" " +
                "style=\"stroke:black; storke-width:1; fill:rgb(255,255,255);\" > </rect>" + "\n"
        );



        return svgSpærText.toString();
    }
}


