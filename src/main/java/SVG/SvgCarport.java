package SVG;

public class SvgCarport {


    private int spærTykkelse = 6;

    StringBuilder SvgCarportText = new StringBuilder();


    public String Build(int lenght, int width){

        StartSvg();
        drawBase(lenght,width);
        EndSvg();
        return SvgCarportText.toString();
    }

        private void StartSvg(){
            SvgCarportText.append("<svg width=\"80%\" height=\"60%\" viewBox=\"0 0 850 850\">" + "\n");
        }

        private void drawBase(int length, int width){

            // Vandrette spær
            SvgCarportText.append("<rect x=\"20\" y=\"20\" width=\""+length+"\" " +
                    "height=\""+spærTykkelse+"\" " +
                    "style=\"stroke:black; storke-width:1; fill-opacity:0.0;\" > </rect>" + "\n"
            );
            SvgCarportText.append("<rect x=\"20\" y=\""+width+"\" width=\""+length+"\"" +
                    " height=\""+spærTykkelse+"\" " +
                    "style=\"stroke:black; storke-width:1; fill-opacity:0.0;\" > </rect>" + "\n"
            );

            // Lodrette spær
            int x = 20 - spærTykkelse;
            SvgCarportText.append("<rect x=\""+x+"\" y=\"5\" width=\"6\" height=\""+(width+30)+ "\" " +
                    "style=\"stroke:black; storke-width:1; fill-opacity:0.0;\" > </rect>" + "\n"
            );
            SvgCarportText.append("<rect x=\""+(20 + length)+"\" y=\"5\" width=\"6\" height=\""+(width+30)+"\" " +
                    "style=\"stroke:black; storke-width:1; fill-opacity:0.0;\" > </rect>" + "\n"
            );

            drawRem(length,width);
            drawStolper(length,width);
          //  drawPile(length, width);
        }

        private void drawRem(int length, int width){
        int x1 = (int) (length / 4);
            int x2 = (int) (length / 1.4);
            SvgCarportText.append(" <line x1=\""+x1+"\" y1=\"20\" x2=\""+x2+"\" y2=\""+width+"\" style=\"stroke:black;stroke-width:2;stroke-dasharray:5,5\" />\n" +
                    "\n");
            SvgCarportText.append(" <line x1=\""+x2+"\" y1=\"20\" x2=\""+x1+"\" y2=\""+width+"\" style=\"stroke:black;stroke-width:2;stroke-dasharray:5,5\" />\n" +
                    "\n");
        }


        private void drawStolper(int length, int width){
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

                SvgCarportText.append("<rect x=\""+x+"\" y=\"19\" width=\"8\" height=\"8\" " +
                        "style=\"stroke:black; storke-width:1; fill-opacity:0.0;\" > </rect>" + "\n"
                );
                SvgCarportText.append("<rect x=\""+x+"\" y=\""+ (width - 1) +"\" width=\"8\" height=\"8\" " +
                        "style=\"stroke:black; storke-width:1; fill-opacity:0.0;\" > </rect>" + "\n"
                );
                x += 180;
            }
        }

        private void drawPile(int length, int width){

        // Selve pile hovederne
         SvgCarportText.append("<defs>\n" +
                 " <marker \n" +
                 " \tid=\"beginArrow\" \n" +
                 " \tmarkerWidth=\"12\" \n" +
                 " \tmarkerHeight=\"12\" \n" +
                 " \trefX=\"0\" \n" +
                 " \trefY=\"6\" \n" +
                 " \torient=\"auto\">\n" +
                 "   <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
                 " </marker>\n" +
                 " <marker \n" +
                 " \tid=\"endArrow\" \n" +
                 " \tmarkerWidth=\"12\" \n" +
                 " \tmarkerHeight=\"12\" \n" +
                 " \trefX=\"12\" \n" +
                 " \trefY=\"6\" \n" +
                 " \torient=\"auto\">\n" +
                 "   <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
                 " </marker>\n" +
                 "</defs>\n");

         // Selve pilene med hovederne på
            // Lodrette pil
         SvgCarportText.append("<line x1=\"5\"  y1=\"5\" x2=\"5\"  y2=\""+(width+30)+"\" \n" +
                 "\tstyle=\"stroke: #006600;\n" +
                 "\tmarker-start: url(#beginArrow);\n" +
                 "\tmarker-end: url(#endArrow);\"/>");
            // Vandrette pil
            SvgCarportText.append("<line x1=\"14\"  y1=\"2\" x2=\""+(length+6+6)+"\"  y2=\"2\" \n" +
                    "\tstyle=\"stroke: #006600;\n" +
                    "\tmarker-start: url(#beginArrow);\n" +
                    "\tmarker-end: url(#endArrow);\"/>");




}

        private void EndSvg(){
        SvgCarportText.append("</svg>");
      }

}
