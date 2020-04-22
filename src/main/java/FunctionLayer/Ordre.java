package FunctionLayer;

public class Ordre {
    private int OrdreNr;
    private double carportLængde;
    private double carportBredde;
    private int tagtypeNr;
    private double hældning;
    private double redskabsrumLængde;
    private double RedskabsrumBredde;
    private User user;

    public Ordre(int ordreNr, double carportLængde, double carportBredde, int tagtypeNr, double hældning, double redskabsrumLængde, double redskabsrumBredde, User user) {
        OrdreNr = ordreNr;
        this.carportLængde = carportLængde;
        this.carportBredde = carportBredde;
        this.tagtypeNr = tagtypeNr;
        this.hældning = hældning;
        this.redskabsrumLængde = redskabsrumLængde;
        RedskabsrumBredde = redskabsrumBredde;
        this.user = user;
    }


    public int getOrdreNr() {
        return OrdreNr;
    }

    public double getCarportLængde() {
        return carportLængde;
    }

    public double getCarportBredde() {
        return carportBredde;
    }

    public int getTagtypeNr() {
        return tagtypeNr;
    }

    public double getHældning() {
        return hældning;
    }

    public double getRedskabsrumLængde() {
        return redskabsrumLængde;
    }

    public double getRedskabsrumBredde() {
        return RedskabsrumBredde;
    }

    public User getUser() {
        return user;
    }
}