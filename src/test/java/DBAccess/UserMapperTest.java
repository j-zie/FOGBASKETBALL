package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class UserMapperTest {
//    Test date in the UsersTest table
//    INSERT INTO `UsersTest` VALUES
//    (1,'jens@somewhere.com','jensen','customer'),
//    (2,'ken@somewhere.com','kensen','customer'),
//    (3,'robin@somewhere.com','batman','employee'),
//    (4,'someone@nowhere.com','sesam','customer');

    private static Connection testConnection;
    private static  String URL = "jdbc:mysql://localhost:3306/fog_db?serverTimezone=CET&useSSL=false";
    private static   String USERNAME = "tobias";
    private static   String  PASSWORD = "password";



    @Before
    public void setUp() {
        try {
            // awoid making a new connection for each test
            if ( testConnection == null ) {

                testConnection = DriverManager.getConnection( URL, USERNAME, PASSWORD );
                // Make mappers use test
                Connector.setConnection( testConnection );
            }
            // reset test database
            /*
            try ( Statement stmt = testConnection.createStatement() ) {
                stmt.execute( "drop table if exists Users" );
                stmt.execute( "create table Users like UsersTest" );
                stmt.execute( "insert into Users select * from UsersTest" );
            }
            */
        } catch ( SQLException ex ) {
            testConnection = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }


    @Test
    public void testCreateUser() throws LoginSampleException {
        User user = new User("Test","Test","test","test","test","test",200,"kunde");

        // If error we should get a exception and the test would fail
       User test = UserMapper.createUser(user);

       // Hvis brugeren faktisk bliver sat ind i DB'en burde id blive sat til et tal større end 0
       assertTrue(test.getId() > 0);

    }










    // LOGIN TEST
    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull( testConnection );
    }

    @Test
    public void testLogin01() throws LoginSampleException {
        // Can we log in
        User user = UserMapper.login( "Test", "Test" );
        assertTrue( user != null );
    }

    @Test
    public void testLogin02() throws LoginSampleException {
        // We should not get a user if we use the wrong password
        User user = UserMapper.login( "Test", "wrongPassword" );
        assertTrue(user == null);
    }

    @Test
    public void testLogin03() throws LoginSampleException {
        // Jens is supposed to be a customer
        User user =  UserMapper.login( "Test", "Test" );
        assertEquals( "kunde", user.getRole() );
    }

    /*@Test
    public void testCreateUser01() throws LoginSampleException {
        // Can we create a new user - Notice, if login fails, this will fail
        // but so would login01, so this is OK
        User original = new User( "king@kong.com", "uhahvorhemmeligt", "konge" );
        UserMapper.createUser( original );
        User retrieved = UserMapper.login( "king@kong.com", "uhahvorhemmeligt" );
        assertEquals( "konge", retrieved.getRole() );
    } */
}
