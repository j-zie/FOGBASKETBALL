package SVG;

public class SvgCarport {

    private Tag tag = new Tag();
    private Spær spær = new Spær();
    private Rem rem = new Rem();
    private Stolper stolper = new Stolper();
    private Pile pile = new Pile();

    private int spærTykkelse = 6;

    StringBuilder SvgCarportText = new StringBuilder();


    public String Build(int lenght, int width){

        startSvg(lenght,width);

        SvgCarportText.append(tag.draw(lenght,width));
        SvgCarportText.append(spær.draw(lenght,width));
        SvgCarportText.append(rem.draw(lenght,width));
        SvgCarportText.append(stolper.draw(lenght,width));

        EndSvg();
        return SvgCarportText.toString();
    }

private void startSvg(int length, int width){
    SvgCarportText.append("<svg width=\"80%\" height=\"70%\" viewBox=\"0 0 "+(length + 40)+ " "+ (width + 40 ) +"\" >" + "\n");
    SvgCarportText.append(pile.draw(length,width));
    SvgCarportText.append("<svg width=\"90%\" height=\"90%\" x=\"20\" y=\"20\" viewBox=\"0 0 "+length+ " "+ width+"\" preserveAspectRatio=\"xMinYMin\">" + "\n");

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
            SvgCarportText.append("</svg>");
      }

}
