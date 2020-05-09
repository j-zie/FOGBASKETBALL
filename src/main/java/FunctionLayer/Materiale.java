package FunctionLayer;

/**
 * Materiale klassen laver en constructor til et materiale så vi kan angive priser til de givede materialer.
 */

public class Materiale {
    private int materialeID;
    private String materialeNavn;
    private Double pris;
    private String beskrivelse;
    private String tag;
    private String path;

    public Materiale(int materialeID, String materialeNavn, Double pris) {
        this.materialeID = materialeID;
        this.materialeNavn = materialeNavn;
        this.pris = pris;
        this.tag = null;
        this.beskrivelse = null;
        path = null;
    }

    public Materiale(int materialeID, String materialeNavn, Double pris, String beskrivelse,
                     String tag) {
        this.materialeID = materialeID;
        this.materialeNavn = materialeNavn;
        this.pris = pris;
        this.beskrivelse = beskrivelse;
        this.tag = tag;
        path = null;
    }
    public Materiale(int materialeID, String materialeNavn, Double pris, String tag,
                     String beskrivelse, String path) {
        this.materialeID = materialeID;
        this.materialeNavn = materialeNavn;
        this.pris = pris;
        this.path = path;
        this.tag = tag;
        this.beskrivelse = beskrivelse;
    }



    public int getMaterialeID() {
        return materialeID;
    }

    public void setMaterialeID(int materialeID) {
        this.materialeID = materialeID;
    }

    public String getMaterialeNavn() {
        return materialeNavn;
    }

    public String getTag() {
        return tag;
    }

    public void setMaterialeNavn(String materialeNavn) {
        this.materialeNavn = materialeNavn;
    }

    public Double getPris() {
        return pris;
    }

    public void setPris(Double pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return "Materiale{" +
                "materialeID=" + materialeID +
                ", materialeNavn='" + materialeNavn + '\'' +
                ", pris=" + pris +
                '}';
    }

    public String getPath() {
        return path;
    }
}
