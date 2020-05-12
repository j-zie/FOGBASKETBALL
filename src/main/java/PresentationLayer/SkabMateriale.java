package PresentationLayer;

import DBAccess.MaterialeMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
/**
 * Denne klasse tager input fra en form på jsp siden og sender dem ned i opretMateriale metoden i MaterialeMapperen.
 * Derfra kommer de så i databasen og et nyt materiale er oprettet
 * Materialet bLiver skabt pt. Med Navn, Beskrivelse, "Tag" (engelske ord) og Pris.TODO:: Få billeder med ned?
 **/
/*
public class SkabMateriale extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        Double MaterialePris;
        MaterialeMapper mp = new MaterialeMapper();
        String MaterialeNavn = request.getParameter("materialeNavn");
        String MaterialeBeskrivelse = request.getParameter("materialeBeskrivelse");
        String tag = request.getParameter("tag");



        try {
                MaterialePris = Double.parseDouble(request.getParameter("pris"));
            } catch (NumberFormatException e) {
                request.setAttribute("errorPris", "Ugyldig Pris");
                return "SkabMateriale";

            }

            if (validering(MaterialeNavn, MaterialeBeskrivelse, tag, request) == false) {
                return "SkabMateriale";

            }
            try {
                mp.opretMateriale(MaterialeNavn, MaterialeBeskrivelse, tag, MaterialePris);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return "admin";
        }
        public boolean validering(String MaterialeNavn, String MaterialeBeskrivelse, String tag, HttpServletRequest
        request){
            if (MaterialeNavn.equals("")) {
                request.setAttribute("errorNavn", "Ugyldigt Materiale Navn");
                return false;
            }
            if (MaterialeBeskrivelse.equals("")) {
                request.setAttribute("errorBeskrivelse", "Ugyldigt Materiale Beskrivelse");
                return false;
            }

            if (tag.equals("")) {
                request.setAttribute("errorTag", "Ugyldigt Materialegruppering");
                return false;
            }

            return true;
        }

    }
*/