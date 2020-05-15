package FunctionLayer;

import java.util.ArrayList;

public class KurvItems {

    /**
     * KurvItems klassen er til for at kunne få en kundes ordre ind i deres kurv.
     * @beskrivelse beskrivelsen af en carport
     * @imgPath Vejen til billede af en carport
     * @pris prisen på en carport
     * @kurvListe en liste der bruges til at indeholde alle kundens ordre.
     */

    private String beskrivelse;
    private String imgPath;
    private String pris;
    private String tag;

    private static ArrayList<KurvItems> kurvListe;

    /**
     * En simpel contructor til at danne et nyt kurv object
     */
    private KurvItems(String beskrivelse, String imgPath, String pris, String tag){
        this.beskrivelse = beskrivelse;
        this.imgPath = imgPath;
        this.pris = pris;
        this.tag = tag;
    }


    /**
     * Denne metode instansiere kurvlisten hvis den ikke er blevet det før.
     * Og så til føjer den et kurvListe object til listen.
     */
    public static void addItems(String beskrivelse, String imgPath, String pris, String tag ){
        if (kurvListe ==  null){
            kurvListe = new ArrayList<>();
        }
        kurvListe.add(new KurvItems(beskrivelse,imgPath, pris, tag));
    }


    /**
     * Denne metode fjerner en vare fra listen
     * @param imgPath indetificere hvilken carport der skal fjernes.
     */
    public static void removeItem(String imgPath){
      int x = 0;
        for (KurvItems item : getItemList()) {
            if (item.imgPath.equals(imgPath)) {
                kurvListe.remove(x);
                return;
                  } else {
                x++;
            }

            }
    }


    /**
     * Simple getters
     */
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
    public String getTag() { return tag;  }

}
