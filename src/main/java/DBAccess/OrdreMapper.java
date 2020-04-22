package DBAccess;


import FunctionLayer.FKunde;
import FunctionLayer.Ordre;
import FunctionLayer.OrdreRetrivalException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdreMapper {

    public static Ordre getOrdre(String OrdreNr, String brugerID ) throws OrdreRetrivalException {
        Fkunde fkunde = new FKunde();
        //skaber en kunde først
        String navn;
        String adresse;
        String by;
        String telefon;
        String email;


        try {
            Connection con = Connector.connection();
            String SQL = "SELECT navn, adresse, postnummer, telefon, email  FROM bruger"
                    + "WHERE brugerID=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, OrdreNr );
            ResultSet rs = ps.executeQuery();
            //alle de her skal instiseres når db er klar

            double carportLængde = rs.getDouble("carportLængde");
            double carportBredde = rs.getDouble("carportBredde");
            int tagtypeNr = rs.getInt("tagtypeNr");


            //double tæghældning = 0;
            //boolean redskabsrum = false;

            double redskabsrumBredde = 0;
            double redskabsrumLængde = 0;

           /* if(redskabsrum){
            double redskabsrumBredde = rs.getDouble("redskabsrumBredde");
            double redskabsrumLængde = rs.getDouble("redskabsrumLængde");}
            */

            Carport carport = new Carport(carportLængde, carportBredde, tagtypeNr, redskabsrumBredde, redskabsrumLængde);

            if ( rs.next() ) {
                // en masse Carport.set; her
                return carport;
            } else {
                throw new OrdreRetrivalException( "Could not retrive data from database" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new OrdreRetrivalException(ex.getMessage());
        }





        try {
            Connection con = Connector.connection();
            String SQL = "SELECT carportLængde, carportBredde, tagtypeNr, redskabsrumBredde, redskabsrumLængde FROM carport "
                    + "WHERE ordreNr=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, OrdreNr );
            ResultSet rs = ps.executeQuery();
            //alle de her skal instiseres når db er klar

            double carportLængde = rs.getDouble("carportLængde");
            double carportBredde = rs.getDouble("carportBredde");
            int tagtypeNr = rs.getInt("tagtypeNr");


            //double tæghældning = 0;
            //boolean redskabsrum = false;

            double redskabsrumBredde = 0;
            double redskabsrumLængde = 0;

           /* if(redskabsrum){
            double redskabsrumBredde = rs.getDouble("redskabsrumBredde");
            double redskabsrumLængde = rs.getDouble("redskabsrumLængde");}
            */

            Ordre ordre = new Ordre();
1
            if ( rs.next() ) {
                // en masse Carport.set; her
                return ordre;
            } else {
                throw new OrdreRetrivalException( "Could not retrive data from database" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new OrdreRetrivalException(ex.getMessage());
        }

}

}
