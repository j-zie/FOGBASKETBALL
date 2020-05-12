package PresentationLayer;

import DBAccess.MaterialeMapper;
import FunctionLayer.*;
import SVG.SvgCarport;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Optional;

/**
 * TODO(Jonathan) PATRICK: nice skrevet! især de klasse private metoder, det glemmer jeg ofte. fix lige indents og white space, please
 * QuickByg modtager http request fra formen under quickbyg siden, kontrollere input og
 * vil ved gyldigt input putte formens informationer i databasen gennem kaldet til LogicFacade.sendForspørgsel
 * Den modtager http requests og retunere strenge der repræsenere filstier til andre jsp pages.
 */
public class QuickByg extends Command{
    /**
     * QuickByg modtager http request fra formen under quickbyg siden, kontrollere input og
     *
     * @return Retunere en jsp side. Har som sideeffekt et funktionskald der gemmer ordren i databasen
     * @param request Request fra jsp side skal indeholde alle felter der beskriver en carports tilstand.
     * @param response Header informationer
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        String to = request.getParameter("to");

        switch (to) {

            case "Fladt":
                return "QuickByg/FladtTagpage";

            case "Rejsning":
                return "QuickByg/RejsningTagpage";

            case "FladtTagOrdrebekræft":
                Boolean fejlFundet = tjekFelter(request);
                if (fejlFundet == true) {
                    return "QuickByg/FladtTagpage";
                }
                String tagtypeNavn = "";
                MaterialeMapper mp = new MaterialeMapper();
                Carport carport = sammenSætCarport(request, Tag.Fladt);
                User kunde = (User) session.getAttribute("user");
                LogicFacade.sendForspørgsel(new Ordre(carport, kunde));
                SvgCarport svg = new SvgCarport();
                int bredde = Integer.parseInt(request.getParameter("Bredde"));
                int længde = Integer.parseInt(request.getParameter("Længde"));
                int skurbredde = Integer.parseInt(request.getParameter("Redskabsrum_bredde"));
                int skurlængde = Integer.parseInt(request.getParameter("Redskabsrum_længde"));
                request.setAttribute("tagtypeNavn",getTagNavnudFraTagNrQuickBygLokalMetode(Integer.parseInt(request.getParameter("tagtype"))));

                request.setAttribute("svgCarport", svg.Build(længde, bredde, skurbredde, skurlængde));

                return "QuickByg/Bekræftelse";

            case "RejsningTagOrdrebekræft":
                fejlFundet = tjekFelterRejsning(request);
                if (fejlFundet == true) {
                    return "QuickByg/RejsningTagpage";
                }
                carport = sammenSætCarport(request, Tag.Rejsning);
                kunde = (User) session.getAttribute("user");
                LogicFacade.sendForspørgsel(new Ordre(carport, kunde));
                SvgCarport svg2 = new SvgCarport();
                int bredde2 = Integer.parseInt(request.getParameter("Bredde"));
                int længde2 = Integer.parseInt(request.getParameter("Længde"));
                int skurbredde2 = Integer.parseInt(request.getParameter("Redskabsrum_bredde"));
                int skurlængde2 = Integer.parseInt(request.getParameter("Redskabsrum_længde"));
                request.setAttribute("tagtypeNavn",getTagNavnudFraTagNrQuickBygLokalMetode(Integer.parseInt(request.getParameter("tagtype"))));
                request.setAttribute("taghældning",request.getParameter("Taghældning"));
                request.setAttribute("svgCarport", svg2.Build(længde2, bredde2, skurbredde2, skurlængde2));
                return "QuickByg/Bekræftelse";



        }

        return "fail"; // Lav error handle
    }


    enum Tag {
        Fladt,
        Rejsning
    }

    /**
     * Privat metoder der laver en carport fra informationer i request scope
     * @return Retunere et carport objekt
     * @param request Request fra jsp side skal indeholde alle felter der beskriver en carports tilstand.
     */
    private Carport sammenSætCarport(HttpServletRequest request, Tag tag){

        Double bredde = Double.parseDouble(request.getParameter("Bredde"));
        Double længde = Double.parseDouble(request.getParameter("Længde"));
        int tagtype = Integer.parseInt(request.getParameter("tagtype"));
        Double redskabsrum_bredde = Double.parseDouble(request.getParameter("Redskabsrum_bredde"));
        Double redskabsrum_længde = Double.parseDouble(request.getParameter("Redskabsrum_længde"));

        switch (tag) {
            case Fladt:
                Carport carport = new Carport(længde,
                        bredde,
                        1,
                        0.0,
                        redskabsrum_længde,
                        redskabsrum_bredde);
                return carport;

            case Rejsning:
                Double hældning = Double.parseDouble(request.getParameter("Taghældning"));
                Carport carport2 = new Carport(længde,
                        bredde,
                        tagtype,
                        hældning,
                        redskabsrum_længde,
                        redskabsrum_bredde);
                return carport2;


            default: return null;
        }
    }


