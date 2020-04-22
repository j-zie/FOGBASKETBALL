package DBAccess;


import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;

public class OrdreMapper {

    public static ArrayList<Ordre> getAlleOrdre() throws OrdreRetrivalException {
        User user = new User("","","","","","",0);
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM ORDRE";
            Statement stm;
            stm = con.createStatement();
            ResultSet rs;
            rs = stm.executeQuery(SQL);
            ArrayList<Ordre> OrdreListe = new ArrayList<>();


            while(rs.next()) {

                String id = Integer.toString(rs.getInt("brugerId"));

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
                        user.setPostnr(rs2.getInt("postNr"));
                        user.setTelefon(rs2.getString("telefonNummer"));
                        user.setEmail(rs2.getString("email"));
                    } else {
                    throw new OrdreRetrivalException("Kunne ikke få fat i user");
                    }
                } catch ( SQLException ex ) {
                }

                Ordre ordre = new Ordre(rs.getInt("ordreNr"),rs.getInt("carportLængde"), rs.getInt("carportBredde"),rs.getInt("tagtypeNr"),rs.getDouble("hældning"),rs.getInt("redskabsrumLængde"),rs.getInt("redskabsrumBredde"),user);
                OrdreListe.add(ordre);
            }

            return OrdreListe;

        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new OrdreRetrivalException(ex.getMessage());
        }
    }

    public static void createOrder( User kunde, Carport carport ) throws OrdreRetrivalException {
        try {
            Connection con = Connector.connection();

            String SQL = "INSERT INTO ordre (brugerid, carportLængde, carportBredde, redskabsrumLængde, redskabsrumBredde, tagTypeNr, hældning) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setInt(1, kunde.getId());
            ps.setDouble( 2, carport.getCarportLængde());
            ps.setDouble( 3, carport.getCarportBredde());
            ps.setDouble( 4, carport.getRedskabsrumLængde());
            ps.setDouble( 5, carport.getGetRedskabsrumBredde());
            ps.setDouble( 6, carport.getTagtypeID());
            ps.setDouble( 7, carport.getHældning());
            ps.executeUpdate();

        } catch ( SQLException | ClassNotFoundException ex ) {

            throw new OrdreRetrivalException( ex.getMessage() );
        }
    }

}
