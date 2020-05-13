package MaterialeBeregning;

import DBAccess.StykListeMapper;
import FunctionLayer.Materiale;
import FunctionLayer.MaterialeListe;
import FunctionLayer.Ordre;
import FunctionLayer.OrdreListe;

import java.util.ArrayList;

/**
 * Denne klasse kræver et ordreNr til blive instansieret. Da bliver så hentet en ordre med det pågældende Ordrennummer fra DB'en.
 * @return Med metoden @see kan du så få en stykliste (Html-table) med værdier fra den hentede ordre.
 * @see MængdeBeregner Samtidigt bliver der kaldt på mængdeberegner klassen. Det antal materialer som den udregner kommer så med i tabellen.
 */
public class StykListePrinter {
    //TODO det her burde være skrevet bedre. Klokken er snart 4.

    OrdreListe generatedLists;
    Ordre ordre;
    StringBuilder textToScreen = new StringBuilder();
    MængdeBeregner mængder;
    MaterialeListe alleMaterialer;
    MaterialeListe materialerTilPrint;
    double totalPrice = 0;
    ArrayList<Integer> materialeIDs;

    public StykListePrinter(int orderNum){ // eh
        generatedLists = new OrdreListe();
        ordre = generatedLists.getOrderFromOrderNumber(orderNum);
        mængder = new MængdeBeregner(ordre);
        alleMaterialer = new MaterialeListe();
        materialeIDs =  StykListeMapper.getIDOfComponents(ordre);
        materialerTilPrint = alleMaterialer.getMaterialeListFromOrder(materialeIDs);

    }

    /**
     * @return et html table med værdier fra ordrenr som er krævet for at kalde klassen
     *
     */
    public String print() {
        orderInfoHeader();
        startTable();
        /*
        insertElementAndAddToTotalCost(materialer.getMaterialeBytag("default_stolpe").getPris(),
                      materialer.getMaterialeBytag("default_stolpe").getMaterialeNavn(),
                      mængder.antalStolper());

        insertElementAndAddToTotalCost(materialer.getMaterialeBytag("default_spær").getPris(),
                      materialer.getMaterialeBytag("default_spær").getMaterialeNavn(),
                      mængder.antalSpaer());

         */


        for (Materiale i : materialerTilPrint) {
            insertElementAndAddToTotalCost(i.getPris(), i.getMaterialeNavn(), 4);
        }

        // Ikke flere hardcodede ting 
        //    insertElement(184.00, "Trapezplader", 6);
        //insertElement(3.75, "vinkelbeslag, 50x50x1,5x35mm", mængder.antalSpaer()*2);
        //insertElement(33.25, "Cement", 1);
        //insertElement(39.90, "Stolpesko", mængder.antalStolper());
        //insertElement(167.65, "Rem", 4);
        //insertElement(15.25, "Sternbræt", 4);
        endTable();
        return textToScreen.toString();
    }


    public void orderInfoHeader() {
        textToScreen.append("<h4> Carport til: </h4>");
        textToScreen.append(ordre.getUser().getNavn());
        textToScreen.append(" (");
        textToScreen.append(ordre.getUser().getTelefon());
        textToScreen.append(") - ");
        textToScreen.append(ordre.getUser().getAdresse());
    }

    public void startTable() {
        textToScreen.append("      <table class=\"highlight\">\n" +
                "        <thead>\n" +
                "          <tr>\n" +
                "              <th>Antal</th>\n" +
                "              <th>Vare Navn</th>\n" +
                "              <th>Vare Pris</th>\n" +
                "          </tr>\n" +
                "        </thead>\n" +
                "        <tbody>\n");
                // Husk at endtable!
    }

    public void endTable() {
        textToScreen.append("        </tbody>\n" +
                "      </table>" +
                "<br>" +
                "<h5>Din carports materiale pris er: " + totalPrice + " kr");
    }

    public void insertElementAndAddToTotalCost(double pris, String item, int antal) {
        //Adds to the total price an effect
        totalPrice += pris*antal;

        textToScreen.append("          <tr>\n" +
                "            <td>" + antal+ "</td>\n" +
                "            <td>" + item + "</td>\n" +
                "            <td>" + pris + "</td>\n" +
                "          </tr>");
    }
}
