package FunctionLayer;

import DBAccess.*;
import DBAccess.UserMapper;

import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    }


    public static User createUser(String email, String password, String telefonnummer,
                                   String adresse, String navn, int postnummer, String by ) throws LoginSampleException {


        User user = new User(navn, adresse, by, telefonnummer, email, password, postnummer);

        return UserMapper.createUser( user );
    }



    public static void sendForspørgsel(Ordre carport, User kunde){
    try {
        OrdreMapper.createOrder(kunde, carport);
    } catch (OrdreRetrivalException e) {
        System.out.println(e);
    }

    }


    public static ArrayList<Ordre> hentAlleOrdre(){
        try {


            ArrayList<Ordre> xs = OrdreMapper.getAlleOrdre();
            for (int i = 0; i < xs.size(); i++) {
                System.out.println(xs);
            }

            return xs;

        } catch (OrdreRetrivalException e) {
            e.printStackTrace();
        }

        return null;
    }
}
