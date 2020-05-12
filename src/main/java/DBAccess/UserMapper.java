package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Notification;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 The purpose of UserMapper is to...

 */
public class UserMapper {

    /**
     * Metoden er bruges til at indsæte et User objekt i DB'en.
     * @param user angiver hvilken user der skal indsættes i DB'en
     * @return Retunere et nyt User object, nu med de ID den har inde i DB'en.
     * @throws LoginSampleException
     */
    public static User createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO bruger (email, password, rolle, adresse, postnr, telefon, navn) " +
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
            return user;
        } catch ( SQLException | NumberFormatException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }


    /**
     * Denne metode finder og henter en user ved hjælp af Email og password.
     * @param email
     * @param password
     * @return retunere så et user object.
     * @throws LoginSampleException
     */
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
                String rolle = rs.getString( "rolle" );
                int id = rs.getInt( "brugerId" );
                String navn = rs.getString("navn");
                String telefon = rs.getString("telefon");
                String emails = rs.getString("email");
                String adresse = rs.getString("adresse");
                int postnr = rs.getInt("postnr");
                User user = new User( email, password, rolle, telefon, email, id, password, postnr, rolle);
                user.setId( id );

                return user;
            } else {

                return null; // return null and the function caller will handle
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    /**
     * Denne metode henter alle users ned fra DB'en
     * @return Retunere en Arraylist med alle users.
     * @throws LoginSampleException
     */
    public static ArrayList<User> getAllUsers() throws LoginSampleException {

        ArrayList<User> userList = new ArrayList();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM bruger";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );

            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                String rolle = rs.getString( "rolle" );
                int id = rs.getInt( "brugerId" );
                String navn = rs.getString("navn");
                String telefon = rs.getString("telefon");
                String emails = rs.getString("email");
                String adresse = rs.getString("adresse");
                int postnr = rs.getInt("postnr");
                User user = new User(navn, adresse, "by", telefon, emails, id,postnr,rolle);
                userList.add(user);

            }
            return userList;
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }

    }


    public static ArrayList<Notification> getUsersNotifications(User user) throws LoginSampleException {

        ArrayList<Notification> notiList = new ArrayList();
        try {
            Connection con = Connector.connection();
            int brugerID = user.getId();
            String SQL = "SELECT * FROM notificationer WHERE brugerId = " + brugerID;

            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );

            ResultSet rs = ps.executeQuery();
            while ( rs.next() ) {
                String beskrivelse = rs.getString( "beskrivelse" );
                int notificationsID = rs.getInt( "notificationId" );
                Boolean ny = rs.getBoolean("ny");
                Notification noti = new Notification(user.getId(), beskrivelse);
                noti.setNotificationID(notificationsID);
                noti.setNy(ny);
                notiList.add(noti);


            }
            return notiList;
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


    public static void resetNotificationer( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE notificationer SET ny = 0 WHERE brugerId = " + user.getId();
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.executeUpdate();
        } catch ( SQLException | NumberFormatException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public void sletUser(int Id) throws SQLException, ClassNotFoundException {
        try {
            Connection con = Connector.connection();
            String SQL = "DELETE FROM bruger Where brugerId = " + "" +Id+ "" ;
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.executeUpdate();
        } catch ( ClassNotFoundException | SQLException ex ) {
            System.out.println(ex);
        }
    }


}
