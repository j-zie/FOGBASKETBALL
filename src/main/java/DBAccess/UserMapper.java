package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO bruger (email, password, role, adresse, postNr, telefonNummer, navn) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.setString(4, user.getAdresse());
            ps.setInt(5, user.getPostnr());
            ps.setString(6, user.getTelefon());
            ps.setString(7, user.getNavn());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM bruger "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, email );
            ps.setString( 2, password );

            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "rolle" );
                int id = rs.getInt( "brugerId" );
                String navn = rs.getString("navn");
                String telefon = rs.getString("telefonNummer");
                String emails = rs.getString("email");
                String adresse = rs.getString("adresse");
                int postnr = rs.getInt("postNr");
                User user = new User( email, password, role, telefon, email, id, password, postnr);
                user.setId( id );
                return user;
            } else {
                return null; // return null and the function caller will handle
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}
