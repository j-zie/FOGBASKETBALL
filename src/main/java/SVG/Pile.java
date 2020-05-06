package SVG;

public class Pile implements Draw {



    @Override
    public String draw(int length, int width) {
        StringBuilder pileText = new StringBuilder();

        pileText.append(Pilehoved());
        pileText.append(lodretPil(width));
        pileText.append(lodretPiltext(length,width));
        pileText.append(vandretpil(length,width));
        pileText.append(vandretpilText(length,width));

        return pileText.toString();
    }


    private String lodretPil(int width){

        int y2 = width + 40;

        return  ("<line x1=\"20\" " +
                "y1=\"40\"" +
                " x2=\"20\"" +
                "  y2=\""+(y2)+"\" \n" +
                "\tstyle=\"stroke: #000000;\n" +
                "\tmarker-start: url(#beginArrow);\n" +
                "\tmarker-end: url(#endArrow);\"/>");


    }

    private String lodretPiltext(int length, int width){
        int x = 15;
        int y = (width / 2) + 40;

        return ("<text x=\""+x+"\" y=\""+y+"\" transform=\"rotate(-90, "+x+","+y+")\">" +width+  "</text>");

    }

    private String vandretpil(int length, int width){

        int x2 = length + 40;

        return ("<line x1=\"40\"" +
                " y1=\""+(width + 50)+"\"" +
                " x2=\""+(x2)+"\" " +
                " y2=\""+(width + 50)+"\" \n" +
                "\tstyle=\"stroke: #000000;\n" +
                "\tmarker-start: url(#beginArrow);\n" +
                "\tmarker-end: url(#endArrow);\"/>");

    }
    private String vandretpilText(int length, int width){
        int x = (length + 15) / 2;
        int y = width + 65;

        return ("<text x=\""+x+"\" y=\""+y+"\">" +length+  "</text>");

    }

    private String Pilehoved(){
        return ("<defs>\n" +
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
    }
}
