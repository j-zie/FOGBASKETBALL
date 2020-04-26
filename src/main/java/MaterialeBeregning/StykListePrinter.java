package MaterialeBeregning;

import FunctionLayer.Ordre;
import FunctionLayer.OrdreListe;
import FunctionLayer.OrdreRetrivalException;

public class StykListePrinter {
    //TODO det her burde være skrevet bedre. Klokken er snart 4.
    OrdreListe generatedLists;
    Ordre ordre;
    StringBuilder textToScreen = new StringBuilder();
    MængdeBeregner mængder;
    public StykListePrinter(int orderNum){ // eh
        generatedLists = new OrdreListe();
        ordre = generatedLists.getOrderFromOrderNumber(orderNum);
        mængder = new MængdeBeregner(ordre);
    }

    public String printEverything() {
        orderInfoHeader();
        startTable();
        //Should have some ehh composition this ;)))
        insertElement(0.00, "Trykimprægnerede stolper 100x100mm", mængder.antalStolper());
        insertElement(0.00, "Spær", mængder.antalSpaer());
        insertElement(0.00, "Trapezplader", 6);
        insertElement(0.00, "vinkelbeslag, 50x50x1,5x35mm", mængder.antalSpaer()*2);
        insertElement(0.00, "Cement", 1);
        insertElement(0.00, "Stolpesko", mængder.antalStolper());
        insertElement(0.00, "Rem", 4);
        insertElement(0.00, "Sternbræt", 4);
        endTable();
        return textToScreen.toString();
    }

    public void orderInfoHeader() {
        textToScreen.append("<h4> Carport til: ");
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
                "      </table>");
    }

    public void insertElement(double pris, String item, int antal) {
        textToScreen.append("          <tr>\n" +
                "            <td>" + antal+ "</td>\n" +
                "            <td>" + item + "</td>\n" +
                "            <td>" + pris + "</td>\n" +
                "          </tr>");
    }
}
