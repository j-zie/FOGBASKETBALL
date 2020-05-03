package SVG;

public class Tag implements Draw {




    @Override
    public String draw(int length, int width) {

        return ("<rect x=\"0\" y=\"0\" width=\""+length+"\" " +
                "height=\""+width+"\" " +
                "style=\"stroke:black;" +
                " storke-width:2; " +
                "fill:white;\" >" +
                " </rect>" +
                "\n");
    }
}
