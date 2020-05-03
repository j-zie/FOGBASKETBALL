package SVG;

public class SvgCarport {

    private Tag tag = new Tag();
    private Spær spær = new Spær();
    private Rem rem = new Rem();
    private Stolper stolper = new Stolper();
    private Pile pile = new Pile();
    private Skur skur;

    StringBuilder SvgCarportText = new StringBuilder();


    public String Build(int lenght, int width, int skurBredde, int skurLængde){
        skur = new Skur(skurBredde, skurLængde);
        startSvg(lenght,width);

        SvgCarportText.append(tag.draw(lenght,width));
        SvgCarportText.append(skur.draw(lenght,width));
        SvgCarportText.append(spær.draw(lenght,width));
        SvgCarportText.append(rem.draw(lenght,width));
        SvgCarportText.append(stolper.draw(lenght,width));

        EndSvg();
        return SvgCarportText.toString();
    }

private void startSvg(int length, int width){
    SvgCarportText.append("<svg width=\"80%\" height=\"70%\" viewBox=\"0 0 "+(length + 40)+ " "+ (width + 40 ) +"\" preserveAspectRatio=\"xMinYMin\" style=\"margin-left: auto;\">" + "\n");
    SvgCarportText.append(pile.draw(length,width));
    SvgCarportText.append("<svg width=\"90%\" height=\"90%\" x=\"20\" y=\"20\" viewBox=\"0 0 "+length+ " "+ width+"\" preserveAspectRatio=\"xMinYMin\">" + "\n");

}
        private void EndSvg(){
        SvgCarportText.append("</svg>");
            SvgCarportText.append("</svg>");
      }

}
