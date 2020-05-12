package DBAccess;

import FunctionLayer.*;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class MaterialeMapperTest {
    private static Connection testConnection;
    private static  String URL = "jdbc:mysql://localhost:3306/fog_db?serverTimezone=CET&useSSL=false";
    private static  String USERNAME = "tobias";
    private static  String  PASSWORD = "password";
    private static  ArrayList<Materiale> materialeListe;
    private static MaterialeMapper materialeMapper = new MaterialeMapper();

    @Before
    public void setUp() {
        try {
            // awoid making a new connection for each test
            if ( testConnection == null ) {

                testConnection = DriverManager.getConnection( URL, USERNAME, PASSWORD );
                // Make mappers use test
                Connector.setConnection( testConnection );
            }

        } catch (SQLException ex ) {
            testConnection = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    /**
     * Vi tjekker om der kan hentes en materialliste ned fra databasen. Hvis arraylisten ikke er tom er dette tilfældet.
     * @throws OrdreRetrivalException
     */
    @Test
    public void getAlleMaterialer() {
        materialeListe = MaterialeMapper.getAlleMaterialer();

        assertTrue( materialeListe != null );

    }

    /**
     * vi tjekker om der oprettes et materiale i databasen. Hvis arraylisten bliver større må dette ske.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Test
    public void opretMateriale() throws  SQLException, ClassNotFoundException {
        materialeMapper.opretMateriale("test","test","test",1, "/");
        assertTrue(MaterialeMapper.getAlleMaterialer().size() > 1);
    }

    /**
     * vi tjekker om der slettes et materiale i databasen. Hvis arraylisten bliver mindre må dette ske.
     * @throws SQLException
     * @throws ClassNotFoundException
     */

    @Test
    public void sletMateriale() throws  SQLException, ClassNotFoundException {
        ArrayList<Materiale> testarraylist = MaterialeMapper.getAlleMaterialer();
        materialeMapper.sletMateriale(MaterialeMapper.getAlleMaterialer().size() - 1);
        assertTrue(MaterialeMapper.getAlleMaterialer().size() < testarraylist.size());
    }

    /**
     * Vi tjekker om der kommer noget tilbage fra databasen. Det kræves at der ligger noget i tagtabellen. Dette skulle ske når databasen bliver skabt
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Test
    public void getTagNavn() throws SQLException, ClassNotFoundException {

        assertTrue(materialeMapper.getTagNavn(1) != null);

    }
}