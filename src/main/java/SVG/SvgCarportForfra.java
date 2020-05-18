package SVG;

import MaterialeBeregning.MængdeBeregner;

public class SvgCarportForfra {

    StringBuilder SvgCarportText = new StringBuilder();


    public String Build(int lenght, int width, int skurBredde, int skurLængde, double gavlHøjde) {


        //billede størrelse
SvgCarportText.append("<svg width=\"1000\" height=\"1000\">");
    //skur
      SvgCarportText.append("<rect x=\"50\" y=\"390\" rx=\"0\" ry=\"0\" width=\""+skurBredde+"\" height=\"225\" style=\"fill:grey;stroke:black;stroke-width:1;opacity:1\" />");
        //skur kryds
        SvgCarportText.append("<line x1=\"65\" y1=\"615\" x2=\""+(skurBredde+50)+"\" y2=\"390\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");
        SvgCarportText.append("<line x1=\"65\" y1=\"390\" x2=\""+(skurBredde+50)+"\" y2=\"615\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");

      //side og top bjælker
  SvgCarportText.append("<rect x=\"40\" y=\"375\" rx=\"0\" ry=\"0\" width=\""+width+"\" height=\"15\" style=\"fill:white;stroke:black;stroke-width:1;opacity:1\" />");
  SvgCarportText.append("<rect x=\"50\" y=\"390\" rx=\"0\" ry=\"0\" width=\"15\" height=\"225\" style=\"fill:white;stroke:black;stroke-width:1;opacity:1\" />");
  SvgCarportText.append("<rect x=\""+(width+15)+"\" y=\"390\" rx=\"0\" ry=\"0\" width=\"15\" height=\"225\" style=\"fill:white;stroke:black;stroke-width:1;opacity:1\" />");
        //tag
  SvgCarportText.append("<polygon points=\"40,375 "+(width+40)+",375 "+(40+(width/2))+","+(375-gavlHøjde)+"\" style=\"fill:white;stroke:black;stroke-width:1\" />");
        //måle enheder
  SvgCarportText.append("<text x=\""+((skurBredde/2)+45)+"\" y=\"645\" fill=\"black\" transform=\"rotate(0 20,40)\">"+skurBredde+"</text>");
  SvgCarportText.append("<line x1=\"50\" y1=\"690\" x2=\""+(width+30)+"\" y2=\"690\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");
  SvgCarportText.append("<text x=\""+((width/2)+45)+"\" y=\"685\" fill=\"black\" transform=\"rotate(0 40,40)\">"+width+"</text>");
  SvgCarportText.append("<line x1=\"50\" y1=\"650\" x2=\""+(skurBredde+50)+"\" y2=\"650\" style=\"stroke:rgb(0,0,0);stroke-width:1\" />");

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
