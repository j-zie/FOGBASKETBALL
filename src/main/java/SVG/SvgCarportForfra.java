package SVG;

public class SvgCarportForfra {

    StringBuilder SvgCarportText = new StringBuilder();


    public String Build(int lenght, int width, int skurBredde, int skurLængde) {


        //billede størrelse
SvgCarportText.append("<svg width=\"1000\" height=\"1000\">");
//skur
      SvgCarportText.append("<rect x=\"50\" y=\"100\" rx=\"0\" ry=\"0\" width=\""+skurBredde+"\" height=\""+150+"\" style=\"fill:blue;stroke:black;stroke-width:3;opacity:1\" />");

      //side og top bjælker
  SvgCarportText.append("<rect x=\"40\" y=\"85\" rx=\"0\" ry=\"0\" width=\"170\" height=\"15\" style=\"fill:white;stroke:black;stroke-width:3;opacity:1\" />");
  SvgCarportText.append("<rect x=\"50\" y=\"100\" rx=\"0\" ry=\"0\" width=\"15\" height=\"150\" style=\"fill:white;stroke:black;stroke-width:3;opacity:1\" />");
  SvgCarportText.append("<rect x=\"185\" y=\"100\" rx=\"0\" ry=\"0\" width=\"15\" height=\"150\" style=\"fill:white;stroke:black;stroke-width:3;opacity:1\" />");
        //tag
  SvgCarportText.append("<polygon points=\"120,5 210,85 40,85\" style=\"fill:white;stroke:black;stroke-width:3\" />");
        //måle enheder
  SvgCarportText.append("<text x=\"80\" y=\"265\" fill=\"red\" transform=\"rotate(0 20,40)\">Skur Bredde</text>");
  SvgCarportText.append("<line x1=\"50\" y1=\"290\" x2=\"200\" y2=\"290\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");
  SvgCarportText.append("<text x=\"80\" y=\"285\" fill=\"red\" transform=\"rotate(0 40,40)\">Stolpe bredde</text>");
  SvgCarportText.append("<line x1=\"50\" y1=\"270\" x2=\"110\" y2=\"270\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");
        //midter kryds
  SvgCarportText.append("<line x1=\"65\" y1=\"250\" x2=\"185\" y2=\"100\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");
  SvgCarportText.append("<line x1=\"65\" y1=\"100\" x2=\"185\" y2=\"250\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");
      SvgCarportText.append("</svg>");
      return SvgCarportText.toString();
    }
}
