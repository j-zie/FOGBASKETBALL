package FunctionLayer;

public class Ordre {
    private int OrdreNr;
    private User user;
    private Carport carport;


    /**
     *
     * OBS: Denne constructor bruges til at hente ordre ned med
     * @
     */


    // OBS burde kun indeholde denne constructor:
    public Ordre(Carport carport, User kunde ){
        this.carport = carport;
        this.user = kunde;
    }


    public Ordre(Carport carport, User kunde, int ordreNr){
        this.carport = carport;
        this.user = kunde;
        this.OrdreNr = ordreNr;
    }





    public Carport getcarport() {
        return carport;
    }
    public int getOrdreNr() {
        return OrdreNr;
    }

    public User getUser() {
        return user;
    }

}