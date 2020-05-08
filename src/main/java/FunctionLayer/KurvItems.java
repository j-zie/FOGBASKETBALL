package FunctionLayer;

import java.util.ArrayList;

public class KurvItems {

    private String beskrivelse;
    private String imgPath;
    private String pris;


    private static ArrayList<KurvItems> kurvListe;



    private KurvItems(String beskrivelse, String imgPath, String pris){
        this.beskrivelse = beskrivelse;
        this.imgPath = imgPath;
        this.pris = pris;
    }

    public static void addItems(String beskrivelse, String imgPath, String pris ){
        if (kurvListe ==  null){
            kurvListe = new ArrayList<>();
        }
        kurvListe.add(new KurvItems(beskrivelse,imgPath, pris));
    }

    public static ArrayList<KurvItems> getItemList(){
        return kurvListe;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public String getImgPath() {
        return imgPath;
    }
    public String getPris() { return pris;  }

}
