package FunctionLayer;

/**
 * Materiale klassen laver en constructor til et materiale så vi kan angive priser til de givede materialer.
 */

public class Materiale {
    private int materialeID;
    private String materialeNavn;
    private Double pris;

    public Materiale(int materialeID, String materialeNavn, Double pris) {
        this.materialeID = materialeID;
        this.materialeNavn = materialeNavn;
        this.pris = pris;
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
}
