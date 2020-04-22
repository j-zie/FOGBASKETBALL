package DBAccess;


import FunctionLayer.*;

import java.sql.*;

public class OrdreMapper {

    public static Carport getOrdre(String OrdreID) throws OrdreRetrivalException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT carportLængde, carportBredde, tagtype, tæghældning, redskabsrum, redskabsrumBredde, redskabsrumLængde FROM Ordre "
                    + "WHERE OrdreID=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, OrdreID );
            ResultSet rs = ps.executeQuery();
            //alle de her skal instiseres når db er klar
            double carportLængde = 0;
            double carportBredde = 0;
            int tagtypeID = 0;
            double tæghældning = 0;
            boolean redskabsrum = false;
            double redskabsrumBredde = 0;
            double redskabsrumLængde = 0;
            Carport carport = new Carport( carportLængde, carportBredde, tagtypeID, tæghældning, redskabsrum, redskabsrumBredde, redskabsrumLængde);
            if ( rs.next() ) {
                // en masse Carport.set; her
                return carport;
            } else {
                throw new OrdreRetrivalException( "Could not retrive data from database" );
            }
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
