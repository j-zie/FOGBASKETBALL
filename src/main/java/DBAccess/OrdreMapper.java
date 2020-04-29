package DBAccess;


import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;
/**
 * OrdreMapper håndtere kommunikation mellem database og vores program.
 * Funktioner herfra bliver benyttet mange andre steder, se eksempelvis Mængdeberegner.
 */
public class OrdreMapper {
    /**
     * TODO(Jonathan): Kunne godt refaktores med en join, så der ikke er så meget unødvendigt instantiering. I det mindste fix den tomme catch blok - ellers nice.
     * Retunere alle ordre fra databasen
     * @return Retunere typen ArrayList<Ordre>.
     */
    public static ArrayList<Ordre> getAlleOrdre() throws OrdreRetrivalException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM ordre";
            Statement stm;
            stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery(SQL);
            ArrayList<Ordre> OrdreListe = new ArrayList<>();


            while(rs.next()) {

                String id = Integer.toString(rs.getInt("brugerId"));
                User user = new User("","","","","","",0,"");

                try {

                    String SQL2 = "SELECT * FROM bruger "
                            + "WHERE brugerId=?";
                    PreparedStatement ps = con.prepareStatement( SQL2 );
                    ps.setString( 1, id );
                    ResultSet rs2 = ps.executeQuery();

                    if ( rs2.next() ) {

                        user.setId(rs2.getInt("brugerId"));
                        user.setNavn(rs2.getString("navn"));
                        user.setAdresse(rs2.getString("adresse"));
                        user.setPostnr(rs2.getInt("postnr"));
                        user.setTelefon(rs2.getString("telefon"));
                        user.setEmail(rs2.getString("email"));
                    } else {
                    throw new OrdreRetrivalException("Kunne ikke få fat i user");
                    }
                } catch ( SQLException ex ) {
                }

               // Ordre ordre = new Ordre(rs.getInt("ordreNr"),rs.getInt("carportLængde"), rs.getInt("carportBredde"),rs.getInt("tagtypeNr"),rs.getDouble("hældning"),rs.getInt("redskabsrumLængde"),rs.getInt("redskabsrumBredde"),user);
                Carport carport = new Carport(rs.getInt("carportLængde"), rs.getInt("carportBredde"),rs.getInt("tagtypeNr"),rs.getDouble("hældning"),rs.getInt("redskabsrumLængde"),rs.getInt("redskabsrumBredde"));
                Ordre ordre = new Ordre(carport, user, rs.getInt("ordreNr"));
                OrdreListe.add(ordre);
            }


            return OrdreListe;

        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new OrdreRetrivalException(ex.getMessage());
        }
    }
    /**
     * Metode gemmer ordre til databasen
     * @param ordre er af typen ordreobjekt, hvis tilstand skal indeholde et CarportObejkt og Userobjekt.
     */
    public static void createOrder(Ordre ordre) throws OrdreRetrivalException {
        try {
            Connection con = Connector.connection();

            String SQL = "INSERT INTO ordre (brugerid, carportLængde, carportBredde, redskabsrumLængde, redskabsrumBredde, tagTypeNr, hældning) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, ordre.getUser().getId());
            ps.setDouble( 2, ordre.getcarport().getCarportLængde());
            ps.setDouble( 3, ordre.getcarport().getCarportBredde());
            ps.setDouble( 4, ordre.getcarport().getRedskabsrumLængde());
            ps.setDouble( 5, ordre.getcarport().getGetRedskabsrumBredde());
            ps.setDouble( 6,  ordre.getcarport().getTagtypeID());
            ps.setDouble( 7,  ordre.getcarport().getHældning());
            ps.executeUpdate();

        } catch ( SQLException | ClassNotFoundException ex ) {

            throw new OrdreRetrivalException( ex.getMessage() );
        }
    }

}
