package FunctionLayer;

import DBAccess.*;
import com.sun.tools.corba.se.idl.constExpr.Not;

import java.util.ArrayList;

/**
 * Formålet med loginfacade er at oprette en bruger til jsp siden
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    }


    public static User createUser(String email, String password, String telefonnummer,
                                   String adresse, String navn, int postnummer, String by, String rolle ) throws LoginSampleException {


        User user = new User(navn, adresse, by, telefonnummer, email, password, postnummer, rolle);

        return UserMapper.createUser( user );
    }


    /**
     * Denne metoder går ned på DB niveau og får den til at lave en ny ordre.
     * @param ordre er af typen ordreObjekt, der indeholder en carport og en kunde
     */
    public static void sendForspørgsel(Ordre ordre){
    try {
        OrdreMapper.createOrder(ordre);
    } catch (OrdreRetrivalException e) {
        System.out.println(e);
    }
    }

    /**
     * Denne metode looper henter alle ordre
     *  getAlleoOrdre fra @OrdreMapper bliver her kaldt og loopet igennem og smidt ned i et Array
     */
    public static ArrayList<Ordre> hentAlleOrdre(){
        try {


            ArrayList<Ordre> xs = OrdreMapper.getAlleOrdre();
            for (int i = 0; i < xs.size(); i++) {
                System.out.println(xs.get(i).getUser().getNavn());
            }

            return xs;

        } catch (OrdreRetrivalException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * Denne metode bruges til at finde finde antallet af admins der er registeret.
     *  getAllUseres fra @UserMapper bliver her kaldt og loopet igennem og retunere antalet af admins
     */
    public static int getAntalAdmin() throws LoginSampleException {
        ArrayList<User> userliste = UserMapper.getAllUsers();
        int antal = 0;
        for (User user : userliste) {
            if (user.getRole().equals("Admin")) {
                antal++;
            }
        }
        return antal;
    }
    /**
     * Denne metode bruges til at finde finde antallet af kunder der er registeret.
     *  getAllUseres fra @UserMapper bliver her kaldt og loopet igennem og retunere antallet af kunder
     */
    public static int getAntalKunder() throws LoginSampleException {
        ArrayList<User> userliste = UserMapper.getAllUsers();
        int antal = 0;
        for (User user : userliste) {
            if (!user.getRole().equals("Admin")) {
                antal++;
            }
        }
       return antal;
    }


    public static ArrayList<Notification> getNotificationer(User user) throws LoginSampleException {

        ArrayList<Notification> notifications = UserMapper.getUsersNotifications(user);

        if (notifications.isEmpty()) {
            return null;
        }

       return notifications;
    }

    public static int antalNyeNotificationer( ArrayList<Notification> notiList){
        int antal = 0;
        if (notiList != null) {
            for (Notification noti : notiList) {
                if (noti.getNy() == true) {
                    antal++;
                }
            }
        }
        return antal;
    }

    public static ArrayList<Notification> resetNotiss(User user, ArrayList<Notification> notiList) throws LoginSampleException {
        if (notiList != null) {
            UserMapper.resetNotificationer(user);
            for (Notification noti : notiList) {
                noti.setNy(false);
            }
            return notiList;
        }
     return null;
    }


}
