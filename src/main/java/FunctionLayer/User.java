package FunctionLayer;

/**
 * The purpose of User is to...
 * @author kasper
 */
public class User {


    public String getRolle() {
        return rolle;
    }

    public User(String navn, String adresse, String by, String telefon, String email, int id,
                String password,  int postnr) {
        this.navn = navn;
        this.adresse = adresse;
        this.by = by;
        this.telefon = telefon;
        this.email = email;
        this.id = id;
        this.password = password;
        this.rolle = "kunde";
        this.postnr = postnr;
    }

    public User(String navn, String adresse, String by, String telefon, String email,
                String password,  int postnr) {
        this.navn = navn;
        this.adresse = adresse;
        this.by = by;
        this.telefon = telefon;
        this.email = email;
        this.password = password;
        this.rolle = "kunde";
        this.postnr = postnr;
    }

    public int getPostnr() {
        return postnr;
    }

    int postnr;
    String rolle;
    int id;
    String password;
    String navn;
    String adresse;
    String by;
    String telefon;
    String email;

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getBy() {
        return by;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getRole() {
        return rolle;
    }

    public void setRole( String role ) {
        this.rolle = role;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

}
