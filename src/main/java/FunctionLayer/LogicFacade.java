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
