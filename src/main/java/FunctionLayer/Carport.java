package FunctionLayer;

public class Carport {

    /**
     * Carport klassen laver en carport constructor til at gemme carport oplysninger for et tilbud og evt brug til 3d skitse.
     */

    public Carport(double carportLængde, double carportBredde, int tagtypeID, double hældning, double redskabsrumLængde, double getRedskabsrumBredde) {
        this.carportLængde = carportLængde;
        this.carportBredde = carportBredde;
        this.tagtypeID = tagtypeID;
        this.hældning = hældning;
        this.redskabsrum = redskabsrum;
        this.redskabsrumLængde = redskabsrumLængde;
        this.getRedskabsrumBredde = getRedskabsrumBredde;

    }
    private double carportLængde;
    private double carportBredde;
    private int tagtypeID;
    private double hældning;
    private boolean redskabsrum;
    private double redskabsrumLængde;
    private double getRedskabsrumBredde;

    public double getCarportLængde() {
        return carportLængde;
    }

    public double getCarportBredde() {
        return carportBredde;
    }

    public int getTagtypeID() {
        return tagtypeID;
    }

    public double getHældning() {
        return hældning;
    }

    public boolean isRedskabsrum() {
        return redskabsrum;
    }

    public double getRedskabsrumLængde() {
        return redskabsrumLængde;
    }

    public double getGetRedskabsrumBredde() {
        return getRedskabsrumBredde;
    }

    public void setCarportLængde(double carportLængde) {
        this.carportLængde = carportLængde;
    }

    public void setCarportBredde(double carportBredde) {
        this.carportBredde = carportBredde;
    }

    public void setTagtypeID(int tagtypeID) {
        this.tagtypeID = tagtypeID;
    }

    public void setHældning(double hældning) {
        this.hældning = hældning;
    }

    public void setRedskabsrum(boolean redskabsrum) {
        this.redskabsrum = redskabsrum;
    }

    public void setRedskabsrumLængde(double redskabsrumLængde) {
        this.redskabsrumLængde = redskabsrumLængde;
    }

    public void setGetRedskabsrumBredde(double getRedskabsrumBredde) {
        this.getRedskabsrumBredde = getRedskabsrumBredde;
    }
}

