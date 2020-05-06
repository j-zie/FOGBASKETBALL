package SVG;

public class Rem implements Draw{


    @Override
    public String draw(int length, int width) {
StringBuilder remText = new StringBuilder();
        int x1 = (int) (length / 4) + 40;
        int x2 = (int) (length / 1.4) + 40;
        remText.append(" <line x1=\""+x1+"\" y1=\"80\" x2=\""+x2+"\" y2=\""+(width -  50 + 40)+"\" style=\"stroke:black;stroke-width:2;stroke-dasharray:5,5\" />\n" +
                "\n");
        remText.append(" <line x1=\""+x2+"\" y1=\"80\" x2=\""+x1+"\" y2=\""+(width - 50 + 40)+"\" style=\"stroke:black;stroke-width:2;stroke-dasharray:5,5\" />\n" +
                "\n");
        return remText.toString();
    }
}
