package DBAccess;

import FunctionLayer.*;
import PresentationLayer.Register;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class OrdreMapperTest {

/*
 Dette er intergration testing. Vi dykker nemlig ned og forsøger at lægge og hente data i DB'en.
 */
    private static Connection testConnection;
    private static  String URL = "jdbc:mysql://localhost:3306/fog_db?serverTimezone=CET&useSSL=false";
    private static   String USERNAME = "tobias";
    private static   String  PASSWORD = "password";

   private static ArrayList<Ordre> odre;

    @Before
    public void setUp() {
        try {
            // awoid making a new connection for each test
            if ( testConnection == null ) {

                testConnection = DriverManager.getConnection( URL, USERNAME, PASSWORD );
                // Make mappers use test
                Connector.setConnection( testConnection );
            }
            System.out.println("before");
     getAlleOrdre();

        } catch (SQLException | OrdreRetrivalException ex ) {
            testConnection = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    @Test
    public void getAlleOrdre() throws OrdreRetrivalException {
        // Virker selvfølgelig kun hvis der er en odre i DB...
        odre = LogicFacade.hentAlleOrdre();
     //  odre = OrdreMapper.getAlleOrdre();
        assertTrue( odre != null );

    }

    @Test
    public void createOrder() throws OrdreRetrivalException, LoginSampleException {
        // OBS. Vil ikke fungere hvis registrer ikke fungere eller carport ikke funger

        User user = new User("Test","Test","Test","test","test@test.dk", "",2000,"Kunde");
        Carport carp = new Carport(240.0, 240.0,1,0.0, 0,0);
        user.setId(1);
        // Vi skulle få en exception hvis odreren ikke går igennem
        OrdreMapper.createOrder(new Ordre(carp, user));

        // For at teste med ekstra sikkerhed kan vi tjekke om listen med alle odre bliver 1 længerer
        // Dette afhænger dog af at getAlleOrdre virker.
        int before = odre.size();
        int after = OrdreMapper.getAlleOrdre().size();

        assertTrue(before + 1 == after);
    }



}
