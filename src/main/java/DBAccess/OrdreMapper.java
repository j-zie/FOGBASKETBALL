package DBAccess;


import FunctionLayer.OrdreRetrivalException;
import FunctionLayer.Carport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
