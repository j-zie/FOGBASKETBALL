package SVG;

public class Spær  {


    int spærTykkelse = 10;


    public String drawSpær(int length, int width){
        StringBuilder svgSpærText = new StringBuilder();
        int totalBredde = width + 60;


        svgSpærText.append("<rect x=\"20\" y=\"20\" width=\""+length+"\" " +
                "height=\""+spærTykkelse+"\" " +
                "style=\"stroke:black; storke-width:1; fill:rgb(255,255,255);\" > </rect>" + "\n"
        );
        svgSpærText.append("<rect x=\"20\" y=\""+width+"\" width=\""+length+"\"" +
                " height=\""+spærTykkelse+"\" " +
                "style=\"stroke:black; storke-width:1; fill-opacity:0.0;\" > </rect>" + "\n"
        );

        // Lodrette spær
        int x = 20 - spærTykkelse;
        svgSpærText.append("<rect x=\""+x+"\" y=\"5\" width=\"2\" height=\""+(width+30)+ "\" " +
                "style=\"stroke:black; storke-width:1; fill-opacity:0.0;\" > </rect>" + "\n"
        );
        svgSpærText.append("<rect x=\""+(20 + length)+"\" y=\"5\" width=\"6\" height=\""+(width+30)+"\" " +
                "style=\"stroke:black; storke-width:1; fill-opacity:0.0;\" > </rect>" + "\n"
        );

       return "";
    }


}


