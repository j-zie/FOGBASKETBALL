package SVG;

import MaterialeBeregning.MængdeBeregner;

public class SvgCarportForfra {

    StringBuilder SvgCarportText = new StringBuilder();


    public String Build(int lenght, int width, int skurBredde, int skurLængde, double gavlHøjde) {


        //billede størrelse
SvgCarportText.append("<svg width=\"1000\" height=\"1000\">");
    //skur
      SvgCarportText.append("<rect x=\"50\" y=\"165\" rx=\"0\" ry=\"0\" width=\""+skurBredde+"\" height=\"150\" style=\"fill:grey;stroke:black;stroke-width:1;opacity:1\" />");
        //skur kryds
        SvgCarportText.append("<line x1=\"65\" y1=\"315\" x2=\""+(skurBredde+50)+"\" y2=\"165\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");
        SvgCarportText.append("<line x1=\"65\" y1=\"165\" x2=\""+(skurBredde+50)+"\" y2=\"315\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");

      //side og top bjælker
  SvgCarportText.append("<rect x=\"40\" y=\"150\" rx=\"0\" ry=\"0\" width=\""+width+"\" height=\"15\" style=\"fill:white;stroke:black;stroke-width:1;opacity:1\" />");
  SvgCarportText.append("<rect x=\"50\" y=\"165\" rx=\"0\" ry=\"0\" width=\"15\" height=\"150\" style=\"fill:white;stroke:black;stroke-width:1;opacity:1\" />");
  SvgCarportText.append("<rect x=\""+(width+15)+"\" y=\"165\" rx=\"0\" ry=\"0\" width=\"15\" height=\"150\" style=\"fill:white;stroke:black;stroke-width:1;opacity:1\" />");
        //tag
  SvgCarportText.append("<polygon points=\"40,150 "+(width+40)+",150 "+(40+(width/2))+","+(150-gavlHøjde)+"\" style=\"fill:white;stroke:black;stroke-width:1\" />");
        //måle enheder
  SvgCarportText.append("<text x=\""+((skurBredde/2)+45)+"\" y=\"365\" fill=\"black\" transform=\"rotate(0 20,40)\">"+skurBredde+"</text>");
  SvgCarportText.append("<line x1=\"50\" y1=\"390\" x2=\""+(width+30)+"\" y2=\"390\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");
  SvgCarportText.append("<text x=\""+((width/2)+45)+"\" y=\"385\" fill=\"black\" transform=\"rotate(0 40,40)\">"+width+"</text>");
  SvgCarportText.append("<line x1=\"50\" y1=\"370\" x2=\""+(skurBredde+50)+"\" y2=\"370\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");

      SvgCarportText.append("</svg>");
      return SvgCarportText.toString();
    }
    public double gavlBeregner(double hældning, double totalLængde){
        double lilleb = totalLængde/2;
        lilleb = Math.toRadians(lilleb);
        double storeA = hældning;
        storeA = Math.toRadians(storeA);
        double storeC = 90;
        storeC = Math.toRadians(storeC);

        double storeB = Math.toRadians(180)-storeA-storeC;

        double lillea = (Math.sin(storeA)*lilleb)/Math.sin(storeB);

        return Math.toDegrees(lillea);
    }
}
