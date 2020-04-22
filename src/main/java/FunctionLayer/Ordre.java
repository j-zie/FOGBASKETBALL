package FunctionLayer;

public class Ordre {
    private int OrdreNr;
    private double carportLængde;
    private double carportBredde;
    private int tagtypeNr;
    private double hældning;
    private double redskabsrumLængde;
    private double RedskabsrumBredde;
    private FKunde fKunde;

    public Ordre(int ordreNr, double carportLængde, double carportBredde, int tagtypeNr, double hældning, double redskabsrumLængde, double redskabsrumBredde, FKunde fKunde) {
        OrdreNr = ordreNr;
        this.carportLængde = carportLængde;
        this.carportBredde = carportBredde;
        this.tagtypeNr = tagtypeNr;
        this.hældning = hældning;
        this.redskabsrumLængde = redskabsrumLængde;
        this.RedskabsrumBredde = redskabsrumBredde;
        this.fKunde = fKunde;
    FKunde fkunde = new FKunde();
    }
}