    /**
     * Privat metode der validere informationer i requestscope
     * @return Boolean der bestemmer om carporten bliver sendt til databasen
     * @param request Request fra jsp side skal indeholde alle felter der beskriver en carports tilstand.
     */
    private Boolean tjekFelter(HttpServletRequest request) throws LoginSampleException {
        Boolean fejfundet = false;
        String bredde = request.getParameter("Bredde");
        String længde = request.getParameter("Længde");

        String tagtype = request.getParameter("tagtype");
        String redskabsrum_bredde = request.getParameter("Redskabsrum_bredde");
        String redskabsrum_længde = request.getParameter("Redskabsrum_længde");

        // Sætter alle sammen op på request scopet, så kunden ikke behøver indtaste det hele igen.
        request.setAttribute("Bredde", bredde);
        request.setAttribute("Længde", længde );
        request.setAttribute("tagtype", tagtype);
        request.setAttribute("Redskabsrum_bredde", redskabsrum_bredde );
        request.setAttribute("Redskabsrum_længde", redskabsrum_længde );


        if (bredde.length() < 2) {
            request.setAttribute("breddeError", "Udfyld venligst felt");
            fejfundet = true;
            return fejfundet;
        }

        if (længde.length() < 2) {
            request.setAttribute("længdeError", "Udfyld venligst felt");
            fejfundet = true;
            return fejfundet;
        }
        if (!tagtype.equals("1")) {
            request.setAttribute("tagError", "Udfyld venligst felt");
            fejfundet = true;
            return fejfundet;
        }


        if ((Integer.parseInt(redskabsrum_bredde) + 90) > Integer.parseInt(bredde)) {
            request.setAttribute("skurBreddeError", "Skur for stort til carport");
            fejfundet = true;
        }
        if ((Integer.parseInt(redskabsrum_længde) + 30)  > Integer.parseInt(længde)) {
            request.setAttribute("skurLængdeError", "Skur for stort til carport");
            fejfundet = true;
        }


        return fejfundet;
    }


    private Boolean tjekFelterRejsning(HttpServletRequest request) throws LoginSampleException {
        Boolean fejfundet = false;
        String bredde = request.getParameter("Bredde");
        String længde = request.getParameter("Længde");

        String tagtype = request.getParameter("tagtype");
        String redskabsrum_bredde = request.getParameter("Redskabsrum_bredde");
        String redskabsrum_længde = request.getParameter("Redskabsrum_længde");

        // Sætter alle sammen op på request scopet, så kunden ikke behøver indtaste det hele igen.
        request.setAttribute("Bredde", bredde);
        request.setAttribute("Længde", længde );
        request.setAttribute("tagtype", tagtype);
        request.setAttribute("Redskabsrum_bredde", redskabsrum_bredde );
        request.setAttribute("Redskabsrum_længde", redskabsrum_længde );


        if (bredde.length() < 2) {
            request.setAttribute("breddeError", "Udfyld venligst felt");
            fejfundet = true;
            return fejfundet;
        }

        if (længde.length() < 2) {
            request.setAttribute("længdeError", "Udfyld venligst felt");
            fejfundet = true;
            return fejfundet;
        }
        if (tagtype.equals("0")) {
            request.setAttribute("tagError", "Udfyld venligst felt");
            fejfundet = true;
            return fejfundet;
        }


        if ((Integer.parseInt(redskabsrum_bredde) + 90) > Integer.parseInt(bredde)) {
            request.setAttribute("skurBreddeError", "Skur for stort til carport");
            fejfundet = true;
        }
        if ((Integer.parseInt(redskabsrum_længde) + 30)  > Integer.parseInt(længde)) {
            request.setAttribute("skurLængdeError", "Skur for stort til carport");
            fejfundet = true;
        }


        return fejfundet;
    }


    private String getTagNavnudFraTagNrQuickBygLokalMetode(int tagtypeNr){
        MaterialeMapper mp = new MaterialeMapper();
        try {
            return mp.getTagNavn(tagtypeNr);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

}
